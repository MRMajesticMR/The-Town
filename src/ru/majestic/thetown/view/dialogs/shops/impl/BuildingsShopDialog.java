package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.BuildingsShopDialogActionListeners;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.IBuildingShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.impl.BuildingShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.listeners.BuildingShopPanelActionListener;

public class BuildingsShopDialog extends AShopDialog implements BuildingShopPanelActionListener {
   
   private static final int PANELS_COUNT = 5;
   
   private static final int PANELS_SPACE = 4;
   
   private IBuildingShopPanel[] buildingBuyPanels;   
   private BuildingsShopDialogActionListeners buildingsShopDialogActionListeners;
   
   public BuildingsShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      buildingBuyPanels = new IBuildingShopPanel[PANELS_COUNT];
      
      for(int buildingIndex = 0; buildingIndex < buildingBuyPanels.length; buildingIndex++) {
         buildingBuyPanels[buildingIndex] = new BuildingShopPanel(PADDINGS_LEFT_RIGHT, (int) (getResoucesShopPanel().getY() + getResoucesShopPanel().getHeight()) + PANELS_SPACE + (buildingIndex * (BuildingShopPanel.HEIGHT + PANELS_SPACE)), (int) getWidth() - (PADDINGS_LEFT_RIGHT * 2), gameManager.getBuildingsManager().getBuilding(buildingIndex));
         buildingBuyPanels[buildingIndex].update();
         buildingBuyPanels[buildingIndex].setBuildingShopPanelActionListener(this);
      }
   }   
   
   @Override
   public void update() {
      super.update();
      for(IBuildingShopPanel buildingShopPanel: buildingBuyPanels) {
         buildingShopPanel.update();
      }
   }
   
   public void setBuildingsShopDialogActionListeners(BuildingsShopDialogActionListeners buildingsShopDialogActionListeners) {
      this.buildingsShopDialogActionListeners = buildingsShopDialogActionListeners;
   }
   
   @Override
   public void registerTouchArea(Scene scene) {
      super.registerTouchArea(scene);
      for(IBuildingShopPanel buildingShopPanel: buildingBuyPanels)
         buildingShopPanel.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      super.unregisterTouchArea(scene);
      for(IBuildingShopPanel buildingShopPanel: buildingBuyPanels)
         buildingShopPanel.unregisterTouchArea(scene);
   }

   @Override
   public void attachToParent(Entity parent) {
      for(IBuildingShopPanel panel: buildingBuyPanels)
         panel.attachToParent(this);
      
      super.attachToParent(parent);
   }

   @Override
   public void onBuyButtonClicked(IBuilding building) {
      buildingsShopDialogActionListeners.onBuyBuildingAction(building);
   }

}
