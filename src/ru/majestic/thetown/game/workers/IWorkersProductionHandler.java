package ru.majestic.thetown.game.workers;

import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;
import android.content.Context;

public interface IWorkersProductionHandler {

   public void load  (Context context);
   public void save  (Context context);
   
   public void start ();
   public void stop  ();
   
   public void setOnWokersProductionCompleteListener(OnWokersProductionCompleteListener onWokersProductionCompleteListener);
   
}
