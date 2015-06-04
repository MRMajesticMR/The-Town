package ru.majestic.thetown.game.impl;

import java.util.HashMap;
import java.util.Iterator;

import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.game.workers.AFoodWorker;
import ru.majestic.thetown.game.workers.AWoodWorker;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.defence.DefenceWorkerRank1;
import ru.majestic.thetown.game.workers.defence.DefenceWorkerRank2;
import ru.majestic.thetown.game.workers.defence.DefenceWorkerRank3;
import ru.majestic.thetown.game.workers.defence.DefenceWorkerRank4;
import ru.majestic.thetown.game.workers.defence.DefenceWorkerRank5;
import ru.majestic.thetown.game.workers.food.FoodWorkerRank1;
import ru.majestic.thetown.game.workers.food.FoodWorkerRank2;
import ru.majestic.thetown.game.workers.food.FoodWorkerRank3;
import ru.majestic.thetown.game.workers.food.FoodWorkerRank4;
import ru.majestic.thetown.game.workers.food.FoodWorkerRank5;
import ru.majestic.thetown.game.workers.wood.WoodWorkerRank1;
import ru.majestic.thetown.game.workers.wood.WoodWorkerRank2;
import ru.majestic.thetown.game.workers.wood.WoodWorkerRank3;
import ru.majestic.thetown.game.workers.wood.WoodWorkerRank4;
import ru.majestic.thetown.game.workers.wood.WoodWorkerRank5;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class WorkersManager implements IWorkersManager {

   private static final int TOTAL_WORKERS_COUNT = 5;
   
   private static final int RANK_1 = 0;
   private static final int RANK_2 = 1;
   private static final int RANK_3 = 2;
   private static final int RANK_4 = 3;
   private static final int RANK_5 = 4;   
   
   private HashMap<IWorker.WorkerType, IWorker[]> workers;
   
   public WorkersManager() {
      workers = new HashMap<IWorker.WorkerType, IWorker[]>();
   
      IWorker[] woodWorkers         = new AWoodWorker[TOTAL_WORKERS_COUNT];
      woodWorkers[RANK_1]           = new WoodWorkerRank1();
      woodWorkers[RANK_2]           = new WoodWorkerRank2();
      woodWorkers[RANK_3]           = new WoodWorkerRank3();
      woodWorkers[RANK_4]           = new WoodWorkerRank4();
      woodWorkers[RANK_5]           = new WoodWorkerRank5();
   
      IWorker[] foodWorkers         = new AFoodWorker[TOTAL_WORKERS_COUNT];
      foodWorkers[RANK_1]           = new FoodWorkerRank1();            
      foodWorkers[RANK_2]           = new FoodWorkerRank2();            
      foodWorkers[RANK_3]           = new FoodWorkerRank3();            
      foodWorkers[RANK_4]           = new FoodWorkerRank4();            
      foodWorkers[RANK_5]           = new FoodWorkerRank5();            
      
      IWorker[] defenceWorkers      = new ADefenceWorker[TOTAL_WORKERS_COUNT];
      defenceWorkers[RANK_1]        = new DefenceWorkerRank1();
      defenceWorkers[RANK_2]        = new DefenceWorkerRank2();
      defenceWorkers[RANK_3]        = new DefenceWorkerRank3();
      defenceWorkers[RANK_4]        = new DefenceWorkerRank4();
      defenceWorkers[RANK_5]        = new DefenceWorkerRank5();
      
      workers.put(WorkerType.FOOD, foodWorkers);
      workers.put(WorkerType.WOOD, woodWorkers);
      workers.put(WorkerType.DEFENCE, defenceWorkers);      
   }
   
   @Override
   public void load(SharedPreferences prefs) {
      final Iterator<WorkerType> workerTypesIter = workers.keySet().iterator();
      
      while(workerTypesIter.hasNext()) {
         IWorker[] oneTypeWorkers = workers.get(workerTypesIter.next());
         for(int i = 0; i < oneTypeWorkers.length; i++)
            oneTypeWorkers[i].load(prefs);
      }
   }

   @Override
   public void save(Editor prefsEditor) {
      final Iterator<WorkerType> workerTypesIter = workers.keySet().iterator();
      
      while(workerTypesIter.hasNext()) {
         IWorker[] oneTypeWorkers = workers.get(workerTypesIter.next());
         for(int i = 0; i < oneTypeWorkers.length; i++)
            oneTypeWorkers[i].save(prefsEditor);
      }
   }

   @Override
   public IWorker getWorker(WorkerType workerType, int wokerIndex) {
      return workers.get(workerType)[wokerIndex];
   }

   @Override
   public IWorker[] getWorkersByType(WorkerType workerType) {
      return workers.get(workerType);
   }

   @Override
   public int getTotalHomeForWorkers() {
      int result = 0;
      
      final Iterator<WorkerType> workerTypesIter = workers.keySet().iterator();
      
      while(workerTypesIter.hasNext()) {
         IWorker[] oneTypeWorkers = workers.get(workerTypesIter.next());
         for(int i = 0; i < oneTypeWorkers.length; i++)
            result += oneTypeWorkers[i].getCurrentCount() * oneTypeWorkers[i].getHomePlaces();
      }
      
      return result;
   }

   @Override
   public int getResourcesPerSecond(WorkerType workerType) {
      int result = 0;
      
      IWorker[] oneTypeWorkers = getWorkersByType(workerType);
      for(int i = 0; i < oneTypeWorkers.length; i++) {
         result += oneTypeWorkers[i].getCurrentCount() * oneTypeWorkers[i].getResourcesPerSec(); 
      }
      
      return result;
   }

}
