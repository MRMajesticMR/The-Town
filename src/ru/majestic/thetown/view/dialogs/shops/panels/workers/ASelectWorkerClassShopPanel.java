package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopSelectedListener;

public abstract class ASelectWorkerClassShopPanel extends Rectangle implements ISelectWorkerClassShopPanel {
         
   protected OnWorkerClassShopSelectedListener     onWorkerClassShopSelectedListener;   
   protected ISelectWorkerClassShopPanelButton[]   menuButtons;
   
   public ASelectWorkerClassShopPanel(float pX, float pY, float pWidth, float pHeight) {
      super(pX, pY, pWidth, pHeight, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
   }

   @Override
   public void registerTouchArea(Scene scene) {
      for(ISelectWorkerClassShopPanelButton button: menuButtons)
         button.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      for(ISelectWorkerClassShopPanelButton button: menuButtons)
         button.unregisterTouchArea(scene);      
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void setOnWorkerClassShopSelectedListener(OnWorkerClassShopSelectedListener onWorkerClassShopSelectedListener) {
      this.onWorkerClassShopSelectedListener = onWorkerClassShopSelectedListener;
   }

}
