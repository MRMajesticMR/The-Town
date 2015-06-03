package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopButtonClickedListener;

public interface ISelectWorkerClassShopPanelButton extends IClickableView {

   public void setOnWorkerClassShopButtonClickedListener (OnWorkerClassShopButtonClickedListener onWorkerClassShopButtonClickedListener);
   public void setActive                                 (boolean active);
   
}
