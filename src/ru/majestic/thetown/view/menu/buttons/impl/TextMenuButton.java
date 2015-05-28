package ru.majestic.thetown.view.menu.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;

public class TextMenuButton extends Rectangle implements IMenuButton {

   public TextMenuButton() {
      super(0, 0, 0, 0, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setColor(0, 0, 1);
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
