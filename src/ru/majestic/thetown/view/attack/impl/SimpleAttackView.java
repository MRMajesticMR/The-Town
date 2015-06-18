package ru.majestic.thetown.view.attack.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.attack.IAttackView;
import ru.majestic.thetown.view.attack.listeners.OnAttackDialogClosedListener;

public class SimpleAttackView extends Rectangle implements IAttackView, OnClickListener {   

   private static final int PANEL_PADDING = 4;
   
   private OnAttackDialogClosedListener onAttackDialogClosedListener;
   
   private final ButtonSprite    closeBtn;
   private final Text            resultText;
   
   public SimpleAttackView() {
      super(10, 200, TheTownCamera.CAMERA_WIDTH - 20, 300, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setVisible(false);
      
      closeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getUpgBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      resultText            = new Text(0, PANEL_PADDING, ResourceManager.getInstance().getAttackResultTextFont(), "You've been attacked!", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      closeBtn.setWidth(200);
      closeBtn.setHeight(50);            
      closeBtn.setX((getWidth() - (PANEL_PADDING * 2) - closeBtn.getWidth()) / 2); 
      closeBtn.setY(getHeight() - PANEL_PADDING - closeBtn.getHeight());
      
      closeBtn.setOnClickListener(this);
      
      resultText.setX((getWidth() - resultText.getWidth()) / 2); 
      
      attachChild(closeBtn);
      attachChild(resultText);
   }   
   
   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);      
   }

   @Override
   public void show(IAttack attack) {
      setVisible(true);
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
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      onAttackDialogClosedListener.onAttackDialogClosed();
   }

   @Override
   public void setOnAttackDialogClosedListener(OnAttackDialogClosedListener onAttackDialogClosedListener) {
      this.onAttackDialogClosedListener = onAttackDialogClosedListener;
   }

   @Override
   public void close() {
      setVisible(false);
   }

}
