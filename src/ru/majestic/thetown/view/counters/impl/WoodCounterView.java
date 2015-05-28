package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.IAndEngineCountViewSkeleton;

public class WoodCounterView extends IAndEngineCountViewSkeleton {

   public WoodCounterView() {
      super(330, 10, ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
