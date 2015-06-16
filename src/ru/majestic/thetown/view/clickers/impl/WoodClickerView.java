package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;
import ru.majestic.thetown.view.clickers.IClickersAdderView;

public class WoodClickerView extends AClickerViewSkeleton {

   private static final int X = 245;
   private static final int Y = 500;
   
   public WoodClickerView() {
      super(X, Y, 235, 265, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

   @Override
   protected IClickersAdderView getClickersAdderView() {
      return new WoodAdderView();
   }

}
