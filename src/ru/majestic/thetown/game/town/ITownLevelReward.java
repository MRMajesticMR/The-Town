package ru.majestic.thetown.game.town;

import java.math.BigInteger;

public interface ITownLevelReward {

   public BigInteger getFoodReward();
   public BigInteger getWoodReward();   
   public BigInteger getGoldReward();
   
}
