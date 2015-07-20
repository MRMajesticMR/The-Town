package ru.majestic.thetown.view.dialogs.shops.panels.cargo.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.cargo.ACargoUpgradePanel;

public class WoodCargoUpgradePanel extends ACargoUpgradePanel {

   public WoodCargoUpgradePanel(float x, float y, float width) {
      super(x, y, width, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
