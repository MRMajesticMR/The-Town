package ru.majestic.thetown.view.dialogs.clickers.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.GameManagerHelper;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.impl.SimpleCloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;
import ru.majestic.thetown.view.dialogs.clickers.IClickersShopDialog;
import ru.majestic.thetown.view.dialogs.clickers.IClickersShopPanel;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;

public class ClickersShopDialog extends Rectangle implements IClickersShopDialog,
                                                             OnCloseDialogButtonClickedListener,
                                                             ClickersShopPanelActionsListener {
   
   private static final int MARGIN_TOP_BOTTOM = 60;
   private static final int MARGIN_LEFT_RIGHT = 30;
   
   private static final int PADDING_TOP   = 50;
   private static final int PADDING       = 10;
   
   private OnDialogClosedListener            onDialogClosedListener;
   private ClickersShopDialogActionsListener clickersShopDialogActionsListener;
   
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
      
      foodClickersShopPanel.setClickersShopPanelActionsListener(this);
      
      woodClickersShopPanel.setHeight(getHeight() - (PADDING + PADDING_TOP));
      woodClickersShopPanel.setWidth((getWidth() - (PADDING * 4)) / 2);
      woodClickersShopPanel.setX((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3));
      woodClickersShopPanel.setY(PADDING_TOP);            
      
      woodClickersShopPanel.setClickersShopPanelActionsListener(this);
      
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
      foodClickersShopPanel.registerTouchArea(scene);
      woodClickersShopPanel.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      closeDialogButton.unregisterTouchArea(scene);
      foodClickersShopPanel.unregisterTouchArea(scene);
      woodClickersShopPanel.unregisterTouchArea(scene);
   }

   @Override
   public void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
      this.onDialogClosedListener = onDialogClosedListener;
   }

   @Override
   public void onCloseDialogButtonClicked() {
      onDialogClosedListener.onDialogClosed(this);
   }

   @Override
   public void onUpdateButtonClicked(IClickersShopPanel clickersShopPanel) {
      if(clickersShopPanel == foodClickersShopPanel) {
         clickersShopDialogActionsListener.onUpgradeFoodClickerClicked();
         return;
      }
      
      if(clickersShopPanel == woodClickersShopPanel) {
         clickersShopDialogActionsListener.onUpgradeWoodClickerClicked();
         return;
      }
      
   }
   
   @Override
   public void setClickersShopDialogActionsListener(ClickersShopDialogActionsListener clickersShopDialogActionsListener) {
      this.clickersShopDialogActionsListener = clickersShopDialogActionsListener;
   }

   @Override
   public void onFoodClickerLvlChanged(int newLvl) {
      foodClickersShopPanel.showCurrentClickerLvl(newLvl);
      foodClickersShopPanel.showCurrentClickerResourcesPerClick(GameManagerHelper.calculateResourcesPerClickFromLvl(newLvl));
      foodClickersShopPanel.showUpgradePrice(GameManagerHelper.calculateUpgradeCostFromLvl(newLvl));      
   }

   @Override
   public void onWoodClickerLvlChanged(int newLvl) {
      woodClickersShopPanel.showCurrentClickerLvl(newLvl);
      woodClickersShopPanel.showCurrentClickerResourcesPerClick(GameManagerHelper.calculateResourcesPerClickFromLvl(newLvl));
      woodClickersShopPanel.showUpgradePrice(GameManagerHelper.calculateUpgradeCostFromLvl(newLvl));      
   }

}
