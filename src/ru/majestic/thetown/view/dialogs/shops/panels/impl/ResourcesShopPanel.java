package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.ICountWithMaxValueView;
import ru.majestic.thetown.view.counters.impl.DefenceCounterView;
import ru.majestic.thetown.view.counters.impl.FoodCounterView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.HomeCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterView;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.AResourcesShopPanelSkeleton;

public class ResourcesShopPanel extends AResourcesShopPanelSkeleton {

   private final IGameManager             gameManager;
   
   private final ICountView               foodCountView;
   private final ICountView               goldCountView;
   private final ICountView               woodCountView; 
   private final ICountWithMaxValueView   homeCountView;
   private final ICountView               defenceCountView;
   
   public ResourcesShopPanel(IShopDialog shopDialog, IGameManager gameManager) {
      super(shopDialog);
      
      this.gameManager = gameManager;
      
      foodCountView           = new FoodCounterView(10, 4);
      goldCountView           = new GoldCounterView(350, 4);
      woodCountView           = new WoodCounterView(180, 4);
      homeCountView           = new HomeCounterView(80, 38);
      defenceCountView        = new DefenceCounterView(270, 38);
      
      foodCountView.attachToParent(this);
      goldCountView.attachToParent(this);
      woodCountView.attachToParent(this);      
      homeCountView.attachToParent(this);
      defenceCountView.attachToParent(this);
   }
   
   @Override
   public void update() {
      foodCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount());
      goldCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_GOLD).getCurrentCount());
      woodCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).getCurrentCount());
      
      homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
      homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
      defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
   }

}
