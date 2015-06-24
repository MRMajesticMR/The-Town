package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.market.IMarketItem;
import ru.majestic.thetown.game.market.impl.FoodMarketItem;
import ru.majestic.thetown.game.market.impl.WoodMarketItem;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.MarketShopDialogActionListener;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.IMarketItemPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.impl.FoodMarketItemPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.impl.WoodMarketItemPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.listeners.OnMarketItemBuyBtnClickedListener;

public class MarketShopDialog extends AShopDialog implements OnMarketItemBuyBtnClickedListener {
   
   private static final int TOTAL_RAWS = 6;
   
   private MarketShopDialogActionListener marketShopDialogActionListener;
   
   private IMarketItemPanel[] woodMarketItemPanels;
   private IMarketItemPanel[] foodMarketItemPanels;   
   
   public MarketShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      woodMarketItemPanels = new IMarketItemPanel[TOTAL_RAWS];
      foodMarketItemPanels = new IMarketItemPanel[TOTAL_RAWS];      
      
      for(int i = 0 ; i < TOTAL_RAWS; i++) {
         woodMarketItemPanels[i] = new WoodMarketItemPanel(0, getResoucesShopPanel().getHeight() + 4 + i * 84, this, new WoodMarketItem((int) Math.pow(10, i), (int) (10000 * Math.pow(10, i))), gameManager.getCargoManager());
         foodMarketItemPanels[i] = new FoodMarketItemPanel(getWidth() / 2, getResoucesShopPanel().getHeight() + 4 + i * 84, this, new FoodMarketItem((int) Math.pow(10, i), (int) (10000 * Math.pow(10, i))), gameManager.getCargoManager());         
         
         woodMarketItemPanels[i].setOnMarketItemBuyBtnClickedListener(this);
         foodMarketItemPanels[i].setOnMarketItemBuyBtnClickedListener(this);
         
         woodMarketItemPanels[i].attachToParent(this);
         foodMarketItemPanels[i].attachToParent(this);
      }
   }   
   
   @Override
   public void registerTouchArea(Scene scene) {
      super.registerTouchArea(scene);
      
      for(int i = 0 ; i < TOTAL_RAWS; i++) {
         woodMarketItemPanels[i].registerTouchArea(scene);
         foodMarketItemPanels[i].registerTouchArea(scene);
      }
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      super.unregisterTouchArea(scene);
      
      for(int i = 0 ; i < TOTAL_RAWS; i++) {
         woodMarketItemPanels[i].unregisterTouchArea(scene);
         foodMarketItemPanels[i].unregisterTouchArea(scene);
      }
   }
   
   @Override
   public void update() {
      super.update();
      
      for(int i = 0 ; i < TOTAL_RAWS; i++) {
         woodMarketItemPanels[i].update();
         foodMarketItemPanels[i].update();
      }
   }
   
   public void setMarketShopDialogActionListener(MarketShopDialogActionListener marketShopDialogActionListener) {
      this.marketShopDialogActionListener = marketShopDialogActionListener;
   }

   @Override
   public void onMarketItemBuyBtnClicked(IMarketItem marketItem) {
      marketShopDialogActionListener.onBuyItemFromMarket(marketItem);
   }

}
