package ru.majestic.thetown.view.bonuses;

import ru.majestic.thetown.view.IMoveableView;
import ru.majestic.thetown.view.bonuses.listeners.OnBonusTouchTheGroundListener;

public interface IBonusCargoView extends IMoveableView {
   
   public void setOnBonusTouchTheGroundListener(OnBonusTouchTheGroundListener onBonusTouchTheGroundListener);

}
