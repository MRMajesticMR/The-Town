package ru.majestic.thetown.view.dialogs.shops.panels.warehouse;

import ru.majestic.thetown.game.cargo.ISizeLimitedCargo;
import ru.majestic.thetown.view.IClickableView;

public interface ICargoUpgradePanel extends IClickableView {

   public interface OnCargoUpgradeButtonClickListener {
      
      public void onCargoUpgradeButtonClick(ICargoUpgradePanel cargoUpgradePanel);
      
   }
   
   public void setOnCargoUpgradeButtonClickListener    (OnCargoUpgradeButtonClickListener onCargoUpgradeButtonClickListener);
   public void removeOnCargoUpgradeButtonClickListener ();
   
   public void setAvailable   (boolean available);
   public void update         (ISizeLimitedCargo cargo);   
   
}
