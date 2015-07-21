package ru.majestic.thetown.view.counters.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.counters.IResourcesCounterPanel;

public class GameResourcesCounterPanel extends Rectangle implements IResourcesCounterPanel {

   private static final int HEIGHT = 60;
   
   private IGameManager gameManager;
   
   private FoodCounterView foodCountView;   
   private WoodCounterView woodCountView;
   private GoldCounterView goldCountView;
   
   public GameResourcesCounterPanel(IGameManager gameManager) {
      super(0, 0, TheTownCamera.CAMERA_WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      setAlpha(0.0f);
      
      this.gameManager = gameManager;
      
      foodCountView = new FoodCounterView(10, 4);
      woodCountView = new WoodCounterView(180, 4);
      goldCountView = new GoldCounterView(350, 4);      
      
      foodCountView.attachToParent(this);
      woodCountView.attachToParent(this);
      goldCountView.attachToParent(this);      
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
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
   }

}
