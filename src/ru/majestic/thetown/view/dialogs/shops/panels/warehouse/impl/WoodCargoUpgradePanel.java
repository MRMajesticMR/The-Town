package ru.majestic.thetown.view.dialogs.shops.panels.warehouse.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.ACargoUpgradePanel;

public class WoodCargoUpgradePanel extends ACargoUpgradePanel {

   public WoodCargoUpgradePanel(float x, float y, float width) {
      super(x, y, width, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getWoodIconTextureRegion());
   }

}
