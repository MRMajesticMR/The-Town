package ru.majestic.thetown.game.workers;


public abstract class ADefenceWorker extends AWorker {

   @Override
   public WorkerType getType() {
      return WorkerType.DEFENCE;
   }

}
