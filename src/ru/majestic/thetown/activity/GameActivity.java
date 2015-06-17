package ru.majestic.thetown.activity;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.andengine.TheTownEngineOptions;
import ru.majestic.thetown.andengine.TheTownScene;
import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.game.clickers.impl.FoodClicker;
import ru.majestic.thetown.game.clickers.impl.WoodClicker;
import ru.majestic.thetown.game.impl.GameManager;
import ru.majestic.thetown.game.listener.OnTimeToAttackListener;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.IWorkersProductionHandler;
import ru.majestic.thetown.game.workers.impl.WorkersProductionHandler;
import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;
import ru.majestic.thetown.notifications.TheTownNotificationManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.attack.IAttackView;
import ru.majestic.thetown.view.attack.impl.SimpleAttackView;
import ru.majestic.thetown.view.clickers.IClickerView;
import ru.majestic.thetown.view.clickers.impl.FoodClickerView;
import ru.majestic.thetown.view.clickers.impl.WoodClickerView;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.ICountWithMaxValueView;
import ru.majestic.thetown.view.counters.IResourcesCounterPanel;
import ru.majestic.thetown.view.counters.impl.DefenceCounterView;
import ru.majestic.thetown.view.counters.impl.GameResourcesCounterPanel;
import ru.majestic.thetown.view.counters.impl.HomeCounterView;
import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.shops.IShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.impl.BuildingsShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ClickersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.impl.WorkersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.BuildingsShopDialogActionListeners;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.OnShopsCloseButtonCLickedListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.WorkersShopDialogActionListener;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;
import ru.majestic.thetown.view.menu.IShopsMenu;
import ru.majestic.thetown.view.menu.impl.ShopsMenu;
import ru.majestic.thetown.view.menu.listeners.OnShopsMenuButtonClickedListener;
import ru.majestic.thetown.view.town.ITownView;
import ru.majestic.thetown.view.town.impl.SimpleTownView;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener,
                                                              OnShopsCloseButtonCLickedListener,
                                                              ClickersShopDialogActionsListener,
                                                              OnShopsMenuButtonClickedListener,
                                                              BuildingsShopDialogActionListeners, 
                                                              WorkersShopDialogActionListener,
                                                              OnWokersProductionCompleteListener,
                                                              OnTimeToAttackListener {

	private Camera 	camera;
	
	private Scene          scene;
	private IGameManager   gameManager;
	
	private IClickerView foodClicker;
	private IClickerView woodClicker;

	private IResourcesCounterPanel  resourcesCounterPanel;
	private ICountWithMaxValueView  homeCountView;
	private ICountView              defenceCountView;	
	private ITownView               townView;
	private IAttackView             attackView;
	
	private IShopsMenu shopsMenu;		
	private IShopsDialogsManager shopsDialogManager;
	
   private IWorkersProductionHandler workersProductionHandler;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
	   ResourceManager.getInstance().loadResources(this, getEngine());	   	   
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		scene = new TheTownScene();
		
		gameManager = new GameManager();
      gameManager.load(this);         
      gameManager.getAttackManager().setOnTimeToAttackListener(this);
      
      foodClicker = new FoodClickerView();
      woodClicker = new WoodClickerView();
      
      resourcesCounterPanel   = new GameResourcesCounterPanel(gameManager);
      homeCountView           = new HomeCounterView      (10, 90);
      defenceCountView        = new DefenceCounterView   (10, 130);      
      townView                = new SimpleTownView(gameManager.getTown());
      attackView              = new SimpleAttackView(TheTownCamera.CAMERA_WIDTH - 90, 100, gameManager.getAttackManager());
      
      shopsMenu = new ShopsMenu();        
      
      shopsDialogManager = new ShopsDialogsManager(gameManager, scene);
      
      foodClicker.setOnClickerClickedListener(this);
      woodClicker.setOnClickerClickedListener(this);  
      
      shopsMenu.setOnShopsMenuButtonClickedListener(this);
      
      shopsDialogManager.setOnShopsCloseButtonClickedListener(this);
                       
      ClickersShopDialog clickersShopDialog = (ClickersShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS);
      clickersShopDialog.setClickersShopDialogActionsListener(this);
      
      BuildingsShopDialog buildingsShopDialog = (BuildingsShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_BUILDINGS);
      buildingsShopDialog.setBuildingsShopDialogActionListeners(this);     
      
      WorkersShopDialog workersShopDialog = (WorkersShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_WORKERS);
      workersShopDialog.setWorkersShopDialogActionListener(this);
      
      homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
      homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());	
      
      defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
      
		pOnCreateSceneCallback.onCreateSceneFinished(scene);
	}

	@Override
	public void onPopulateScene(Scene scene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		
	   foodClicker.attachToParent(scene);
	   woodClicker.attachToParent(scene);	  
	   
	   resourcesCounterPanel.attachToParent(scene);
	   homeCountView.attachToParent(scene);
	   defenceCountView.attachToParent(scene);	   
	   townView.attachToParent(scene);
	   attackView.attachToParent(scene);
	   
	   shopsMenu.attachToParent(scene);
	   
	   shopsDialogManager.attachToScene(scene);
	   
	   foodClicker.registerTouchArea(scene);
	   woodClicker.registerTouchArea(scene);
	   
	   shopsMenu.registerTouchArea(scene);
	   
	   resourcesCounterPanel.update();
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	@Override
	public void onResumeGame() {
	   super.onResumeGame();
	   
	   if(workersProductionHandler == null) {
	      workersProductionHandler = new WorkersProductionHandler(gameManager.getWorkersManager());
	      workersProductionHandler.setOnWokersProductionCompleteListener(this);	      
	   }	   	   
	   
	   gameManager.getAttackManager().startAttackTimeObserve();
	   workersProductionHandler.load(this);
      workersProductionHandler.start();
	}

   @Override
   public void onClickerClicked(float x, float y, IClickerView clicker) {
      if(clicker == foodClicker) {         
         gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).add(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD).getResourcesPerClick());
         foodClicker.showAdder(x, y, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD).getResourcesPerClick());
      }
      
      if(clicker == woodClicker) {
         gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).add(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD).getResourcesPerClick());
         woodClicker.showAdder(x, y, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD).getResourcesPerClick());
      }            
      
      resourcesCounterPanel.update();
   }
   
   @Override
   public void onPause() {
      super.onPause();
      gameManager.save(this);
      gameManager.getAttackManager().stopAttackTimeObserve();
      workersProductionHandler.save(this);
      workersProductionHandler.stop();
   }

   @Override
   public void onNeedOpenShopDialog(int shopType) {
      
      if(shopsDialogManager.getShop(shopType).isVisible()) {
         shopsDialogManager.closeShop(shopType, scene);
         
         shopsMenu.clearAllSelection();
         
         foodClicker.registerTouchArea(scene);
         woodClicker.registerTouchArea(scene);
      } else {
         shopsDialogManager.openShop(shopType, scene);
         
         foodClicker.unregisterTouchArea(scene);
         woodClicker.unregisterTouchArea(scene);
      }
   }

   @Override
   public void onBuyBuildingAction(IBuilding building) {
      if(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).getCurrentCount() >= building.getWoodCost()) {
         gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).remove(building.getWoodCost());
         gameManager.getTown().addExp(building.getExp());
         
         building.buy();
         
         townView.update();
         resourcesCounterPanel.update();         
         homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
         
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_BUILDINGS).update();
      }
   }

   @Override
   public void onShopsCloseButtonClicked(IDialog dialog) {
      dialog.hide();
      dialog.unregisterTouchArea(scene);      
      
      shopsMenu.clearAllSelection();
      
      foodClicker.registerTouchArea(scene);
      woodClicker.registerTouchArea(scene);
   }
    
   @Override
   public void onBackPressed() {
      if(shopsDialogManager.hasOpenedShop()) {
         shopsDialogManager.closeShop(shopsDialogManager.getOpenedShopIndex(), scene);
         
         shopsMenu.clearAllSelection();
         
         foodClicker.registerTouchArea(scene);
         woodClicker.registerTouchArea(scene);
      } else {
         super.onBackPressed();
      }
   }

   @Override
   public void onUpgradeClickerButtonClicked(IClicker clicker) {
      if(clicker instanceof FoodClicker) {
         if(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).getCurrentCount() >= clicker.getUpgradePrice()) {
            gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).remove(clicker.getUpgradePrice());
            clicker.upgrade();                        
         }
      }
      
      if(clicker instanceof WoodClicker) {
         if(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount() >= clicker.getUpgradePrice()) {
            gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).remove(clicker.getUpgradePrice());
            clicker.upgrade();                        
         }
      }
      
      resourcesCounterPanel.update();
      shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS).update();
   }

   @Override
   public void onBuyWorkerAction(IWorker worker) {
      if(gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).getCurrentCount() >= worker.getFoodCost() && (gameManager.getBuildingsManager().getTotalHomePlacesCount() - gameManager.getWorkersManager().getTotalHomeForWorkers()) >= worker.getHomePlaces()) {
         gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).remove(worker.getFoodCost());
         gameManager.getTown().addExp(worker.getExp());
         
         worker.buy();
         
         townView.update();
         resourcesCounterPanel.update();
         
         homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
         homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
         
         defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
         
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_WORKERS).update();
      }
   }

   @Override
   public void onWorkersProductionComplete(int addFood, int addWood) {
      gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_FOOD).add(addFood);
      gameManager.getCargoManager().getCargo(ICargoManager.CARGO_TYPE_WOOD).add(addWood);
      
      resourcesCounterPanel.update();
      
      if(shopsDialogManager.hasOpenedShop())
         shopsDialogManager.getShop(shopsDialogManager.getOpenedShopIndex()).update();
   }

   @Override
   public void onTimeToAttack() {
      gameManager.getAttackManager().getAttack().execute();
      gameManager.getAttackManager().getAttack().update(gameManager.getTown());
      gameManager.save(this);
      
      TheTownNotificationManager.reset(this);
   }
}
