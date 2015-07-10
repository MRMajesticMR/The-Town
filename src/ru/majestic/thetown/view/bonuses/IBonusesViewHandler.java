package ru.majestic.thetown.view.bonuses;

import ru.majestic.thetown.view.bonuses.handler.listeners.OnBonusViewLandedListener;



public interface IBonusesViewHandler {           
   
   public void begin ();
   public void end   ();
   
   public void setOnBonusViewLandedListener(OnBonusViewLandedListener onBonusDropedListener);
   
}
