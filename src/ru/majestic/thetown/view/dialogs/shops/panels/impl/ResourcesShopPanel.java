package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.impl.FoodCounterView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterView;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.AResourcesShopPanelSkeleton;

public class ResourcesShopPanel extends AResourcesShopPanelSkeleton {

   private final ICountView foodCountView;
   private final ICountView goldCountView;
   private final ICountView woodCountView;
   
   public ResourcesShopPanel(IShopDialog shopDialog) {
      super(shopDialog);
      
      foodCountView = new FoodCounterView();
      goldCountView = new GoldCounterView();
      woodCountView = new WoodCounterView();
      
      foodCountView.attachToParent(this);
      goldCountView.attachToParent(this);
      woodCountView.attachToParent(this);      
   }
   
   @Override
   public void onResourcesChanged(int food, int gold, int wood) {
      foodCountView.changeCount(food);
      goldCountView.changeCount(gold);
      woodCountView.changeCount(wood);      
   }

}
