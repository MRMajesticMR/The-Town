package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.IAndEngineCountViewSkeleton;

public class GoldCounterView extends IAndEngineCountViewSkeleton {

   public GoldCounterView() {
      super(170, 10, ResourceManager.getInstance().getFoodClickerBgndTextureRegion());
   }

}
