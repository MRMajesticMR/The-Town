package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.IWorkerShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.IWorkersShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public class WorkersShopPanel extends Rectangle implements IWorkersShopPanel {
   
   private static final int PANEL_HEIGHT  = 80; 
   private static final int PANEL_SPACE   = 4;    
   
   private IWorkerShopPanel[] workerShopPanels;
   
   public WorkersShopPanel(int x, int y, int width, IShopDialog shop, IWorker[] workers) {
      super(x, y, width, shop.getHeight() - shop.getResoucesShopPanel().getY() - shop.getResoucesShopPanel().getHeight() - 64, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());           
      
      setAlpha(0.0f);
      setVisible(false);
      
      workerShopPanels = new IWorkerShopPanel[workers.length];
      
      for(int i = 0; i < workerShopPanels.length; i++) {
         workerShopPanels[i] = new WorkerShopPanel(0, (PANEL_SPACE + PANEL_HEIGHT) * i, (int) getWidth(), PANEL_HEIGHT, workers[i]);
         workerShopPanels[i].attachToParent(this);
      }
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void show() {      
      setVisible(true);      
   }

   @Override
   public void hide() {
      setVisible(false);      
   }

   @Override
   public void registerTouchArea(Scene scene) {
      for(int i = 0; i < workerShopPanels.length; i++) {
         workerShopPanels[i].registerTouchArea(scene);
      }      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      for(int i = 0; i < workerShopPanels.length; i++) {
         workerShopPanels[i].unregisterTouchArea(scene);
      }      
   }

   @Override
   public void update(IGameManager gameManager) {
      for(int i = 0; i < workerShopPanels.length; i++) {
         workerShopPanels[i].update();
         workerShopPanels[i].setAvailable(isWorkerAvailable(workerShopPanels[i].getWorker(), gameManager));
      }      
   }
   
   private boolean isWorkerAvailable(IWorker worker, IGameManager gameManager) {
      if(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount() < worker.getFoodCost())
         return false;
      if(gameManager.getBuildingsManager().getTotalHomePlacesCount() - gameManager.getWorkersManager().getTotalHomeForWorkers() < worker.getHomePlaces())
         return false;      
      
      return true;
   }

   @Override
   public void setWorkerShopPanelActionListener(WorkerShopPanelActionListener workerShopPanelActionListener) {
      for(int i = 0; i < workerShopPanels.length; i++) {
         workerShopPanels[i].setWorkerShopPanelActionListener(workerShopPanelActionListener);
      }
      
   }

}
