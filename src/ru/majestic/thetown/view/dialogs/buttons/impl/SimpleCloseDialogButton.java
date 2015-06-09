package ru.majestic.thetown.view.dialogs.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;

public class SimpleCloseDialogButton extends Rectangle implements ICloseDialogButton {

   private static final int SIZE = 40;
   
   private OnCloseDialogButtonClickedListener onCloseDialogButtonClickedListener;
   
   public SimpleCloseDialogButton(IDialog dialog) {
      super(dialog.getWidth() - SIZE, 0, SIZE, SIZE, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setColor(0, 1, 0);
   }   
   
   @Override
   public void setOnCloseDialogButtonClickedListener(OnCloseDialogButtonClickedListener onCloseDialogButtonClickedListener) {
      this.onCloseDialogButtonClickedListener = onCloseDialogButtonClickedListener;      
   }
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {
          onCloseDialogButtonClickedListener.onCloseDialogButtonClicked();
       }
       return true;
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
   };

}
