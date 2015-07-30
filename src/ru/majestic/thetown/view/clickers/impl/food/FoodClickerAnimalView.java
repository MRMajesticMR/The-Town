package ru.majestic.thetown.view.clickers.impl.food;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.IModifier.IModifierListener;

import ru.majestic.thetown.resources.ResourceManager;

public class FoodClickerAnimalView extends AnimatedSprite implements IModifierListener<IEntity> {
      
   static final long    ANIMATION_FRAME_LENGTH  = 700;
   static final float   DISTANCE               = 30;
   
   MoveXModifier moveLeftModifier;
   DelayModifier delayModifier;
   MoveXModifier moveRightModifier;
   
   boolean currentDirectionLeft;
   
   public FoodClickerAnimalView(float x, float y, float width, float height, ITiledTextureRegion pTiledTextureRegion, float distance, boolean leftDirection) {
      super(x, y, width, height, pTiledTextureRegion, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      initModifiers(distance, leftDirection);
      
      currentDirectionLeft = leftDirection;
      
      if(currentDirectionLeft)
         registerEntityModifier(moveLeftModifier);
      else
         registerEntityModifier(moveRightModifier);
   }     

   
   private void initModifiers(float distance, boolean leftDirection) {
      
      if(leftDirection) {
         moveLeftModifier  = new MoveXModifier(distance / 10.0f, getX(), getX() - distance);      
         moveRightModifier  = new MoveXModifier(distance / 10.0f, getX() - distance, getX());
      } else {
         moveRightModifier  = new MoveXModifier(distance / 10.0f, getX(), getX() + distance);
         moveLeftModifier  = new MoveXModifier(distance / 10.0f, getX() + distance, getX());               
      }
      
      delayModifier     = new DelayModifier(2.0f);
      
      moveLeftModifier.addModifierListener(this);
      delayModifier.addModifierListener(this);
      moveRightModifier.addModifierListener(this);
   }


   @Override
   public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
      if(pModifier == moveLeftModifier || pModifier == moveRightModifier) {
         animate(ANIMATION_FRAME_LENGTH);
         setFlippedHorizontal(!currentDirectionLeft);
         return;
      }
            
      
      if(pModifier == delayModifier) {
         stopAnimation(1);
      }
   }


   @Override
   public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
      if(pModifier == moveLeftModifier || pModifier == moveRightModifier) {
         delayModifier.reset();
         registerEntityModifier(delayModifier);
         return;
      }
      
      if(pModifier == delayModifier) {
         if(currentDirectionLeft) {
            moveRightModifier.reset();
            registerEntityModifier(moveRightModifier);
         } else {
            moveLeftModifier.reset();
            registerEntityModifier(moveLeftModifier);
         }
                  
         currentDirectionLeft = !currentDirectionLeft;         
      }
   }
}
