package ru.majestic.thetown.activity;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.andengine.TheTownEngineOptions;
import ru.majestic.thetown.andengine.TheTownScene;
import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.game.clickers.impl.FoodClicker;
import ru.majestic.thetown.game.clickers.impl.WoodClicker;
import ru.majestic.thetown.game.impl.GameManager;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorkersProductionHandler;
import ru.majestic.thetown.game.workers.impl.WorkersProductionHandler;
import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.IClickerView;
import ru.majestic.thetown.view.clickers.impl.FoodClickerView;
import ru.majestic.thetown.view.clickers.impl.WoodClickerView;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.ICountWithMaxValueView;
import ru.majestic.thetown.view.counters.impl.FoodCounterView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.HomeCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterView;
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
                                                              OnWokersProductionCompleteListener {

	private Camera 	camera;
	
	private Scene          scene;
	private IGameManager   gameManager;
	
	private IClickerView foodClicker;
	private IClickerView woodClicker;
	
	private ICountView foodCountView;
	private ICountView goldCountView;
	private ICountView woodCountView; 
	private ICountWithMaxValueView homeCountView;
	
	private ITownView townView;
	
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
      
      foodClicker = new FoodClickerView();
      woodClicker = new WoodClickerView();
      
      foodCountView = new FoodCounterView();
      goldCountView = new GoldCounterView();
      woodCountView = new WoodCounterView();
      homeCountView = new HomeCounterView();
      
      townView      = new SimpleTownView(gameManager.getTown());
      
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
      
		pOnCreateSceneCallback.onCreateSceneFinished(scene);
	}

	@Override
	public void onPopulateScene(Scene scene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		
	   foodClicker.attachToParent(scene);
	   woodClicker.attachToParent(scene);	  
	   
	   foodCountView.attachToParent(scene);
	   goldCountView.attachToParent(scene);
	   woodCountView.attachToParent(scene);	   
	   homeCountView.attachToParent(scene);
	   
	   townView.attachToParent(scene);
	   
	   shopsMenu.attachToParent(scene);
	   
	   shopsDialogManager.attachToScene(scene);
	   
	   foodClicker.registerTouchArea(scene);
	   woodClicker.registerTouchArea(scene);
	   
	   shopsMenu.registerTouchArea(scene);
	   
	   updateCountViewers();
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	@Override
	public void onResumeGame() {
	   super.onResumeGame();
	   
	   if(workersProductionHandler == null) {
	      workersProductionHandler = new WorkersProductionHandler(gameManager.getWorkersManager());
	      workersProductionHandler.setOnWokersProductionCompleteListener(this);
	   }
      workersProductionHandler.start();
	}

   @Override
   public void onClickerClicked(IClickerView clicker) {
      if(clicker == foodClicker) {         
         gameManager.addFood(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD).getResourcesPerClick());
         
         foodCountView.changeCount(gameManager.getFoodCount());
      }
      
      if(clicker == woodClicker) {
         gameManager.addWood(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD).getResourcesPerClick());
         
         woodCountView.changeCount(gameManager.getWoodCount());
      }            
   }
   
   @Override
   public void onStop() {
      super.onStop();
      gameManager.save(this);
      workersProductionHandler.stop();
   }
   
   private void updateCountViewers() {
      foodCountView.changeCount(gameManager.getFoodCount());
      goldCountView.changeCount(gameManager.getGoldCount());
      woodCountView.changeCount(gameManager.getWoodCount());
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
      if(gameManager.getWoodCount() >= building.getWoodCost()) {
         gameManager.removeWood(building.getWoodCost());
         gameManager.getTown().addExp(building.getExp());
         
         building.buy();
         
         townView.update();
         updateCountViewers();         
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
         if(gameManager.getWoodCount() >= clicker.getUpgradePrice()) {
            gameManager.removeWood(clicker.getUpgradePrice());
            clicker.upgrade();                        
         }
      }
      
      if(clicker instanceof WoodClicker) {
         if(gameManager.getFoodCount() >= clicker.getUpgradePrice()) {
            gameManager.removeFood(clicker.getUpgradePrice());
            clicker.upgrade();                        
         }
      }
      
      updateCountViewers();
      shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS).update();
   }

   @Override
   public void onBuyWorkerAction(IWorker worker) {
      if(gameManager.getFoodCount() >= worker.getFoodCost() && (gameManager.getBuildingsManager().getTotalHomePlacesCount() - gameManager.getWorkersManager().getTotalHomeForWorkers()) >= worker.getHomePlaces()) {
         gameManager.removeFood(worker.getFoodCost());
         gameManager.getTown().addExp(worker.getExp());
         
         worker.buy();
         
         townView.update();
         updateCountViewers();
         
         homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
         homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
         
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_WORKERS).update();
      }
   }

   @Override
   public void onWorkersProductionComplete(int addFood, int addWood) {
      gameManager.addFood(addFood);
      gameManager.addWood(addWood);
      
      updateCountViewers();
   }
}
