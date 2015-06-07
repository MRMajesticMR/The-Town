package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class FoodCounterView extends ACountViewSkeleton {

   public FoodCounterView() {
      super(10, 4, ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
