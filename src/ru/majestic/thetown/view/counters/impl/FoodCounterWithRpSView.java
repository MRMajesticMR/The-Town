package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountWithPsRViewSkeleton;

public class FoodCounterWithRpSView extends ACountWithPsRViewSkeleton {

   public FoodCounterWithRpSView() {
      super(10, 4, ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
