package ru.majestic.thetown.view.sound.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.sound.ISoundStateView;
import ru.majestic.thetown.view.sound.listener.OnSoundStateChangedListener;

public class SoundStateView extends AnimatedSprite implements ISoundStateView {

   private static final float HEIGHT_AND_WIDTH = 40;
   
   private OnSoundStateChangedListener onSoundStateChangedListener;
   
   public SoundStateView(float x, float y) {
      super(x, y, HEIGHT_AND_WIDTH, HEIGHT_AND_WIDTH, ResourceManager.getInstance().getSoundIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setSoundEnaled(true);
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
   public void setOnSoundStateChangedListener(OnSoundStateChangedListener onSoundStateChangedListener) {
      this.onSoundStateChangedListener = onSoundStateChangedListener;
   }
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {
          onSoundStateChangedListener.onSoundStateChanged();
       }
       return true;
   };

   @Override
   public void setSoundEnaled(boolean enabled) {
      if(enabled)
         setCurrentTileIndex(0);
      else
         setCurrentTileIndex(1);
   }

}
