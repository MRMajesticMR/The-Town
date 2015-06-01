package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AAndEngineClickerSkeleton;

public class WoodClickerView extends AAndEngineClickerSkeleton {

   private static final int X = 260;
   private static final int Y = 500;
   
   public WoodClickerView() {
      super(X, Y, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

}
