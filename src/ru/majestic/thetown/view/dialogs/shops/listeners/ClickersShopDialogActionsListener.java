package ru.majestic.thetown.view.dialogs.shops.listeners;

import ru.majestic.thetown.game.cargo.ISizeLimitedCargo;
import ru.majestic.thetown.game.clickers.IClicker;

public interface ClickersShopDialogActionsListener {

   public void onUpgradeClickerButtonClicked (IClicker clicker);
   public void onUpgradeCargoButtonClicker   (ISizeLimitedCargo cargo);
   
}
