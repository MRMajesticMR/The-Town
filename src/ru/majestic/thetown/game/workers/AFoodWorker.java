package ru.majestic.thetown.game.workers;


public abstract class AFoodWorker extends AWorker {

   @Override
   public WorkerType getType() {
      return WorkerType.FOOD;
   }

}
