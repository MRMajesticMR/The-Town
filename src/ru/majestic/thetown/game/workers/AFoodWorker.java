package ru.majestic.thetown.game.workers;

import java.math.BigInteger;


public abstract class AFoodWorker extends AWorker {

   public AFoodWorker(String title, BigInteger exp, BigInteger homePlace, BigInteger resourcesPerSec) {
      super(title, exp, homePlace, resourcesPerSec);
   }

   @Override
   public WorkerType getType() {
      return WorkerType.FOOD;
   }

}
