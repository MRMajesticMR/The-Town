package ru.majestic.thetown.view.dialogs.shops.panels;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.listeners.OnBuyGoldListener;

public interface IBuyGoldShopPanel extends IClickableView {

   public void    setOnBuyGoldListener(OnBuyGoldListener onBuyGoldListener);   
   
}
