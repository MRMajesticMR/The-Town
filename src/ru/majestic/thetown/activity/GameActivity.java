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
import ru.majestic.thetown.view.dialogs.shops.IShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.impl.BuildingsShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ClickersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.listeners.BuildingsShopDialogActionListeners;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.OnShopsCloseButtonCLickedListener;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;
import ru.majestic.thetown.view.menu.IShopsMenu;
import ru.majestic.thetown.view.menu.impl.ShopsMenu;
import ru.majestic.thetown.view.menu.listeners.OnShopsMenuButtonClickedListener;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener,
                                                              OnShopsCloseButtonCLickedListener,
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
	private IShopsDialogsManager shopsDialogManager;
   
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
	   
	   shopsDialogManager = new ShopsDialogsManager(gameManager);
	   
	   foodClicker.setOnClickerClickedListener(this);
	   woodClicker.setOnClickerClickedListener(this);	
	   
	   shopsMenu.setOnShopsMenuButtonClickedListener(this);
	   
	   shopsDialogManager.setOnShopsCloseButtonClickedListener(this);
	     	   	   	  
	   ClickersShopDialog clickersShopDialog = (ClickersShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS);
	   clickersShopDialog.setClickersShopDialogActionsListener(this);
	   
	   BuildingsShopDialog buildingsShopDialog = (BuildingsShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_BUILDINGS);
	   buildingsShopDialog.setBuildingsShopDialogActionListeners(this);	   
	   
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
	   
	   shopsDialogManager.attachToScene(scene);
	   
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
   }

   @Override
   public void onUpgradeFoodClickerClicked() {
      if(gameManager.getWoodCount() >= GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getFoodClickerLvl())) {
         gameManager.removeWood(GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getFoodClickerLvl()));
         gameManager.upFoodClickerLvl();
         
         updateCountViewers();
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS).update();         
      }
   }

   @Override
   public void onUpgradeWoodClickerClicked() {
      if(gameManager.getFoodCount() >= GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getWoodClickerLvl())) {
         gameManager.removeFood(GameManagerHelper.calculateUpgradeCostFromLvl(gameManager.getWoodClickerLvl()));
         gameManager.upWoodClickerLvl();
         
         updateCountViewers();
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS).update();
      }
   }

   @Override
   public void onNeedOpenShopDialog(int shopType) {
      
      shopsDialogManager.openShop(shopType, scene);
      
      foodClicker.unregisterTouchArea(scene);
      woodClicker.unregisterTouchArea(scene);
   }

   @Override
   public void onBuyBuildingAction(IBuilding building) {
      if(gameManager.getWoodCount() >= building.getWoodCost()) {
         gameManager.removeWood(building.getWoodCost());
         building.buy();
         
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
}
