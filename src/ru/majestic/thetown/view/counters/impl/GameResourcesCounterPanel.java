package ru.majestic.thetown.view.counters.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.ICountWithPsRView;
import ru.majestic.thetown.view.counters.IResourcesCounterPanel;

public class GameResourcesCounterPanel extends Rectangle implements IResourcesCounterPanel {

   private static final int HEIGHT = 60;
   
   private IGameManager gameManager;
   
   private ICountWithPsRView foodCountView;   
   private ICountWithPsRView woodCountView;
   private ICountView goldCountView;
   
   public GameResourcesCounterPanel(IGameManager gameManager) {
      super(0, 0, TheTownCamera.CAMERA_WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      setAlpha(0.0f);
      
      this.gameManager = gameManager;
      
      foodCountView = new FoodCounterWithRpSView();
      goldCountView = new GoldCounterView();
      woodCountView = new WoodCounterWithRpSView();
      
      foodCountView.attachToParent(this);
      goldCountView.attachToParent(this);
      woodCountView.attachToParent(this);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void update() {
      foodCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount());
      goldCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_GOLD).getCurrentCount());
      woodCountView.changeCount(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).getCurrentCount());   
      
      foodCountView.updateResourcesPerSecondValue(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.FOOD));
      woodCountView.updateResourcesPerSecondValue(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.WOOD));
   }

}
