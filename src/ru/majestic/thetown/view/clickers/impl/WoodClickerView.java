package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;

public class WoodClickerView extends AClickerViewSkeleton {

   private static final int X = 235;
   private static final int Y = 550;
   
   private static final float WIDTH    = 255.0f;
   private static final float HEIGHT   = WIDTH * 0.85f;   
   
   public WoodClickerView() {
      super(X, Y, WIDTH, HEIGHT, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

}
