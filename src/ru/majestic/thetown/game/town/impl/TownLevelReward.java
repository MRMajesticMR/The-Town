package ru.majestic.thetown.game.town.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.town.ITownLevelReward;

public class TownLevelReward implements ITownLevelReward {

   private int townLevel;
   
   public TownLevelReward(int townLevel) {
      this.townLevel = townLevel;
   }
   
   @Override
   public BigInteger getFoodReward() {
      return new BigInteger(String.valueOf(townLevel)).pow(3);
   }

   @Override
   public BigInteger getWoodReward() {
      return new BigInteger(String.valueOf(townLevel)).pow(3);
   }

   @Override
   public BigInteger getGoldReward() {
      return new BigInteger(String.valueOf(townLevel)).divide(new BigInteger("3"));
   }

}
