package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public interface IWorkerShopPanel extends IClickableView {
   
   public void setWorkerShopPanelActionListener(WorkerShopPanelActionListener workerShopPanelActionListener);
   public void update ();
   
}
