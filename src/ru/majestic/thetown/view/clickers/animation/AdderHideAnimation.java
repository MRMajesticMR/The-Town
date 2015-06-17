package ru.majestic.thetown.view.clickers.animation;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.FadeOutModifier;
import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.ParallelEntityModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.util.modifier.IModifier;

public class AdderHideAnimation extends ParallelEntityModifier {
   
   public AdderHideAnimation() {
      super(new SequenceEntityModifier(
                  new DelayModifier(1.5f),
                  new FadeOutModifier(1.0f)),
            new MoveYModifier(1.5f, 0, -300));
      
      addModifierListener(new IModifierListener<IEntity>() {
         
         @Override
         public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
            //.            
         }
         
         @Override
         public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
            pItem.getParent().setVisible(false);
         }
      });
   }
}
