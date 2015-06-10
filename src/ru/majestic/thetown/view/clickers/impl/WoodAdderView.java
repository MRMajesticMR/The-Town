package ru.majestic.thetown.view.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickersAdderView;

public class WoodAdderView extends AClickersAdderView {

   public WoodAdderView() {
      super(ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
