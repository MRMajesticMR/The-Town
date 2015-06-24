package ru.majestic.thetown.view.dialogs.shops.panels.workers.market;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.listeners.OnMarketItemBuyBtnClickedListener;

public interface IMarketItemPanel extends IClickableView {
   
   public void setOnMarketItemBuyBtnClickedListener(OnMarketItemBuyBtnClickedListener onMarketItemBuyBtnClickedListener);

   public void update();
}
