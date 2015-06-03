package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.IClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl.FoodClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl.WoodClickersShopPanel;

public class ClickersShopDialog extends AShopDialog implements ClickersShopPanelActionsListener {
   
   private static final int PADDING       = 4;
   
   private ClickersShopDialogActionsListener clickersShopDialogActionsListener;
   
   private IClickersShopPanel foodClickersShopPanel;
   private IClickersShopPanel woodClickersShopPanel;   
   
   public ClickersShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      foodClickersShopPanel   = new FoodClickersShopPanel(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD));
      woodClickersShopPanel   = new WoodClickersShopPanel(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD));
      
      foodClickersShopPanel.setHeight(190);
      foodClickersShopPanel.setWidth((getWidth() - (PADDING * 4)) / 2);
      foodClickersShopPanel.setX(PADDING);
      foodClickersShopPanel.setY(getResoucesShopPanel().getY() + getResoucesShopPanel().getHeight() + 4);            
      
      foodClickersShopPanel.setClickersShopPanelActionsListener(this);
      
      woodClickersShopPanel.setHeight(190);
      woodClickersShopPanel.setWidth((getWidth() - (PADDING * 4)) / 2);
      woodClickersShopPanel.setX((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3));
      woodClickersShopPanel.setY(getResoucesShopPanel().getY() + getResoucesShopPanel().getHeight() + 4);            
      
      woodClickersShopPanel.setClickersShopPanelActionsListener(this);
      
      foodClickersShopPanel.attachToParent(this);
      woodClickersShopPanel.attachToParent(this);            
   }

   @Override
   public void attachToParent(Entity parent) {
      super.attachToParent(parent);
   }

   @Override
   public void registerTouchArea(Scene scene) {
      super.registerTouchArea(scene);
      
      foodClickersShopPanel.registerTouchArea(scene);
      woodClickersShopPanel.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      super.unregisterTouchArea(scene);
      
      foodClickersShopPanel.unregisterTouchArea(scene);
      woodClickersShopPanel.unregisterTouchArea(scene);
   }
   
   @Override
   public void onUpdateButtonClicked(IClicker clicker) {
      clickersShopDialogActionsListener.onUpgradeClickerButtonClicked(clicker);      
   }
   
   @Override
   public void update() {
      super.update();
      
      foodClickersShopPanel.update();
      woodClickersShopPanel.update();
   }
   
   public void setClickersShopDialogActionsListener(ClickersShopDialogActionsListener clickersShopDialogActionsListener) {
      this.clickersShopDialogActionsListener = clickersShopDialogActionsListener;
   }

}
