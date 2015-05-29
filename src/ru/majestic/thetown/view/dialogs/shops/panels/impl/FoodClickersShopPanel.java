package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.AClickersShopPanelSkeleton;

public class FoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public FoodClickersShopPanel() {
      super("Food", ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
