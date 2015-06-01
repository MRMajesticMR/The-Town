package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.IBuildingShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.impl.TentBuildingsShopPanel;

public class BuildingsShopDialog extends AShopDialog {
   
   private IBuildingShopPanel[] buildingBuyPanels;
   
   public BuildingsShopDialog() {
      super();
      
      buildingBuyPanels = new IBuildingShopPanel[1];
      
      buildingBuyPanels[0] = new TentBuildingsShopPanel(PADDINGS_LEFT_RIGHT, PADDING_TOP, (int) getWidth() - (PADDINGS_LEFT_RIGHT * 2));
   }   
   
   @Override
   public void registerTouchArea(Scene scene) {
      super.registerTouchArea(scene);
      ///.
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      super.unregisterTouchArea(scene);
      ///.
   }

   @Override
   public void attachToParent(Entity parent) {
      for(IBuildingShopPanel panel: buildingBuyPanels)
         panel.attachToParent(this);
      
      super.attachToParent(parent);
   }

}
