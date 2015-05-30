package ru.majestic.thetown.view.dialogs.shops;

import ru.majestic.thetown.view.dialogs.IDialog;

public interface IShopDialog extends IDialog {

   public void onResourceCountChanged(int food, int gold, int wood);
   
}
