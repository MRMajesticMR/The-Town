package ru.majestic.thetown.game.workers;


public abstract class ADefenceWorker extends AWorker {

   public ADefenceWorker(String title, int foodCost, int exp, int homePlace) {
      super(title, foodCost, exp, homePlace);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.DEFENCE;
   }

}
