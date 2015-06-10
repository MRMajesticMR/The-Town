package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;
import ru.majestic.thetown.view.clickers.IClickersAdderView;

public class WoodClickerView extends AClickerViewSkeleton {

   private static final int X = 245;
   private static final int Y = 520;
   
   public WoodClickerView() {
      super(X, Y, CLICKER_WIDTH_AND_HEIGHT, CLICKER_WIDTH_AND_HEIGHT, ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

   @Override
   protected IClickersAdderView getClickersAdderView() {
      return new WoodAdderView();
   }

}
