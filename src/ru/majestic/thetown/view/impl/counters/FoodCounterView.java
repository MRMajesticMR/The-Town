package ru.majestic.thetown.view.impl.counters;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IAndEngineCountViewSkeleton;

public class FoodCounterView extends IAndEngineCountViewSkeleton {

   public FoodCounterView() {
      super(10, 10, ResourceManager.getInstance().getFoodClickerBgndTextureRegion());
   }

}
