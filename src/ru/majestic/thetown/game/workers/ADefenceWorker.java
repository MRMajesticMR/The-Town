package ru.majestic.thetown.game.workers;


public abstract class ADefenceWorker extends AWorker {

   public ADefenceWorker(String title, int foodCost, int exp, int homePlace, int resourcesPerSec) {
      super(title, foodCost, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.DEFENCE;
   }

}
