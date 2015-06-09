package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class FoodCounterView extends ACountViewSkeleton {

   public FoodCounterView(int x, int y) {
      super(x, y, ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
