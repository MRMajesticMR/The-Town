package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ISelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.impl.SelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopSelectedListener;

public class WorkersShopDialog extends AShopDialog implements OnWorkerClassShopSelectedListener {

   private ISelectWorkerClassShopPanel selectWorkerClassShopPanel;
   
   public WorkersShopDialog(IGameManager gameManager) {
      super(gameManager);
      
      selectWorkerClassShopPanel = new SelectWorkerClassShopPanel(this);
      selectWorkerClassShopPanel.setOnWorkerClassShopSelectedListener(this);
      selectWorkerClassShopPanel.attachToParent(this);
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
   public void onWorkerClassShopSelectedListener() {
      // TODO Auto-generated method stub
      
   }

}
