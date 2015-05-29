package ru.majestic.thetown.view.dialogs.clickers;

import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopDialogActionsListener;

public interface IClickersShopDialog extends IDialog {

   public void setClickersShopDialogActionsListener(ClickersShopDialogActionsListener clickersShopDialogActionsListener);
   
   public void onFoodClickerLvlChanged(int newLvl);
   public void onWoodClickerLvlChanged(int newLvl);   
   
}
