package ru.majestic.thetown.game.impl;

import java.util.HashMap;
import java.util.Iterator;

import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.defence.DefenceSlaveWorker;
import ru.majestic.thetown.game.workers.food.FoodSlaveWorker;
import ru.majestic.thetown.game.workers.wood.WoodSlaveWorker;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class WorkersManager implements IWorkersManager {

   private static final int TOTAL_WORKERS_COUNT = 1;
   
   private static final int SLAVE_INDEX = 0;
   
   private HashMap<IWorker.WorkerType, IWorker[]> workers;
   
   private IWorker[] foodWorkers       = new ADefenceWorker[TOTAL_WORKERS_COUNT];
   private IWorker[] woodWorkers       = new ADefenceWorker[TOTAL_WORKERS_COUNT];
   private IWorker[] defenceWorkers    = new ADefenceWorker[TOTAL_WORKERS_COUNT];
   
   public WorkersManager() {
      workers = new HashMap<IWorker.WorkerType, IWorker[]>();
      
      foodWorkers[SLAVE_INDEX]      = new FoodSlaveWorker();
      
      woodWorkers[SLAVE_INDEX]      = new WoodSlaveWorker();
      
      defenceWorkers[SLAVE_INDEX]   = new DefenceSlaveWorker();
      
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

}
