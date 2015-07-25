package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;

public class FoodClickerView extends AClickerViewSkeleton {

   private static final int X = 0;
   private static final int Y = 570;        
   
   private static final float WIDTH    = 200.0f;
   private static final float HEIGHT   = 210.0f;
   
   public FoodClickerView() {
      super(X, Y, WIDTH, HEIGHT, ResourceManager.getInstance().getFoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
   }   

}
