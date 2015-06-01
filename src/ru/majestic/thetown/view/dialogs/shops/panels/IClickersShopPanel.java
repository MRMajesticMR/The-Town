package ru.majestic.thetown.view.dialogs.shops.panels;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;

public interface IClickersShopPanel extends IClickableView {

   public void setClickersShopPanelActionsListener(ClickersShopPanelActionsListener clickersShopPanelActionsListener);
   
   public void showCurrentClickerLvl(int newLvl);
   public void showCurrentClickerResourcesPerClick(int resourcesPerClick);
   public void showUpgradePrice(int upgradePrice);
   
}
