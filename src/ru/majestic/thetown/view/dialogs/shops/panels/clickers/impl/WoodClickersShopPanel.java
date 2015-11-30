package ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.AClickersShopPanelSkeleton;

public class WoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public WoodClickersShopPanel(float x, float y, float width, IClicker clicker) {
      super(x, y, width, clicker, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

   @Override
   protected boolean isUpgradeAvailable(ICargoManager cargoManager) {
      return cargoManager.getFoodCargo().getCurrentCount().compareTo(clicker.getUpgradePrice()) >= 0;
   }

}
