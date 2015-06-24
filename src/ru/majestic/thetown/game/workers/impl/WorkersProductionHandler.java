package ru.majestic.thetown.game.workers.impl;

import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.IWorkersProductionHandler;
import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class WorkersProductionHandler implements Runnable, IWorkersProductionHandler {
   
   private static final int TIMEOUT = 1000;
   
   private static final String PREFFS_NAME               = "THE_TOWN_PREFFS";
   
   private static final String SAVE_TAG_CLOSE_GAME_TIME  = "SAVE_TAG_CLOSE_GAME_TIME";
   
   private OnWokersProductionCompleteListener onWokersProductionCompleteListener;
   
   private boolean            alreadyLoaded;
   private boolean            working;
   private IWorkersManager    workersManager;
   
   public WorkersProductionHandler(IWorkersManager workersManager) {
      this.workersManager  = workersManager;
      this.alreadyLoaded   = false;
   }
   
   @Override
   public void start() {
      if(!working) {
         working = true;      
         new Thread(this).start();
      }
   }

   @Override
   public void stop() {
      working = false;
   }

   @Override
   public void setOnWokersProductionCompleteListener(OnWokersProductionCompleteListener onWokersProductionCompleteListener) {
      this.onWokersProductionCompleteListener = onWokersProductionCompleteListener;
   }

   @Override
   public void run() {      
      while(working) {
         try {
            Thread.sleep(TIMEOUT);
         } catch (InterruptedException e) {}
                  
         if(working) {
            onWokersProductionCompleteListener.onWorkersProductionComplete(workersManager.getResourcesPerSecond(WorkerType.FOOD), workersManager.getResourcesPerSecond(WorkerType.WOOD));
         }
      }      
   }

   @Override
   public void load(Context context) {
      if(!alreadyLoaded) {
         alreadyLoaded = true;
         long closeGameTime = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE).getLong(SAVE_TAG_CLOSE_GAME_TIME, System.currentTimeMillis());         
         int gameTopInSeconds = (int) ((System.currentTimeMillis() - closeGameTime) / 1000);         
         
         onWokersProductionCompleteListener.onWorkersProductionComplete(workersManager.getResourcesPerSecond(WorkerType.FOOD) * gameTopInSeconds, workersManager.getResourcesPerSecond(WorkerType.WOOD) * gameTopInSeconds);
      }
   }

   @Override
   public void save(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();
      
      editor.putLong(SAVE_TAG_CLOSE_GAME_TIME, System.currentTimeMillis());
      
      editor.commit();
      
      alreadyLoaded = false;
   }

}
