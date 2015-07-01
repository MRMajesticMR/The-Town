package ru.majestic.thetown.view.attack.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.attack.IAttackView;
import ru.majestic.thetown.view.attack.listeners.OnAttackDialogClosedListener;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class SimpleAttackView extends Sprite implements IAttackView, OnClickListener {   

   private static final int PANEL_PADDING = 8;
   
   private OnAttackDialogClosedListener onAttackDialogClosedListener;
   
   private final ButtonSprite    closeBtn;
   private final Text            resultText;
      
   private final Sprite          woodIcon;
   private final Text            woodResultText;
   
   private final Sprite          foodIcon;
   private final Text            foodResultText;      
   
   public SimpleAttackView() {
      super(70, 230, TheTownCamera.CAMERA_WIDTH - 140, 200, ResourceManager.getInstance().getAttackDialogBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setVisible(false);
      
      closeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getCloseButtonTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      resultText            = new Text(0, PANEL_PADDING, ResourceManager.getInstance().getAttackResultTitleTextFont(), "You've been attacked!", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      woodIcon              = new Sprite(180, 85, 40, 40, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      woodResultText        = new Text(woodIcon.getX() + woodIcon.getWidth() + 4, woodIcon.getY() + 8, ResourceManager.getInstance().getAttackResultTextFont(), "+100.00TT", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      foodIcon              = new Sprite(20, 85, 40, 40, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      foodResultText        = new Text(foodIcon.getX() + foodIcon.getWidth() + 4, foodIcon.getY() + 8, ResourceManager.getInstance().getAttackResultTextFont(), "+100.00TT", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      closeBtn.setWidth(100);
      closeBtn.setHeight(40);            
      closeBtn.setX((getWidth() - (PANEL_PADDING * 2) - closeBtn.getWidth()) / 2); 
      closeBtn.setY(getHeight() - PANEL_PADDING - closeBtn.getHeight());
      
      closeBtn.setOnClickListener(this);
      
      resultText.setX((getWidth() - resultText.getWidth()) / 2); 
      
      attachChild(closeBtn);
      attachChild(resultText);
      
      attachChild(woodIcon);
      attachChild(woodResultText);
      
      attachChild(foodIcon);
      attachChild(foodResultText);
   }   
   
   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);      
   }

   @Override
   public void show(boolean attackResult, long wood, long food) {
      if(attackResult) {
         resultText.setText("You've been attacked!");         
         woodResultText.setText("-" + BigValueFormatter.format(wood));
         foodResultText.setText("-" + BigValueFormatter.format(food));         
      } else {
         resultText.setText("Attackers defeated!");
         woodResultText.setText("+" + BigValueFormatter.format(wood));
         foodResultText.setText("+" + BigValueFormatter.format(food));
      }      
      
      resultText.setX((getWidth() - resultText.getWidth()) / 2);
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
