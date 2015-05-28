package ru.majestic.thetown.view.dialogs.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.IClickersShopDialog;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.impl.SimpleCloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;

public class ClickersShopDialog extends Rectangle implements IClickersShopDialog,
                                                             OnCloseDialogButtonClickedListener {
   
   private static final int PADDING_TOP_BOTTOM = 60;
   private static final int PADDING_LEFT_RIGHT = 30;
   
   private OnDialogClosedListener onDialogClosedListener;
   
   private ICloseDialogButton closeDialogButton;
   
   public ClickersShopDialog() {
      super(PADDING_LEFT_RIGHT, PADDING_TOP_BOTTOM, TheTownCamera.CAMERA_WIDTH - (PADDING_LEFT_RIGHT * 2), TheTownCamera.CAMERA_HEIGHT - (PADDING_TOP_BOTTOM * 2), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setColor(1, 0, 0);                  
      setVisible(false);
      
      closeDialogButton = new SimpleCloseDialogButton(this);
      closeDialogButton.setOnCloseDialogButtonClickedListener(this);
      closeDialogButton.attachToParent(this);      
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
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
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
   public void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
      this.onDialogClosedListener = onDialogClosedListener;
   }

   @Override
   public void onCloseDialogButtonClicked() {
      onDialogClosedListener.onDialogClosed(this);
   }

}
