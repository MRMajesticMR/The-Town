package ru.majestic.thetown.game.buildings.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class BuildingRank2 extends ABuilding {
   
   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_BIG_TENT_CURRENT_COUNT";
   
   public BuildingRank2() {
      super("Big tent", new BigInteger("10"), new BigInteger("10"), ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   protected String getSaveDataCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
