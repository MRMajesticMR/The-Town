package ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl;

import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.AClickersShopPanelSkeleton;

public class WoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public WoodClickersShopPanel(IClicker clicker) {
      super(clicker, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
