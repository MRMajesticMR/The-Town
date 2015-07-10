package ru.majestic.thetown.view.bonuses.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.bonuses.IPlaneView;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneClickedListener;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneOutOfViewListener;

public class PlaneView extends Sprite implements IPlaneView {

   private static final int WIDTH   = 80;
   private static final int HEIGHT  = 80;   
   
   private float xSpeed;
   
   private OnPlaneOutOfViewListener onPlaneOutOfViewListener;   
   private OnPlaneClickedListener   onPlaneClickedListener;
   
   private boolean hasBonus;
   
   public PlaneView() {
      super(-WIDTH, 0, WIDTH, HEIGHT, ResourceManager.getInstance().getBonusesResourcesManager().getPlaneTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      xSpeed = 1.0f;       
      hasBonus = true;
      pause();
   }   
   
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
      parent.attachChild(this);      
   }

   @Override
   public void setOnPlaneClickedListener(OnPlaneClickedListener onPlaneClickedListener) {
      this.onPlaneClickedListener = onPlaneClickedListener;
   }
   
   @Override
   public void onManagedUpdate(float pSecondsElapsed) {
      setX(getX() + xSpeed);
      
      if(getX() > TheTownCamera.CAMERA_WIDTH) {         
         onPlaneOutOfViewListener.onPlaneOutOfView(this);
      }
   }

   @Override
   public void pause() {
      setIgnoreUpdate(true);
   }

   @Override
   public void unpause() {
      setIgnoreUpdate(false);            
   }

   @Override
   public void setOnPlaneOutOfViewListener(OnPlaneOutOfViewListener onPlaneOutOfViewListener) {
      this.onPlaneOutOfViewListener = onPlaneOutOfViewListener;
   }
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {          
          onPlaneClickedListener.onPlaneClicked(this);
          hasBonus = false;
       }
       return true;
   }

   @Override
   public boolean hasBonus() {
      return hasBonus;
   }

   @Override
   public void setBonus() {
      hasBonus = true;
   };

}
