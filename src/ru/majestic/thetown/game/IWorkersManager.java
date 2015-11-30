package ru.majestic.thetown.game;

import java.math.BigInteger;

import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IWorkersManager {

   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public IWorker    getWorker         (IWorker.WorkerType workerType, int wokerIndex);
   public IWorker[]  getWorkersByType  (IWorker.WorkerType workerType);
   
   public BigInteger getTotalHomeForWorkers();
   
   public BigInteger getResourcesPerSecond(WorkerType workerType);
   
}
