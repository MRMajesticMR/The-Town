package ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl;

import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.AClickersShopPanelSkeleton;

public class FoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public FoodClickersShopPanel(IClicker clicker) {
      super(clicker, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getWoodIconTextureRegion());
   }   

}
