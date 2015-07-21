package ru.majestic.thetown.view.dialogs.shops.panels.warehouse.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.ACargoUpgradePanel;

public class FoodCargoUpgradePanel extends ACargoUpgradePanel {

   public FoodCargoUpgradePanel(float x, float y, float width) {
      super(x, y, width, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
