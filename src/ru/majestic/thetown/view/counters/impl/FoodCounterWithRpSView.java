package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountWithPsRViewSkeleton;

public class FoodCounterWithRpSView extends ACountWithPsRViewSkeleton {

   public FoodCounterWithRpSView(float x, float y) {
      super(x, y, ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
