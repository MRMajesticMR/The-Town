package ru.majestic.thetown.view.bonuses;

import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.view.IMoveableView;
import ru.majestic.thetown.view.bonuses.listeners.OnBonusTouchTheGroundListener;

public interface IBonusCargoView extends IMoveableView {
   
   public void setOnBonusTouchTheGroundListener(OnBonusTouchTheGroundListener onBonusTouchTheGroundListener);
   
   public void       setBonus(IGameBonus gameBonus);
   public IGameBonus getBonus();

}
