package ru.majestic.thetown.view.dialogs.shops.panels.buttons.impl;

import java.math.BigInteger;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.IBuyGoldButton;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.listeners.OnBuyGoldButtonClickedListener;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class BuyGoldButton extends Rectangle implements IBuyGoldButton {

   private static final int PADDING = 8;
   
   private int index;
   private OnBuyGoldButtonClickedListener onBuyGoldButtonClickedListener;
   
   private Text      goldCountTxt;
   private Sprite    goldIcon;   
   private Text      dollarsCountTxt;
   
   public BuyGoldButton(float x, float y, float width, float height, int index) {
      super(x, y, width, height, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      this.index = index;
      
      setAlpha(0.0f);
      
      goldCountTxt      = new Text(PADDING + 5, 20, FontsManager.getInstance().getFont(16), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      goldIcon          = new Sprite(0, 16, 30, 30, ResourceManager.getInstance().getGoldIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      dollarsCountTxt   = new Text(34, 20, FontsManager.getInstance().getFont(16), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
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
   public void setGoldCount(BigInteger goldCount) {
      goldCountTxt.setText(BigValueFormatter.format(goldCount));
      
      goldIcon.setX(goldCountTxt.getX() + goldCountTxt.getWidth() + 2);
      dollarsCountTxt.setX(goldIcon.getX() + goldIcon.getWidth() + 2);
   }

   @Override
   public void setDollarsCount(float dollarsCount) {
      dollarsCountTxt.setText(dollarsCount + "$");
   }

}
