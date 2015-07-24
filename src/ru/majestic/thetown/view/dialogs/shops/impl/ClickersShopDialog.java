package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.AClickersShopPanelSkeleton;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl.FoodClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl.WoodClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.ACargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.ICargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.ICargoUpgradePanel.OnCargoUpgradeButtonClickListener;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.impl.FoodCargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.warehouse.impl.WoodCargoUpgradePanel;

public class ClickersShopDialog extends AShopDialog implements ClickersShopPanelActionsListener,
                                                               OnCargoUpgradeButtonClickListener {
   
   private static final int PADDING       = 4;
   
   private ClickersShopDialogActionsListener clickersShopDialogActionsListener;
   
   private WoodClickersShopPanel woodClickersShopPanel;
   private FoodClickersShopPanel foodClickersShopPanel;   
   
   private WoodCargoUpgradePanel woodCargoUpgradePanel;
   private FoodCargoUpgradePanel foodCargoUpgradePanel;   
   
   public ClickersShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      foodClickersShopPanel   = new FoodClickersShopPanel(PADDING, getHeight() - PADDING  - AClickersShopPanelSkeleton.HEIGHT - getBuyGoldShopPanel().getHeight(), (getWidth() - (PADDING * 4)) / 2, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD));
      woodClickersShopPanel   = new WoodClickersShopPanel((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3), getHeight() - PADDING - AClickersShopPanelSkeleton.HEIGHT - getBuyGoldShopPanel().getHeight(), (getWidth() - (PADDING * 4)) / 2, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD));
      foodCargoUpgradePanel   = new FoodCargoUpgradePanel(PADDING, foodClickersShopPanel.getY() - ACargoUpgradePanel.HEIGHT - PADDING, (getWidth() - (PADDING * 4)) / 2);
      woodCargoUpgradePanel   = new WoodCargoUpgradePanel((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3), woodClickersShopPanel.getY() - ACargoUpgradePanel.HEIGHT - PADDING, (getWidth() - (PADDING * 4)) / 2);           
      
      foodClickersShopPanel.setClickersShopPanelActionsListener(this);      
      woodClickersShopPanel.setClickersShopPanelActionsListener(this);
      foodCargoUpgradePanel.setOnCargoUpgradeButtonClickListener(this);
      woodCargoUpgradePanel.setOnCargoUpgradeButtonClickListener(this);
      
      foodClickersShopPanel.attachToParent(this);      
      woodClickersShopPanel.attachToParent(this);
      foodCargoUpgradePanel.attachToParent(this);
      woodCargoUpgradePanel.attachToParent(this);
      
      updatePanels();
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
      foodCargoUpgradePanel.registerTouchArea(scene);
      woodCargoUpgradePanel.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      super.unregisterTouchArea(scene);
      
      foodClickersShopPanel.unregisterTouchArea(scene);      
      woodClickersShopPanel.unregisterTouchArea(scene);
      foodCargoUpgradePanel.unregisterTouchArea(scene);
      woodCargoUpgradePanel.unregisterTouchArea(scene);
   }
   
   @Override
   public void onUpdateButtonClicked(IClicker clicker) {
      if(clickersShopDialogActionsListener != null)
         clickersShopDialogActionsListener.onUpgradeClickerButtonClicked(clicker);      
   }
   
   @Override
   public void update() {
      super.update();
      
      updatePanels();
   }
   
   public void setClickersShopDialogActionsListener(ClickersShopDialogActionsListener clickersShopDialogActionsListener) {
      this.clickersShopDialogActionsListener = clickersShopDialogActionsListener;
   }
   
   private void updatePanels() {
      foodClickersShopPanel.update(gameManager.getCargoManager());
      woodClickersShopPanel.update(gameManager.getCargoManager());
      
      woodCargoUpgradePanel.update(gameManager.getCargoManager().getWoodCargo());
      foodCargoUpgradePanel.update(gameManager.getCargoManager().getFoodCargo());
      
      woodCargoUpgradePanel.setAvailable(gameManager.getCargoManager().getFoodCargo().getCurrentCount() >= gameManager.getCargoManager().getWoodCargo().getUpgradePrice());
      foodCargoUpgradePanel.setAvailable(gameManager.getCargoManager().getWoodCargo().getCurrentCount() >= gameManager.getCargoManager().getFoodCargo().getUpgradePrice());
   }

   @Override
   public void onCargoUpgradeButtonClick(ICargoUpgradePanel cargoUpgradePanel) {
      if(clickersShopDialogActionsListener != null){         
         if(cargoUpgradePanel == woodCargoUpgradePanel) {
            clickersShopDialogActionsListener.onUpgradeCargoButtonClicker(gameManager.getCargoManager().getWoodCargo());
         } else if (cargoUpgradePanel == foodCargoUpgradePanel) {
            clickersShopDialogActionsListener.onUpgradeCargoButtonClicker(gameManager.getCargoManager().getFoodCargo());
         }
      }
   }

}
