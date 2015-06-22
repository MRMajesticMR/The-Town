package ru.majestic.thetown.view.dialogs.shops.panels.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.IBuyGoldButton;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.listeners.OnBuyGoldButtonClickedListener;

public class BuyGoldButton extends Rectangle implements IBuyGoldButton {

   private int index;
   private OnBuyGoldButtonClickedListener onBuyGoldButtonClickedListener;
   
   public BuyGoldButton(float x, float y, float width, float height, int index) {
      super(x, y, width, height, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      this.index = index;
      setColor(1, 0, 0);
   }

   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(this);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {      
      scene.unregisterTouchArea(this);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }   
   
   @Override
   public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
      if (pSceneTouchEvent.isActionDown())
      {
         onBuyGoldButtonClickedListener.onBuyButtonClicked(this);
      }
      return true;
   }

   @Override
   public void setOnBuyGoldButtonClickedListener(OnBuyGoldButtonClickedListener onBuyGoldButtonClickedListener) {
      this.onBuyGoldButtonClickedListener = onBuyGoldButtonClickedListener;
   }

   @Override
   public int getIndex() {
      return index;
   }

}
