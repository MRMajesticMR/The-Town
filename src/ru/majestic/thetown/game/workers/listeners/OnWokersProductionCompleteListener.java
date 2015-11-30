package ru.majestic.thetown.game.workers.listeners;

import java.math.BigInteger;

public interface OnWokersProductionCompleteListener {

   public void onWorkersProductionComplete(BigInteger addFood, BigInteger addWood);
   
}
