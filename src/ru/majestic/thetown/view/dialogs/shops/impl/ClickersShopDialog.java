package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.dialogs.shops.panels.cargo.ACargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.cargo.ICargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.cargo.impl.FoodCargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.cargo.impl.WoodCargoUpgradePanel;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.IClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl.FoodClickersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.clickers.impl.WoodClickersShopPanel;

public class ClickersShopDialog extends AShopDialog implements ClickersShopPanelActionsListener {
   
   private static final int PADDING       = 4;
   
   private ClickersShopDialogActionsListener clickersShopDialogActionsListener;
   
   private IClickersShopPanel woodClickersShopPanel;
   private IClickersShopPanel foodClickersShopPanel;   
   
   private ICargoUpgradePanel foodCargoUpgradePanel;
   private ICargoUpgradePanel woodCargoUpgradePanel;
   
   public ClickersShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      woodClickersShopPanel   = new WoodClickersShopPanel(PADDING, getHeight() - PADDING - 100 - getBuyGoldShopPanel().getHeight(), (getWidth() - (PADDING * 4)) / 2, 100, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD));
      foodClickersShopPanel   = new FoodClickersShopPanel((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3), getHeight() - PADDING  - 100 - getBuyGoldShopPanel().getHeight(), (getWidth() - (PADDING * 4)) / 2, 100, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD));      
      
      woodCargoUpgradePanel   = new WoodCargoUpgradePanel(PADDING, woodClickersShopPanel.getY() - ACargoUpgradePanel.HEIGHT - PADDING, (getWidth() - (PADDING * 4)) / 2);
      foodCargoUpgradePanel   = new FoodCargoUpgradePanel((getWidth() - (PADDING * 4)) / 2 + (PADDING * 3), foodClickersShopPanel.getY() - ACargoUpgradePanel.HEIGHT - PADDING, (getWidth() - (PADDING * 4)) / 2);      
      
      foodClickersShopPanel.setClickersShopPanelActionsListener(this);      
      woodClickersShopPanel.setClickersShopPanelActionsListener(this);
      
      foodClickersShopPanel.attachToParent(this);
      woodClickersShopPanel.attachToParent(this);            
      woodCargoUpgradePanel.attachToParent(this);
      foodCargoUpgradePanel.attachToParent(this);
      
      foodClickersShopPanel.update(gameManager.getCargoManager());
      woodClickersShopPanel.update(gameManager.getCargoManager());      
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
      
      foodClickersShopPanel.update(gameManager.getCargoManager());
      woodClickersShopPanel.update(gameManager.getCargoManager());
   }
   
   public void setClickersShopDialogActionsListener(ClickersShopDialogActionsListener clickersShopDialogActionsListener) {
      this.clickersShopDialogActionsListener = clickersShopDialogActionsListener;
   }

}
