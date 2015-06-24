package ru.majestic.thetown.view.dialogs.shops;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.dialogs.shops.listeners.OnShopsCloseButtonCLickedListener;
import ru.majestic.thetown.view.dialogs.shops.panels.listeners.OnBuyGoldListener;

public interface IShopsDialogsManager {

   public static final int TOTAL_SHOPS_COUNT    = 4;
   
   public static final int SHOP_TYPE_CLICKERS   = 0;
   public static final int SHOP_TYPE_BUILDINGS  = 1;
   public static final int SHOP_TYPE_WORKERS    = 2;
   public static final int SHOP_TYPE_MARKET       = 3;   
   
   public void setOnShopsCloseButtonClickedListener   (OnShopsCloseButtonCLickedListener onShopsClosedListener);
   public void setOnBuyGoldListener                   (OnBuyGoldListener onBuyGoldListener);
   
   public void          attachToScene                 (Scene scene);
   public boolean       hasOpenedShop                 ();
   public void          openShop                      (int shopType, Scene scene);
   public void          closeShop                     (int shopType, Scene scene);
   public IShopDialog   getShop                       (int shopType);
   public int           getOpenedShopIndex            ();
   
   
}
