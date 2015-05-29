package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.GameManagerHelper;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.IClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.impl.FoodClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.impl.WoodClickersShopPanel;

public class ClickersShopDialog extends AShopDialog implements ClickersShopPanelActionsListener {
   
   
   private static final int PADDING_TOP   = 50;
   private static final int PADDING       = 10;
   
   private ClickersShopDialogActionsListener clickersShopDialogActionsListener;
   
   private IClickersShopPanel foodClickersShopPanel;
   private IClickersShopPanel woodClickersShopPanel;   
   
   public ClickersShopDialog() {
      super();
      
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
   
   public void setClickersShopDialogActionsListener(ClickersShopDialogActionsListener clickersShopDialogActionsListener) {
      this.clickersShopDialogActionsListener = clickersShopDialogActionsListener;
   }

   public void onFoodClickerLvlChanged(int newLvl) {
      foodClickersShopPanel.showCurrentClickerLvl(newLvl);
      foodClickersShopPanel.showCurrentClickerResourcesPerClick(GameManagerHelper.calculateResourcesPerClickFromLvl(newLvl));
      foodClickersShopPanel.showUpgradePrice(GameManagerHelper.calculateUpgradeCostFromLvl(newLvl));      
   }

   public void onWoodClickerLvlChanged(int newLvl) {
      woodClickersShopPanel.showCurrentClickerLvl(newLvl);
      woodClickersShopPanel.showCurrentClickerResourcesPerClick(GameManagerHelper.calculateResourcesPerClickFromLvl(newLvl));
      woodClickersShopPanel.showUpgradePrice(GameManagerHelper.calculateUpgradeCostFromLvl(newLvl));      
   }

}
