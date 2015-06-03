package ru.majestic.thetown.game.workers.impl;

import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.IWorkersProductionHandler;
import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;

public class WorkersProductionHandler implements Runnable, IWorkersProductionHandler {

   private OnWokersProductionCompleteListener onWokersProductionCompleteListener;
   
   private boolean            working;
   private IWorkersManager    workersManager;
   
   public WorkersProductionHandler(IWorkersManager workersManager) {
      this.workersManager = workersManager;
   }
   
   @Override
   public void start() {
      this.working = true;
      
      new Thread(this).start();
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
            Thread.sleep(1000);
         } catch (InterruptedException e) {}
                  
         if(working)
            onWokersProductionCompleteListener.onWorkersProductionComplete(workersManager.getResourcesPerSecond(WorkerType.FOOD), workersManager.getResourcesPerSecond(WorkerType.WOOD));
      }
      
   }

}
