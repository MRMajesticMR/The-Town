package ru.majestic.thetown.view.clickers.adder.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.adder.AClickersAdderView;

public class FoodAdderView extends AClickersAdderView {

   public FoodAdderView() {
      super(ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
