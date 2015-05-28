package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.IAndEngineClickerSkeleton;

public class FoodClicker extends IAndEngineClickerSkeleton {

   private static final int X = 20;
   private static final int Y = 500;   
   
   public FoodClicker() {
      super(X, Y, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getFoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
   }

}
