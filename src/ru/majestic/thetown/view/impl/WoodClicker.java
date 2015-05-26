package ru.majestic.thetown.view.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IAndEngineClickerSkeleton;

public class WoodClicker extends IAndEngineClickerSkeleton {

   private static final int X = 260;
   private static final int Y = 580;
   
   public WoodClicker() {
      super(X, Y, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

}
