package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.IShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.listeners.OnShopsCloseButtonCLickedListener;

public class ShopsDialogsManager implements IShopsDialogsManager,
                                            OnDialogClosedListener {

   private OnShopsCloseButtonCLickedListener onShopsClosedListener;
   private IShopDialog[]         shops;
   
   public ShopsDialogsManager(IGameManager gameManager, Scene scene) {
      shops = new IShopDialog[TOTAL_SHOPS_COUNT];
      
      shops[SHOP_TYPE_CLICKERS]     = new ClickersShopDialog(gameManager);
      shops[SHOP_TYPE_BUILDINGS]    = new BuildingsShopDialog(gameManager);
      shops[SHOP_TYPE_WORKERS]      = new WorkersShopDialog(gameManager, scene);
      shops[SHOP_TYPE_GOLD]         = new GoldShopDialog(gameManager);
      
      addOnDialogClosedListenerToAllDialogs();
   }
   
   private void addOnDialogClosedListenerToAllDialogs() {
      for(IShopDialog shop: shops) 
         shop.setOnDialogClosedListener(this);
   }      

   @Override
   public boolean hasOpenedShop() {
      for(IShopDialog shop: shops) {
         if(shop.isVisible())
            return true;
      }
      
      return false;
   }

   @Override
   public void openShop(int shopType, Scene scene) {
      for(int shopIndex = 0; shopIndex < shops.length; shopIndex++) {
         closeShop(shopIndex, scene);
      }         
      
      shops[shopType].registerTouchArea(scene);
      shops[shopType].update();
      shops[shopType].show();      
   }

   @Override
   public void closeShop(int shopType, Scene scene) {
      shops[shopType].hide();
      shops[shopType].unregisterTouchArea(scene);
   }

   @Override
   public IShopDialog getShop(int shopType) {
      return shops[shopType];
   }

   @Override
   public void onDialogClosed(IDialog dialog) {
      onShopsClosedListener.onShopsCloseButtonClicked(dialog);
   }

   @Override
   public void attachToScene(Scene scene) {
      for(IShopDialog shop: shops) {
         shop.attachToParent(scene);
      }
   }

   @Override
   public void setOnShopsCloseButtonClickedListener(OnShopsCloseButtonCLickedListener onShopsClosedListener) {
      this.onShopsClosedListener = onShopsClosedListener;
   }

   @Override
   public int getOpenedShopIndex() {
      for(int shopIndex = 0; shopIndex < shops.length; shopIndex++) {
         if(shops[shopIndex].isVisible())
            return shopIndex;
      }
      
      return -1;
   }

}
