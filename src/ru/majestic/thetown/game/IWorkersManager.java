package ru.majestic.thetown.game;

import ru.majestic.thetown.game.workers.IWorker;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IWorkersManager {

   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public IWorker    getWorker         (IWorker.WorkerType workerType, int wokerIndex);
   
}
