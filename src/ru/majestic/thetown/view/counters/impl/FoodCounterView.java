package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.IAndEngineCountViewSkeleton;

public class FoodCounterView extends IAndEngineCountViewSkeleton {

   public FoodCounterView() {
      super(10, 10, ResourceManager.getInstance().getFoodClickerBgndTextureRegion());
   }

}
