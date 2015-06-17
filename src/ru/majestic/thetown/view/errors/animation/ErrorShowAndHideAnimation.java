package ru.majestic.thetown.view.errors.animation;

import org.andengine.entity.modifier.FadeOutModifier;
import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.modifier.ParallelEntityModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;

public class ErrorShowAndHideAnimation extends ParallelEntityModifier {

   public ErrorShowAndHideAnimation() {
      super(new SequenceEntityModifier(
            new FadeOutModifier(1.0f)),
      new MoveYModifier(1.0f, 0, -100));
   }
}
