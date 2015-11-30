package ru.majestic.thetown.game.buildings.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class BuildingRank5 extends ABuilding {
   
   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_LOG_CABIN_CURRENT_COUNT";
   
   public BuildingRank5() {
      super("Log cabin", new BigInteger("10000"), new BigInteger("10000"), ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   protected String getSaveDataCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
