package ru.majestic.thetown.game.workers;


public abstract class AWoodWorker extends AWorker {

   @Override
   public WorkerType getType() {
      return WorkerType.WOOD;
   }

}
