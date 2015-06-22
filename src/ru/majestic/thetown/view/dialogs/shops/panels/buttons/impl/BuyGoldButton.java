package ru.majestic.thetown.view.dialogs.shops.panels.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.IBuyGoldButton;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.listeners.OnBuyGoldButtonClickedListener;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class BuyGoldButton extends Rectangle implements IBuyGoldButton {

   private static final int PADDING = 14;
   
   private int index;
   private OnBuyGoldButtonClickedListener onBuyGoldButtonClickedListener;
   
   private Text      goldCountTxt;
   private Sprite    goldIcon;   
   private Text      dollarsCountTxt;
   
   public BuyGoldButton(float x, float y, float width, float height, int index) {
      super(x, y, width, height, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      this.index = index;
      
      goldCountTxt      = new Text(PADDING, PADDING + 4, ResourceManager.getInstance().getCountersFont(), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      goldIcon          = new Sprite(0, PADDING, 40, 40, ResourceManager.getInstance().getGoldIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      dollarsCountTxt   = new Text(34, PADDING + 4, ResourceManager.getInstance().getCountersFont(), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(goldCountTxt);
      attachChild(goldIcon);
      attachChild(dollarsCountTxt);
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

   @Override
   public void setGoldCount(int goldCount) {
      goldCountTxt.setText(BigValueFormatter.format(goldCount));
      
      goldIcon.setX(goldCountTxt.getX() + goldCountTxt.getWidth() + 2);
      dollarsCountTxt.setX(goldIcon.getX() + goldIcon.getWidth() + 2);
   }

   @Override
   public void setDollarsCount(float dollarsCount) {
      dollarsCountTxt.setText(dollarsCount + "$");
   }

}
