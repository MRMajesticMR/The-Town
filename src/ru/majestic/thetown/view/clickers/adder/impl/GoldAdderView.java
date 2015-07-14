package ru.majestic.thetown.view.clickers.adder.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.adder.AClickersAdderView;

public class GoldAdderView extends AClickersAdderView {

   public GoldAdderView() {
      super(ResourceManager.getInstance().getGoldIconTextureRegion());
   }

}
