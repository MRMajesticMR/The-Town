package ru.majestic.thetown.view.dialogs.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.clickers.AClickersShopPanelSkeleton;

public class FoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public FoodClickersShopPanel() {
      super("Food", ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
