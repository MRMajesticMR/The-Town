package ru.majestic.thetown.view.dialogs.clickers.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.impl.SimpleCloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;
import ru.majestic.thetown.view.dialogs.clickers.IClickersShopDialog;
import ru.majestic.thetown.view.dialogs.clickers.IClickersShopPanel;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;

public class ClickersShopDialog extends Rectangle implements IClickersShopDialog,
                                                             OnCloseDialogButtonClickedListener {
   
   private static final int MARGIN_TOP_BOTTOM = 60;
   private static final int MARGIN_LEFT_RIGHT = 30;
   
   private static final int PADDING_TOP   = 50;
   private static final int PADDING       = 10;
   
   private OnDialogClosedListener onDialogClosedListener;
   
   private ICloseDialogButton closeDialogButton;
   private IClickersShopPanel foodClickersShopPanel;
   private IClickersShopPanel woodClickersShopPanel;   
   
   public ClickersShopDialog() {
      super(MARGIN_LEFT_RIGHT, MARGIN_TOP_BOTTOM, TheTownCamera.CAMERA_WIDTH - (MARGIN_LEFT_RIGHT * 2), TheTownCamera.CAMERA_HEIGHT - (MARGIN_TOP_BOTTOM * 2), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setColor(1, 0, 0);                  
      setVisible(false);
      
      closeDialogButton       = new SimpleCloseDialogButton(this);
      foodClickersShopPanel   = new FoodClickersShopPanel();
      woodClickersShopPanel   = new WoodClickersShopPanel();
      
      foodClickersShopPanel.setHeight(getHeight() - (PADDING + PADDING_TOP));
      foodClickersShopPanel.setWidth((getWidth() - (PADDING * 4)) / 2);
      foodClickersShopPanel.setX(PADDING);
      foodClickersShopPanel.setY(PADDING_TOP);
      
      woodClickersShopPanel.setHeight(getHeight() - (PADDING + PADDING_TOP));
      woodClickersShopPanel.setWidth((getWidth() - (PADDING * 4)) / 2);
      woodClickersShopPanel.setX((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3));
      woodClickersShopPanel.setY(PADDING_TOP);      
      
      closeDialogButton.setOnCloseDialogButtonClickedListener(this);      
      
      closeDialogButton.attachToParent(this);
      foodClickersShopPanel.attachToParent(this);
      woodClickersShopPanel.attachToParent(this);            
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
