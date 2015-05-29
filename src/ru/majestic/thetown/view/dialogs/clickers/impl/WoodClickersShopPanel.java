package ru.majestic.thetown.view.dialogs.clickers.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.clickers.AClickersShopPanelSkeleton;

public class WoodClickersShopPanel extends AClickersShopPanelSkeleton {

   public WoodClickersShopPanel() {
      super("Wood", ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
