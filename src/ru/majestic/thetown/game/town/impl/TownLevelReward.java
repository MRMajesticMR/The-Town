package ru.majestic.thetown.game.town.impl;

import ru.majestic.thetown.game.town.ITownLevelReward;

public class TownLevelReward implements ITownLevelReward {

   private int townLevel;
   
   public TownLevelReward(int townLevel) {
      this.townLevel = townLevel;
   }
   
   @Override
   public long getFoodReward() {
      return (long) Math.pow(townLevel, 3.5f);
   }

   @Override
   public long getWoodReward() {      
      return (long) Math.pow(townLevel, 3.5f);
   }

   @Override
   public long getGoldReward() {
      return (long) (townLevel / 3);
   }

}
