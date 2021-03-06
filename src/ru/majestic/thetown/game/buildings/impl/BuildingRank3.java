package ru.majestic.thetown.game.buildings.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class BuildingRank3 extends ABuilding {
   
   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_SHACK_CURRENT_COUNT";
   
   public BuildingRank3() {
      super("Shack", new BigInteger("100"), new BigInteger("100"), ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   protected String getSaveDataCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
