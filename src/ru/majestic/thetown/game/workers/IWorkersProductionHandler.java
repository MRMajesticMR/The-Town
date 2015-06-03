package ru.majestic.thetown.game.workers;

import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;

public interface IWorkersProductionHandler {

   public void start();
   public void stop();
   
   public void setOnWokersProductionCompleteListener(OnWokersProductionCompleteListener onWokersProductionCompleteListener);
   
}
