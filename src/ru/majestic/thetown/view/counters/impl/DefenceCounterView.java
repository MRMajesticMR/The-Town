package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class DefenceCounterView extends ACountViewSkeleton {

   public DefenceCounterView(int x, int y) {
      super(x, y, ResourceManager.getInstance().getSwordsIconTextureRegion());
   }

}
