package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;

public class WoodClickerView extends AClickerViewSkeleton {

   private static final int X = 245;
   private static final int Y = 500;
   
   private static final float WIDTH    = 235.0f;
   private static final float HEIGHT   = 265.0f;   
   
   public WoodClickerView() {
      super(X, Y, WIDTH, HEIGHT, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

}
