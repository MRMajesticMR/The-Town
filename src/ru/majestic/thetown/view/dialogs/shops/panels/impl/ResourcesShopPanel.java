package ru.majestic.thetown.view.dialogs.shops.panels.impl;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.view.counters.impl.DefenceCounterView;
import ru.majestic.thetown.view.counters.impl.FoodCounterView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.HomeCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterView;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.AResourcesShopPanelSkeleton;

public class ResourcesShopPanel extends AResourcesShopPanelSkeleton {

   private final IGameManager             gameManager;
   
   private final FoodCounterView          foodCountView;
   private final WoodCounterView          woodCountView;
   private final GoldCounterView          goldCountView;    
   private final HomeCounterView          homeCountView;
   private final DefenceCounterView       defenceCountView;
   
   public ResourcesShopPanel(IShopDialog shopDialog, IGameManager gameManager) {
      super(shopDialog);
      
      this.gameManager = gameManager;
      
      foodCountView           = new FoodCounterView(10, 4);
      woodCountView           = new WoodCounterView(180, 4);
      goldCountView           = new GoldCounterView(350, 4);      
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
      foodCountView.changeCount(gameManager.getCargoManager().getFoodCargo().getCurrentCount());
      woodCountView.changeCount(gameManager.getCargoManager().getWoodCargo().getCurrentCount());
      goldCountView.changeCount(gameManager.getCargoManager().getGoldCargo().getCurrentCount());      
      
      foodCountView.onMaxValueChanged(gameManager.getCargoManager().getFoodCargo().getSize());
      woodCountView.onMaxValueChanged(gameManager.getCargoManager().getWoodCargo().getSize());
      
      foodCountView.updateResourcesPerSecondValue(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.FOOD));
      woodCountView.updateResourcesPerSecondValue(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.WOOD));      
      
      homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
      homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
      defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
   }

}
