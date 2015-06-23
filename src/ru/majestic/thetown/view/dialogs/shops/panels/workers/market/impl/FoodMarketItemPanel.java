package ru.majestic.thetown.view.dialogs.shops.panels.workers.market.impl;

import ru.majestic.thetown.game.market.impl.FoodMarketItem;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.AMarketItemPanel;

public class FoodMarketItemPanel extends AMarketItemPanel {

   public FoodMarketItemPanel(float x, float y, IShopDialog shopDialog, FoodMarketItem foodMarketItem) {
      super(x, y, shopDialog, ResourceManager.getInstance().getFoodIconTextureRegion(), foodMarketItem);
   }

}
