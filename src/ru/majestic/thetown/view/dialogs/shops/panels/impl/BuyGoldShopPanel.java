package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.IBuyGoldShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.IBuyGoldButton;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.impl.BuyGoldButton;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.listeners.OnBuyGoldButtonClickedListener;
import ru.majestic.thetown.view.dialogs.shops.panels.listeners.OnBuyGoldListener;
import ru.majestic.thetown.view.dialogs.shops.panels.listeners.OnBuyGoldListener.BuyType;

public class BuyGoldShopPanel extends Rectangle implements IBuyGoldShopPanel, OnBuyGoldButtonClickedListener {

   private static final int HEIGHT = 60;
   
   private static final int TOTAL_BTNS_COUNT          = 3;
   
   private static final int BTN_INDEX_TEN_GOLD        = 0;
   private static final int BTN_INDEX_HUNDRED_GOLD    = 1;
   private static final int BTN_INDEX_THOUSAND_GOLD   = 2;
   
   private static final int BUTTONS_SPACE             = 2;
   
   private OnBuyGoldListener onBuyGoldListener;
   
   private IBuyGoldButton[] buyGoldBtns;
   
   public BuyGoldShopPanel(IShopDialog shopDialog) {
      super(0, shopDialog.getHeight() - HEIGHT - 17, shopDialog.getWidth(), HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      buyGoldBtns = new IBuyGoldButton[TOTAL_BTNS_COUNT];
      
      for(int buttonIndex = 0; buttonIndex < buyGoldBtns.length; buttonIndex++) {
         buyGoldBtns[buttonIndex] = new BuyGoldButton(getButtonXByIndex(buttonIndex), 0, getButtonWidthByIndex(buttonIndex), HEIGHT, buttonIndex);
         buyGoldBtns[buttonIndex].setOnBuyGoldButtonClickedListener(this);
         buyGoldBtns[buttonIndex].attachToParent(this);
      }
   }
   
   private float getButtonXByIndex(int index) {
      return BUTTONS_SPACE + (getWidth() / TOTAL_BTNS_COUNT) * index;
   }
   
   private float getButtonWidthByIndex(int index) {
      return (getWidth() - BUTTONS_SPACE * (TOTAL_BTNS_COUNT + 1)) / TOTAL_BTNS_COUNT;
   }

   @Override
   public void registerTouchArea(Scene scene) {
      for(int i = 0; i < buyGoldBtns.length; i++) 
         buyGoldBtns[i].registerTouchArea(scene);           
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      for(int i = 0; i < buyGoldBtns.length; i++) 
         buyGoldBtns[i].unregisterTouchArea(scene);      
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void setOnBuyGoldListener(OnBuyGoldListener onBuyGoldListener) {
      this.onBuyGoldListener = onBuyGoldListener;
   }

   @Override
   public void onBuyButtonClicked(IBuyGoldButton buyGoldButton) {
      switch(buyGoldButton.getIndex()) {
      case BTN_INDEX_TEN_GOLD:
         onBuyGoldListener.onBuyGold(BuyType.TEN);
         break;
         
      case BTN_INDEX_HUNDRED_GOLD:
         onBuyGoldListener.onBuyGold(BuyType.HUNDRED);
         break;
         
      case BTN_INDEX_THOUSAND_GOLD:
         onBuyGoldListener.onBuyGold(BuyType.THOUSAND);
         break;
      }
   }

}
