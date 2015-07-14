package ru.majestic.thetown.view.clickers.adder.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.adder.AClickersAdderView;

public class WoodAdderView extends AClickersAdderView {

   public WoodAdderView() {
      super(ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
