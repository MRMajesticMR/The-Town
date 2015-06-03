package ru.majestic.thetown.game.workers;


public abstract class AFoodWorker extends AWorker {

   public AFoodWorker(String title, int foodCost, int exp, int homePlace, int resourcesPerSec) {
      super(title, foodCost, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.FOOD;
   }

}
