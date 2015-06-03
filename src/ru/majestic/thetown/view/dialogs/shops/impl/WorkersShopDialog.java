package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ISelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.IWorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.DefenceWorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.FoodWorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.SelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.WoodWorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopSelectedListener;

public class WorkersShopDialog extends AShopDialog implements OnWorkerClassShopSelectedListener {

   private static final int TOTAL_SHOPS_PANEL_COUNT = 3;
   
   private static final int SHOP_INDEX_WOOD         = 0;
   private static final int SHOP_INDEX_FOOD         = 1;   
   private static final int SHOP_INDEX_DEFENECE     = 2;
   
   private     ISelectWorkerClassShopPanel            selectWorkerClassShopPanel;
   protected   IWorkersShopPanel[]                    shopPanels;
   
   public WorkersShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      selectWorkerClassShopPanel = new SelectWorkerClassShopPanel(this);
      selectWorkerClassShopPanel.setOnWorkerClassShopSelectedListener(this);
      selectWorkerClassShopPanel.attachToParent(this);
      
      shopPanels = new IWorkersShopPanel[TOTAL_SHOPS_PANEL_COUNT];
      
      shopPanels[SHOP_INDEX_WOOD]      = new WoodWorkersShopPanel      (this);
      shopPanels[SHOP_INDEX_FOOD]      = new FoodWorkersShopPanel      (this);
      shopPanels[SHOP_INDEX_DEFENECE]  = new DefenceWorkersShopPanel   (this);
      
      for(int i = 0; i < TOTAL_SHOPS_PANEL_COUNT; i++) {
         shopPanels[i].attachToParent(this);
      }
      
      shopPanels[SHOP_INDEX_WOOD].show();
   }   
   
   @Override
   public void registerTouchArea(Scene scene) {
      super.registerTouchArea(scene);      
      selectWorkerClassShopPanel.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      super.unregisterTouchArea(scene);
      selectWorkerClassShopPanel.unregisterTouchArea(scene);
   }

   @Override
   public void onWorkerClassShopSelectedListener(int shopIndex) {
      for(int i = 0; i < shopPanels.length; i++)
         shopPanels[i].hide();
      
      shopPanels[shopIndex].show();     
   }

}
