package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class WoodCounterView extends ACountViewSkeleton {

   public WoodCounterView() {
      super(170, 4, ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
