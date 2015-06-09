package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class WoodCounterView extends ACountViewSkeleton {

   public WoodCounterView(int x, int y) {
      super(x, y, ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
