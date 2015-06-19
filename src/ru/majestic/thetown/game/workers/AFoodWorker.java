package ru.majestic.thetown.game.workers;


public abstract class AFoodWorker extends AWorker {

   public AFoodWorker(String title, float priceKoeff, int exp, int homePlace, int resourcesPerSec) {
      super(title, priceKoeff, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.FOOD;
   }

}
