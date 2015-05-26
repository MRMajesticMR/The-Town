package ru.majestic.thetown.view.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IAndEngineClickerSkeleton;

public class WoodClicker extends IAndEngineClickerSkeleton {

   public WoodClicker() {
      super(260, 580, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

}
