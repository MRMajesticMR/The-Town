package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.AWorkersShopPanel;

public class WoodWorkersShopPanel extends AWorkersShopPanel {

   public WoodWorkersShopPanel(IShopDialog shop) {
      super(shop);
      
      setColor(0, 1, 1);
   }

   @Override
   public void registerTouchArea(Scene scene) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      // TODO Auto-generated method stub
      
   }

}
