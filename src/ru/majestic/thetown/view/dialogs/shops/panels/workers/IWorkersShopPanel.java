package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public interface IWorkersShopPanel extends IClickableView {

   public void show     ();
   public void hide     ();
   public void update   ();
   public void setWorkerShopPanelActionListener(WorkerShopPanelActionListener workerShopPanelActionListener);
}
