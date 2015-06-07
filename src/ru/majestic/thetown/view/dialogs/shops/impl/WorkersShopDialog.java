package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.WorkersShopDialogActionListener;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ISelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.IWorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.SelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.WorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopSelectedListener;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public class WorkersShopDialog extends AShopDialog implements OnWorkerClassShopSelectedListener,
                                                              WorkerShopPanelActionListener {

   private static final int TOTAL_SHOPS_PANEL_COUNT = 3;
   
   private static final int SHOP_INDEX_WOOD         = 0;
   private static final int SHOP_INDEX_FOOD         = 1;   
   private static final int SHOP_INDEX_DEFENECE     = 2;
   
   private     WorkersShopDialogActionListener        workersShopDialogActionListener;
   
   private     ISelectWorkerClassShopPanel            selectWorkerClassShopPanel;
   protected   IWorkersShopPanel[]                    shopPanels;
   
   private     Scene                                  scene;
   private     int                                    lastSelectedShopPanel;
   
   public WorkersShopDialog(IGameManager gameManager, Scene scene) {
      super(gameManager);
      
      this.scene = scene;
      
      selectWorkerClassShopPanel = new SelectWorkerClassShopPanel(this);
      selectWorkerClassShopPanel.setOnWorkerClassShopSelectedListener(this);
      selectWorkerClassShopPanel.attachToParent(this);
      
      shopPanels = new IWorkersShopPanel[TOTAL_SHOPS_PANEL_COUNT];
      
      shopPanels[SHOP_INDEX_WOOD]      = new WorkersShopPanel(PADDINGS_LEFT_RIGHT, (int) (getResoucesShopPanel().getY() + getResoucesShopPanel().getHeight()) + 4, (int) getWidth() - (PADDINGS_LEFT_RIGHT * 2), this, gameManager.getWorkersManager().getWorkersByType(WorkerType.WOOD));
      shopPanels[SHOP_INDEX_FOOD]      = new WorkersShopPanel(PADDINGS_LEFT_RIGHT, (int) (getResoucesShopPanel().getY() + getResoucesShopPanel().getHeight()) + 4, (int) getWidth() - (PADDINGS_LEFT_RIGHT * 2), this, gameManager.getWorkersManager().getWorkersByType(WorkerType.FOOD));
      shopPanels[SHOP_INDEX_DEFENECE]  = new WorkersShopPanel(PADDINGS_LEFT_RIGHT, (int) (getResoucesShopPanel().getY() + getResoucesShopPanel().getHeight()) + 4, (int) getWidth() - (PADDINGS_LEFT_RIGHT * 2), this, gameManager.getWorkersManager().getWorkersByType(WorkerType.DEFENCE));
      
      for(int i = 0; i < TOTAL_SHOPS_PANEL_COUNT; i++) {
         shopPanels[i].setWorkerShopPanelActionListener(this);
         shopPanels[i].attachToParent(this);
      }      
      
      lastSelectedShopPanel = SHOP_INDEX_WOOD;
   }   
   
   @Override
   public void show() {
      super.show();
      
      shopPanels[lastSelectedShopPanel].show();
      shopPanels[lastSelectedShopPanel].registerTouchArea(scene);
   }
   
   @Override
   public void hide() {
      super.hide();
      
      shopPanels[lastSelectedShopPanel].hide();
      shopPanels[lastSelectedShopPanel].unregisterTouchArea(scene);
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
      for(int i = 0; i < shopPanels.length; i++) {
         shopPanels[i].hide();
         shopPanels[i].unregisterTouchArea(scene);
      }
      
      lastSelectedShopPanel = shopIndex;
      
      shopPanels[shopIndex].show();
      shopPanels[shopIndex].registerTouchArea(scene);
   }
   
   @Override
   public void update() {
      super.update();
      for(int i = 0; i < shopPanels.length; i++) {
         shopPanels[i].update();
      }     
   }
   
   public void setWorkersShopDialogActionListener(WorkersShopDialogActionListener workersShopDialogActionListener) {
      this.workersShopDialogActionListener = workersShopDialogActionListener;
   }

   @Override
   public void onBuyButtonClicked(IWorker worker) {
      workersShopDialogActionListener.onBuyWorkerAction(worker);
   }

}
