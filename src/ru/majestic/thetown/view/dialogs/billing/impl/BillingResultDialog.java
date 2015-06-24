package ru.majestic.thetown.view.dialogs.billing.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.billing.IBillingResultDialog;
import ru.majestic.thetown.view.dialogs.billing.listeners.OnBillingDialogClosedListener;

public class BillingResultDialog extends Rectangle implements IBillingResultDialog, OnClickListener {

   private static final int MARGIN     = 30;
   private static final int HEIGHT     = 140;
   private static final int PADDING    = 10;
   
   private final Text            resultTitleTxt;
   private final ButtonSprite    closeBtn;
   
   private OnBillingDialogClosedListener onBillingDialogClosedListener;
   
   public BillingResultDialog() {
      super(MARGIN, 230, TheTownCamera.CAMERA_WIDTH - (MARGIN * 2), HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setVisible(false);
      
      
      resultTitleTxt        = new Text(PADDING + 160, PADDING, ResourceManager.getInstance().getBillingResultTextFont(), "Buy product error. Try again later.", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      closeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getCloseButtonTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      closeBtn.setWidth(100);
      closeBtn.setHeight(40);            
      closeBtn.setX((getWidth() - (PADDING * 2) - closeBtn.getWidth()) / 2); 
      closeBtn.setY(getHeight() - PADDING - closeBtn.getHeight());
      
      closeBtn.setOnClickListener(this);
      
      attachChild(resultTitleTxt);
      attachChild(closeBtn);
   }

   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(closeBtn);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {      
      scene.unregisterTouchArea(closeBtn);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void show(Scene scene, State state) {
      resultTitleTxt.setText(getTextByState(state));
      resultTitleTxt.setX((getWidth() - resultTitleTxt.getWidth()) / 2);
      
      registerTouchArea(scene);
      setVisible(true);
   }
   
   private String getTextByState(State state) {
      switch(state) {
      case ERROR:
         return "Buy product error. Try again later.";
         
      case SUCCESS_100_GOLD:
         return "100 gold successfully obtained!";
         
      case SUCCESS_1000_GOLD:
         return "1.00T gold successfully obtained!";
         
      case SUCCESS_10000_GOLD:
         return "10.00T gold successfully obtained!";
         
      default:
         return null;
      }
   }

   @Override
   public void hide(Scene scene) {
      unregisterTouchArea(scene);      
      setVisible(false);
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {      
      onBillingDialogClosedListener.onBillingDialogClosed();
   }

   @Override
   public void setOnBillingDialogClosedListener(OnBillingDialogClosedListener onBillingDialogClosedListener) {
      this.onBillingDialogClosedListener = onBillingDialogClosedListener;
   }

}
