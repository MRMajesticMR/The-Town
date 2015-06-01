package ru.majestic.thetown.game.buildings.impl;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class Logcabin extends ABuilding {
   
   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_LOG_CABIN_CURRENT_COUNT";
   
   public Logcabin() {
      super("Log cabin", 100000, 10000, 10000, ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   protected String getSaveDataCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
