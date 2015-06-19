package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import ru.majestic.thetown.game.IBuildingsManager;
import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public interface IWorkerShopPanel extends IClickableView {
   
   public void setWorkerShopPanelActionListener    (WorkerShopPanelActionListener workerShopPanelActionListener);
   public void update                              (ICargoManager cargoManager, IBuildingsManager buildingsManager, IWorkersManager workersManager);
   
}
