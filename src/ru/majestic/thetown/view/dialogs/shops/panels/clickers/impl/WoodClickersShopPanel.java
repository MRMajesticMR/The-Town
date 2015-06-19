package ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.AClickersShopPanelSkeleton;

public class WoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public WoodClickersShopPanel(float x, float y, float width, float height, IClicker clicker) {
      super(x, y, width, height, clicker, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

   @Override
   protected boolean isUpgradeAvailable(ICargoManager cargoManager) {
      return cargoManager.getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount() > clicker.getUpgradePrice();
   }

}
