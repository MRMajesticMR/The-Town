package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountWithMaxValueViewSkeleton;

public class HomeCounterView extends ACountWithMaxValueViewSkeleton {

   public HomeCounterView(int x, int y) {
      super(x, y, ResourceManager.getInstance().getHomeIconTextureRegion());
   }

}
