package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountWithRpSAndMaxValueView;

public class WoodCounterView extends ACountWithRpSAndMaxValueView {

   public WoodCounterView(float x, float y) {
      super(x, y, ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
