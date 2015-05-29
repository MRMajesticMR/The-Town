package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.AClickersShopPanelSkeleton;

public class WoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public WoodClickersShopPanel() {
      super("Wood", ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
