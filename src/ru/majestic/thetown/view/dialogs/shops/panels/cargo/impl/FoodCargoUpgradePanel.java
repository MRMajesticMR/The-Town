package ru.majestic.thetown.view.dialogs.shops.panels.cargo.impl;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.cargo.ACargoUpgradePanel;

public class FoodCargoUpgradePanel extends ACargoUpgradePanel {

   public FoodCargoUpgradePanel(float x, float y, float width) {
      super(x, y, width, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getFoodIconTextureRegion());
   }

}
