package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickersAdderView;

public class FoodAdderView extends AClickersAdderView {

   public FoodAdderView() {
      super(ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
