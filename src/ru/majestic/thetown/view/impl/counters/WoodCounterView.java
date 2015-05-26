package ru.majestic.thetown.view.impl.counters;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IAndEngineCountViewSkeleton;

public class WoodCounterView extends IAndEngineCountViewSkeleton {

   public WoodCounterView() {
      super(330, 10, ResourceManager.getInstance().getFoodClickerBgndTextureRegion());
   }

}
