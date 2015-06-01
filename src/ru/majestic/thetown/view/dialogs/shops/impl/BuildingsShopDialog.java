package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IBuildingsManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.BuildingsShopDialogActionListeners;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.IBuildingShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.impl.BuildingShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.listeners.BuildingShopPanelActionListener;

public class BuildingsShopDialog extends AShopDialog implements BuildingShopPanelActionListener {
   
   private IBuildingShopPanel[] buildingBuyPanels;
   
   private BuildingsShopDialogActionListeners buildingsShopDialogActionListeners;
   
   public BuildingsShopDialog(IBuildingsManager buildingsManager) {
      super();
      
      buildingBuyPanels = new IBuildingShopPanel[1];
      
      buildingBuyPanels[0] = new BuildingShopPanel(PADDINGS_LEFT_RIGHT, PADDING_TOP, (int) getWidth() - (PADDINGS_LEFT_RIGHT * 2), buildingsManager.getBuilding(IBuildingsManager.BUILDING_TYPE_TENT));
      
      for(IBuildingShopPanel buildingShopPanel: buildingBuyPanels) {
         buildingShopPanel.update();
         buildingShopPanel.setBuildingShopPanelActionListener(this);
      }
   }   
   
   public void update() {
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
