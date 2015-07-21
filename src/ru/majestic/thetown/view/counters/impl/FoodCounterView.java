package ru.majestic.thetown.view.counters.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ACountWithRpSAndMaxValueView;

public class FoodCounterView extends ACountWithRpSAndMaxValueView {

   public FoodCounterView(float x, float y) {
      super(x, y, ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
