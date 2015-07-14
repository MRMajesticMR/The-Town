package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;

public class FoodClickerView extends AClickerViewSkeleton {

   private static final int X = 0;
   private static final int Y = 520;             
   
   public FoodClickerView() {
      super(X, Y, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getFoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
   }   

}
