package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.ICountWithMaxValueView;
import ru.majestic.thetown.view.counters.ICountWithPsRView;
import ru.majestic.thetown.view.counters.impl.DefenceCounterView;
import ru.majestic.thetown.view.counters.impl.FoodCounterWithRpSView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.HomeCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterWithRpSView;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.AResourcesShopPanelSkeleton;

public class ResourcesShopPanel extends AResourcesShopPanelSkeleton {

   private final IGameManager             gameManager;
   
   private final ICountWithPsRView        foodCountView;
   private final ICountWithPsRView        woodCountView;
   private final ICountView               goldCountView;    
   private final ICountWithMaxValueView   homeCountView;
   private final ICountView               defenceCountView;
   
   public ResourcesShopPanel(IShopDialog shopDialog, IGameManager gameManager) {
      super(shopDialog);
      
      this.gameManager = gameManager;
      
      foodCountView           = new FoodCounterWithRpSView(10, 2);
      woodCountView           = new WoodCounterWithRpSView(180, 2);
      goldCountView           = new GoldCounterView(350, 2);      
      homeCountView           = new HomeCounterView(10, 40);
      defenceCountView        = new DefenceCounterView(180, 40);
      
      foodCountView.attachToParent(this);
      woodCountView.attachToParent(this);
      goldCountView.attachToParent(this);           
      homeCountView.attachToParent(this);
      defenceCountView.attachToParent(this);
   }
   
   @Override
   public void update() {
      foodCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount());
      woodCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).getCurrentCount());
      goldCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_GOLD).getCurrentCount());      
      
      foodCountView.updateResourcesPerSecondValue(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.FOOD));
      woodCountView.updateResourcesPerSecondValue(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.WOOD));
      
      homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
      homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
      defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
   }

}
