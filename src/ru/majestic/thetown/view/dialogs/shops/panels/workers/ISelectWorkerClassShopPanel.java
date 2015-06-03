package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopSelectedListener;

public interface ISelectWorkerClassShopPanel extends IClickableView {

   public void setOnWorkerClassShopSelectedListener(OnWorkerClassShopSelectedListener onWorkerClassShopSelectedListener);
   
}
