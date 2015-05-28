package ru.majestic.thetown.view.menu.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;
import ru.majestic.thetown.view.menu.buttons.listeners.OnMenuButtonClickedListener;

public class TextMenuButton extends Rectangle implements IMenuButton {

   private OnMenuButtonClickedListener onMenuButtonClickedListener;
   
   public TextMenuButton(String text) {
      super(0, 0, 0, 0, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setColor(0, 0, 1);
   }
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {
          onMenuButtonClickedListener.onMenuButtonClicked(this);
       }
       return true;
   };
   
   @Override
   public void setOnMenuButtonClickedListener(OnMenuButtonClickedListener onMenuButtonClickedListener) {
      this.onMenuButtonClickedListener = onMenuButtonClickedListener;
   }

   @Override
   public void registerTouchArea(Scene scene) {      
      scene.registerTouchArea(this);
   }

   @Override
   public void attachToParent(Entity parent) {      
      parent.attachChild(this);
   }

   @Override
   public void setButtonWidth(float width) {
      setWidth(width);      
   }

   @Override
   public void setButtonHeight(float height) {
      setHeight(height);      
   }

   @Override
   public void setButtonX(float x) {
      setX(x);      
   }   

}
