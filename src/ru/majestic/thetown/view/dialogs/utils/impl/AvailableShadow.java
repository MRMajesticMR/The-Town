package ru.majestic.thetown.view.dialogs.utils.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.utils.IAvailableShadow;

public class AvailableShadow extends Rectangle implements IAvailableShadow {

   public AvailableShadow(float x, float y, float width, float height) {
      super(x, y, width, height, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setAlpha(0.6f);
      setColor(0, 0, 0);
   }

   @Override
   public void attachToParent(Entity parent) {      
      parent.attachChild(this);
   }

   @Override
   public void show() {
      setVisible(true);
   }

   @Override
   public void hide() {
      setVisible(false);
   }

}
