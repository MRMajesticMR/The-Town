package ru.majestic.thetown.view.dialogs.shops;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.impl.SimpleCloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;

public abstract class AShopDialog extends Rectangle implements IShopDialog, OnCloseDialogButtonClickedListener {

   private static final int MARGIN_TOP_BOTTOM = 60;
   private static final int MARGIN_LEFT_RIGHT = 30;
   
   private OnDialogClosedListener onDialogClosedListener;        
   
   private ICloseDialogButton closeDialogButton;
   
   public AShopDialog() {
      super(MARGIN_LEFT_RIGHT, MARGIN_TOP_BOTTOM, TheTownCamera.CAMERA_WIDTH - (MARGIN_LEFT_RIGHT * 2), TheTownCamera.CAMERA_HEIGHT - (MARGIN_TOP_BOTTOM * 2), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      setColor(0, 0, 1);
      setVisible(false);
      
      closeDialogButton = new SimpleCloseDialogButton(this);     
      closeDialogButton.setOnCloseDialogButtonClickedListener(this);      
      closeDialogButton.attachToParent(this);
   }
   
   @Override
   public void registerTouchArea(Scene scene) {
      closeDialogButton.registerTouchArea(scene);      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      closeDialogButton.unregisterTouchArea(scene);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
      this.onDialogClosedListener = onDialogClosedListener;
   }

   @Override
   public void show() {
      setVisible(true);
   }

   @Override
   public void hide() {
      setVisible(false);      
   }

   @Override
   public void onCloseDialogButtonClicked() {
      onDialogClosedListener.onDialogClosed(this);      
   }

}
