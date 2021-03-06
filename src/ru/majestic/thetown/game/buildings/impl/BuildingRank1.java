package ru.majestic.thetown.game.buildings.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class BuildingRank1 extends ABuilding {
   
   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_TENT_CURRENT_COUNT";
   
   public BuildingRank1() {
      super("Tent", new BigInteger("1"), new BigInteger("1"), ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   protected String getSaveDataCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
