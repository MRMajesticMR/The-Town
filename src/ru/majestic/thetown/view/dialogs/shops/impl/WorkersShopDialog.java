package ru.majestic.thetown.view.dialogs.shops.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.view.dialogs.shops.AShopDialog;

public class WorkersShopDialog extends AShopDialog {
   
   public WorkersShopDialog(IGameManager gameManager) {
      super(gameManager);
      
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
      super.attachToParent(parent);
      ///.
   }

}
