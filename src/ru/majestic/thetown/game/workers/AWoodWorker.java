package ru.majestic.thetown.game.workers;


public abstract class AWoodWorker extends AWorker {

   public AWoodWorker(String title, float priceKoeff, int exp, int homePlace, int resourcesPerSec) {
      super(title, priceKoeff, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.WOOD;
   }

}
