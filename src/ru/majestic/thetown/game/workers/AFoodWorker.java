package ru.majestic.thetown.game.workers;


public abstract class AFoodWorker extends AWorker {

   public AFoodWorker(String title, int foodCost, int exp, int homePlace) {
      super(title, foodCost, exp, homePlace);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.FOOD;
   }

}
