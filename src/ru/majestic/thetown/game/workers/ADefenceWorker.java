package ru.majestic.thetown.game.workers;


public abstract class ADefenceWorker extends AWorker {

   public ADefenceWorker(String title, float priceKoeff, int exp, int homePlace, int resourcesPerSec) {
      super(title, priceKoeff, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.DEFENCE;
   }

}
