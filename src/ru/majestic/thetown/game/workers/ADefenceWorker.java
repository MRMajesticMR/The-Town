package ru.majestic.thetown.game.workers;

import java.math.BigInteger;



public abstract class ADefenceWorker extends AWorker {

   public ADefenceWorker(String title, BigInteger exp, BigInteger homePlace, BigInteger resourcesPerSec) {
      super(title, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.DEFENCE;
   }
}
