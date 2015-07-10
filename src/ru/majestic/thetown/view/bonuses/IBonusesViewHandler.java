package ru.majestic.thetown.view.bonuses;

import ru.majestic.thetown.view.bonuses.handler.listeners.OnBonusDropedListener;


public interface IBonusesViewHandler {           
   
   public void begin ();
   public void end   ();
   
   public void setOnBonusDropedListener(OnBonusDropedListener onBonusDropedListener);
   
}
