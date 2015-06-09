package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountViewSkeleton;

public class DefenceCounterView extends ACountViewSkeleton {

   public DefenceCounterView() {
      super(10, 130, ResourceManager.getInstance().getSwordsIconTextureRegion());
   }

}
