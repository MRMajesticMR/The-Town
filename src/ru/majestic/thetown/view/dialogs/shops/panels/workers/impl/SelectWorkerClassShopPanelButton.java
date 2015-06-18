package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ISelectWorkerClassShopPanelButton;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopButtonClickedListener;

public class SelectWorkerClassShopPanelButton extends Sprite implements ISelectWorkerClassShopPanelButton {

   private OnWorkerClassShopButtonClickedListener onWorkerClassShopButtonClickedListener;
   
   private Text   menuText;
   
   public SelectWorkerClassShopPanelButton(String text) {
      super(0, 0, 0, 0, ResourceManager.getInstance().getWorkersTypeBtnBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      menuText = new Text(0, 0, ResourceManager.getInstance().getMenuButtonsFont(), text, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      
      attachChild(menuText);
      
      setActive(false);     
   }
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {
          onWorkerClassShopButtonClickedListener.onWorkerClassShopButtonClicked(this);
       }
       return true;
   };      

   @Override
   public void registerTouchArea(Scene scene) {      
      scene.registerTouchArea(this);
   }
   
   @Override
   public void unregisterTouchArea(Scene scene) {
      scene.unregisterTouchArea(this);
   }

   @Override
   public void attachToParent(Entity parent) {
      setNewTextPosition();
      
      parent.attachChild(this);
   }
   
   private void setNewTextPosition() {
      menuText.setX((getWidth() - menuText.getWidth()) / 2);
      menuText.setY((getHeight() - menuText.getHeight()) / 2);
   }

   @Override
   public void setActive(boolean active) {
      if(active) {
         setColor(0.3f, 1f, 0.3f);
      } else {
         setColor(1, 1, 1);
      }
   }

   @Override
   public void setOnWorkerClassShopButtonClickedListener(OnWorkerClassShopButtonClickedListener onWorkerClassShopButtonClickedListener) {
      this.onWorkerClassShopButtonClickedListener = onWorkerClassShopButtonClickedListener;
   }   

}
