package ru.majestic.thetown.view.dialogs.shops.panels.clickers;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;

public interface IClickersShopPanel extends IClickableView {

   public void setClickersShopPanelActionsListener (ClickersShopPanelActionsListener clickersShopPanelActionsListener);
   public void update                              (ICargoManager cargoManager);
   
}
