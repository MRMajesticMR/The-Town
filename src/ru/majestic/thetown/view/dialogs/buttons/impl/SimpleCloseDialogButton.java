package ru.majestic.thetown.view.dialogs.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;

public class SimpleCloseDialogButton extends ButtonSprite implements ICloseDialogButton, OnClickListener {

   private static final int SIZE = 40;
   
   private OnCloseDialogButtonClickedListener onCloseDialogButtonClickedListener;
   
   public SimpleCloseDialogButton(IDialog dialog) {
      super(dialog.getWidth() - SIZE, 0, ResourceManager.getInstance().getCloseBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setWidth(SIZE);
      setHeight(SIZE);
      setOnClickListener(this);
   }   
   
   @Override
   public void setOnCloseDialogButtonClickedListener(OnCloseDialogButtonClickedListener onCloseDialogButtonClickedListener) {
      this.onCloseDialogButtonClickedListener = onCloseDialogButtonClickedListener;      
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
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      onCloseDialogButtonClickedListener.onCloseDialogButtonClicked();
   };

}
