package ru.majestic.thetown.game.buildings.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class BuildingRank4 extends ABuilding {
   
   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_HUT_CURRENT_COUNT";
   
   public BuildingRank4() {
      super("Hut", new BigInteger("1000"), new BigInteger("1000"), ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   protected String getSaveDataCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
