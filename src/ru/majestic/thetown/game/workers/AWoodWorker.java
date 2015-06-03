package ru.majestic.thetown.game.workers;


public abstract class AWoodWorker extends AWorker {

   public AWoodWorker(String title, int foodCost, int exp, int homePlace) {
      super(title, foodCost, exp, homePlace);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.WOOD;
   }

}
