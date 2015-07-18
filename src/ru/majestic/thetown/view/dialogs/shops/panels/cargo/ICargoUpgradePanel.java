package ru.majestic.thetown.view.dialogs.shops.panels.cargo;

import ru.majestic.thetown.view.IClickableView;

public interface ICargoUpgradePanel extends IClickableView {

   public interface OnCargoUpgradeButtonClickListener {
      
      public void onCargoUpgradeButtonClick();
      
   }
   
   public void addOnCargoUpgradeButtonClickListener      (OnCargoUpgradeButtonClickListener onCargoUpgradeButtonClickListener);
   public void removeOnCargoUpgradeButtonClickListener   (OnCargoUpgradeButtonClickListener onCargoUpgradeButtonClickListener);
   
   public void setAvailable   (boolean available);
   public void updateView     (long nextCargoSize, long nextCargoSizePrice);   
   
}
