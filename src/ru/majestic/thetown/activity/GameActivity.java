package ru.majestic.thetown.activity;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.andengine.TheTownEngineOptions;
import ru.majestic.thetown.andengine.TheTownScene;
import ru.majestic.thetown.game.GameManagerHelper;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.game.impl.GameManager;
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
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.BuildingsShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ClickersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.GoldShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.WorkersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.BuildingsShopDialogActionListeners;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;
import ru.majestic.thetown.view.menu.IShopsMenu;
import ru.majestic.thetown.view.menu.impl.ShopsMenu;
import ru.majestic.thetown.view.menu.listeners.OnShopsMenuButtonClickedListener;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener,
                                                              OnDialogClosedListener,
                                                              ClickersShopDialogActionsListener,
                                                              OnShopsMenuButtonClickedListener,
                                                              BuildingsShopDialogActionListeners {

	private Camera 	camera;
	
	private Scene          scene;
	private IGameManager   gameManager;
	
	private IClickerView foodClicker;
	private IClickerView woodClicker;
	
	private ICountView foodCountView;
	private ICountView goldCountView;
	private ICountView woodCountView;  
	
	private ICountWithMaxValueView homeCountView;
	
	private IShopsMenu shopsMenu;		
   
   private ClickersShopDialog    clickersShopDialog;
   private WorkersShopDialog     workersShopDialog;
   private BuildingsShopDialog   buildingsShopDialog;
   private GoldShopDialog        goldShopDialog;
   
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
	   ResourceManager.getInstance().loadResources(this, getEngine());
	   
	   gameManager = new GameManager();
	   gameManager.load(this);	  	   
	   
	   foodClicker = new FoodClickerView();
	   woodClicker = new WoodClickerView();
	   
	   foodCountView = new FoodCounterView();
	   goldCountView = new GoldCounterView();
	   woodCountView = new WoodCounterView();
	   homeCountView = new HomeCounterView();
	   
	   shopsMenu = new ShopsMenu();	   	   
	   
	   clickersShopDialog           = new ClickersShopDialog();
	   workersShopDialog            = new WorkersShopDialog();
	   buildingsShopDialog          = new BuildingsShopDialog(gameManager.getBuildingsManager());
	   goldShopDialog               = new GoldShopDialog();
	   
	   foodClicker.setOnClickerClickedListener(this);
	   woodClicker.setOnClickerClickedListener(this);	
	   
	   shopsMenu.setOnShopsMenuButtonClickedListener(this);
	   
	   clickersShopDialog.setOnDialogClosedListener(this);
	   workersShopDialog.setOnDialogClosedListener(this);
	   buildingsShopDialog.setOnDialogClosedListener(this);
	   goldShopDialog.setOnDialogClosedListener(this);	   
	     
	   clickersShopDialog.setClickersShopDialogActionsListener(this);	   
	   
	   clickersShopDialog.onFoodClickerLvlChanged(gameManager.getFoodClickerLvl());
	   clickersShopDialog.onWoodClickerLvlChanged(gameManager.getWoodClickerLvl());
	   
	   buildingsShopDialog.setBuildingsShopDialogActionListeners(this);
	   buildingsShopDialog.update();
	   
	   homeCountView.changeCount(gameManager.getHomeCount());
	   homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		scene = new TheTownScene();
		
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
	   
	   shopsMenu.attachToParent(scene);
	   
	   clickersShopDialog.attachToParent(scene);
	   workersShopDialog.attachToParent(scene);
	   buildingsShopDialog.attachToParent(scene);
	   goldShopDialog.attachToParent(scene);
	   
	   foodClicker.registerTouchArea(scene);
	   woodClicker.registerTouchArea(scene);
	   
	   shopsMenu.registerTouchArea(scene);
	   
	   updateCountViewers();
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

   @Override
   public void onClickerClicked(IClickerView clicker) {
      if(clicker == foodClicker) {         
         gameManager.addFood(GameManagerHelper.calculateResourcesPerClickFromLvl(gameManager.getFoodClickerLvl()));
         
         foodCountView.changeCount(gameManager.getFoodCount());
      }
      
      if(clicker == woodClicker) {
         gameManager.addWood(GameManagerHelper.calculateResourcesPerClickFromLvl(gameManager.getWoodClickerLvl()));
         
         woodCountView.changeCount(gameManager.getWoodCount());
      }            
   }
   
   @Override
   public void onStop() {
      super.onStop();
      gameManager.save(this);
   }
   
   private void updateCountViewers() {
      foodCountView.changeCount(gameManager.getFoodCount());
      goldCountView.changeCount(gameManager.getGoldCount());
      woodCountView.changeCount(gameManager.getWoodCount());
      
      clickersShopDialog.onResourceCountChanged(gameManager.getFoodCount(), gameManager.getGoldCount(), gameManager.getWoodCount());
   }

   @Override
   public void onDialogClosed(IDialog dialog) {
      closeDialog(dialog);      
      shopsMenu.clearAllSelection();
      
      foodClicker.registerTouchArea(scene);
      woodClicker.registerTouchArea(scene);      
   }

   @Override
   public void onUpgradeFoodClickerClicked() {
      if(gameManager.getWoodCount() >= GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getFoodClickerLvl())) {
         gameManager.removeWood(GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getFoodClickerLvl()));
         gameManager.upFoodClickerLvl();
         
         updateCountViewers();
         clickersShopDialog.onFoodClickerLvlChanged(gameManager.getFoodClickerLvl());         
      }
   }

   @Override
   public void onUpgradeWoodClickerClicked() {
      if(gameManager.getFoodCount() >= GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getWoodClickerLvl())) {
         gameManager.removeFood(GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getWoodClickerLvl()));
         gameManager.upWoodClickerLvl();
         
         updateCountViewers();
         clickersShopDialog.onWoodClickerLvlChanged(gameManager.getWoodClickerLvl());
      }
   }

   @Override
   public void onNeedOpenShopDialog(ShopType shopType) {
      
      closeDialog(clickersShopDialog);
      closeDialog(workersShopDialog);
      closeDialog(buildingsShopDialog);
      closeDialog(goldShopDialog);
      
      IShopDialog selectedShop = null;
      
      switch(shopType) {
      case CLICKERS:
         selectedShop = clickersShopDialog;
         break;
      case WORKERS:
         selectedShop = workersShopDialog;
         break;
      case BUILDINGS:
         selectedShop = buildingsShopDialog;
         break;
      case GOLD:
         selectedShop = goldShopDialog;
         break;
      }                 
      
      foodClicker.unregisterTouchArea(scene);
      woodClicker.unregisterTouchArea(scene);
      
      selectedShop.registerTouchArea(scene);
      selectedShop.onResourceCountChanged(gameManager.getFoodCount(), gameManager.getGoldCount(), gameManager.getWoodCount());
      selectedShop.show();
   }
   
   private void closeDialog(IDialog dialog) {
      dialog.unregisterTouchArea(scene);
      dialog.hide();
   }

   @Override
   public void onBuyBuildingAction(IBuilding building) {
      if(gameManager.getWoodCount() >= building.getWoodCost()) {
         gameManager.removeWood(building.getWoodCost());
         building.buy();
         
         updateCountViewers();
         buildingsShopDialog.onResourceCountChanged(gameManager.getFoodCount(), gameManager.getGoldCount(), gameManager.getWoodCount());
         homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
         buildingsShopDialog.update();
      }
   }
    
}
