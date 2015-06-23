package ru.majestic.thetown.view.dialogs.shops.panels.workers.market.impl;

import ru.majestic.thetown.game.market.impl.WoodMarketItem;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.AMarketItemPanel;

public class WoodMarketItemPanel extends AMarketItemPanel {

   public WoodMarketItemPanel(float x, float y, IShopDialog shopDialog, WoodMarketItem marketItem) {
      super(x, y, shopDialog, ResourceManager.getInstance().getWoodIconTextureRegion(), marketItem);
   }

}
