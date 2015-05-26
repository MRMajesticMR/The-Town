package ru.majestic.thetown.view.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IAndEngineClickerSkeleton;

public class FoodClicker extends IAndEngineClickerSkeleton {

   public FoodClicker() {
      super(20, 580, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getFoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

}
