package ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.AClickersShopPanelSkeleton;

public class FoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public FoodClickersShopPanel(float x, float y, float width, IClicker clicker) {
      super(x, y, width, clicker, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getWoodIconTextureRegion());
   }

   @Override
   protected boolean isUpgradeAvailable(ICargoManager cargoManager) {
      return cargoManager.getWoodCargo().getCurrentCount() > clicker.getUpgradePrice();
   }   

}
