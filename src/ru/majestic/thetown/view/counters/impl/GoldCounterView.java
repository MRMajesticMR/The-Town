package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class GoldCounterView extends ACountViewSkeleton {

   public GoldCounterView() {
      super(170, 10, ResourceManager.getInstance().getGoldIconTextureRegion());
   }

}
