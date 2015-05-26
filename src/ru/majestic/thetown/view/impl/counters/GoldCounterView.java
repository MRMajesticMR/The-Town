package ru.majestic.thetown.view.impl.counters;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IAndEngineCountViewSkeleton;

public class GoldCounterView extends IAndEngineCountViewSkeleton {

   public GoldCounterView() {
      super(170, 10, ResourceManager.getInstance().getFoodClickerBgndTextureRegion());
   }

}
