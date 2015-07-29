package ru.majestic.thetown.view.bonuses.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.IModifier.IModifierListener;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.bonuses.IBonusCargoView;
import ru.majestic.thetown.view.bonuses.listeners.OnBonusTouchTheGroundListener;

public class BonusCargoView extends AnimatedSprite implements IBonusCargoView,
                                                              IModifierListener<IEntity> {

   static final int     WIDTH       = 30;
   static final int     HEIGHT      = 30;      
   static final float   SPEED       = 2.0f;   
   
   static final long    ANIMATION_FRAME_DURATION = 60;
   static final int     FRAME_COUNT = 5;
   
   float groundLevel;
   OnBonusTouchTheGroundListener onBonusTouchTheGroundListener;      
   boolean groundReached;
   
   SequenceEntityModifier hideBoxModifier;
   
   public BonusCargoView() {
      super(0, 0, WIDTH, HEIGHT, ResourceManager.getInstance().getBonusesResourcesManager().getCargoTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      groundReached = false;      
      
      hideBoxModifier = new SequenceEntityModifier(
            new DelayModifier((ANIMATION_FRAME_DURATION / 1000.0f) * FRAME_COUNT),
            new AlphaModifier(1.0f, 1.0f, 0.0f));
      
      hideBoxModifier.addModifierListener(this);
      
      setAlpha(0.0f);
      setIgnoreUpdate(true);
   }
   
   public void drop(float x, float y) {
      groundReached = false;
      
      setX(x);
      setY(y);            
      setCurrentTileIndex(0);
      setAlpha(1.0f);
      setIgnoreUpdate(false);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void pause() {
      setVisible(false);
      setIgnoreUpdate(true);
   }

   @Override
   public void unpause() {
      setVisible(true);
      setIgnoreUpdate(false);
   }
   
   @Override
   public void onManagedUpdate(float pSecondsElapsed) {            
      if(getY() >= groundLevel) {
         if(!groundReached) {
            groundReached = true;
            
            onBonusTouchTheGroundListener.onBonusTouchTheGround();
            animate(ANIMATION_FRAME_DURATION, false);
            hideBoxModifier.reset();
            registerEntityModifier(hideBoxModifier);
         }                           
      } else {          
         float newYPosition = getY() + SPEED;
         
         if(newYPosition > groundLevel) newYPosition = groundLevel;
         
         setY(newYPosition);
      }
      
      super.onManagedUpdate(pSecondsElapsed);
   }

   @Override
   public void setGroundLevel(float groundLevel) {
      this.groundLevel = groundLevel;      
   }
   
   @Override
   public void setOnBonusTouchTheGroundListener(OnBonusTouchTheGroundListener onBonusTouchTheGroundListener) {
      this.onBonusTouchTheGroundListener = onBonusTouchTheGroundListener;
   }

   @Override
   public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
      //.      
   }

   @Override
   public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
      setIgnoreUpdate(true);      
   }   

}
