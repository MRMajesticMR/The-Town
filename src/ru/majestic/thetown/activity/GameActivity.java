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
import ru.majestic.thetown.game.impl.GameManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.IClickerView;
import ru.majestic.thetown.view.clickers.impl.FoodClickerView;
import ru.majestic.thetown.view.clickers.impl.WoodClickerView;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.impl.FoodCounterView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterView;
import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;
import ru.majestic.thetown.view.dialogs.shops.impl.BuildingsShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ClickersShopDialog;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;
import ru.majestic.thetown.view.menu.IBottomMenu;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;
import ru.majestic.thetown.view.menu.buttons.impl.TextMenuButton;
import ru.majestic.thetown.view.menu.buttons.listeners.OnMenuButtonClickedListener;
import ru.majestic.thetown.view.menu.impl.BottomMenu;
import android.util.Log;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener,
                                                              OnMenuButtonClickedListener,
                                                              OnDialogClosedListener,
                                                              ClickersShopDialogActionsListener {

	private Camera 	camera;
	
	private Scene          scene;
	private IGameManager   gameManager;
	
	private IClickerView foodClicker;
	private IClickerView woodClicker;
	
	private ICountView foodCountView;
	private ICountView goldCountView;
	private ICountView woodCountView;   
	
	private IBottomMenu bottomMenu;
	
	private IMenuButton buyClickersUpgradeMenuBtn;
   private IMenuButton buyPeopleMenuBtn;
   private IMenuButton buyBuildingsMenuBtn;
   private IMenuButton buyGoldMenuBtn;
   
   private ClickersShopDialog   clickersShopDialog;
   private BuildingsShopDialog  buildingsShopDialog;
   
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
	   gameManager = new GameManager();
	   gameManager.load(this);
	   
	   ResourceManager.getInstance().loadResources(this, getEngine());
	   
	   foodClicker = new FoodClickerView();
	   woodClicker = new WoodClickerView();
	   
	   foodCountView = new FoodCounterView();
	   goldCountView = new GoldCounterView();
	   woodCountView = new WoodCounterView();
	   
	   bottomMenu = new BottomMenu();
	   
	   buyClickersUpgradeMenuBtn    = new TextMenuButton("Clickers");	   	   
	   buyPeopleMenuBtn             = new TextMenuButton("Workers");
	   buyBuildingsMenuBtn          = new TextMenuButton("Buildings");
	   buyGoldMenuBtn               = new TextMenuButton("Gold");
	   
	   clickersShopDialog           = new ClickersShopDialog();
	   buildingsShopDialog          = new BuildingsShopDialog();
	   
	   foodClicker.setOnClickerClickedListener(this);
	   woodClicker.setOnClickerClickedListener(this);	   	   
	   
	   buyClickersUpgradeMenuBtn.setOnMenuButtonClickedListener(this);
	   buyPeopleMenuBtn.setOnMenuButtonClickedListener(this);
	   buyBuildingsMenuBtn.setOnMenuButtonClickedListener(this);
	   buyGoldMenuBtn.setOnMenuButtonClickedListener(this);
	   
	   clickersShopDialog.setOnDialogClosedListener(this);
	   clickersShopDialog.setClickersShopDialogActionsListener(this);
	   
	   buildingsShopDialog.setOnDialogClosedListener(this);
	   
	   clickersShopDialog.onFoodClickerLvlChanged(gameManager.getFoodClickerLvl());
	   clickersShopDialog.onWoodClickerLvlChanged(gameManager.getWoodClickerLvl());      
	   
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
	   
	   bottomMenu.addIMenuButton(buyClickersUpgradeMenuBtn);
	   bottomMenu.addIMenuButton(buyPeopleMenuBtn);	   
	   bottomMenu.addIMenuButton(buyBuildingsMenuBtn);
	   bottomMenu.addIMenuButton(buyGoldMenuBtn);
	   
	   bottomMenu.attachToParent(scene);
	   
	   clickersShopDialog.attachToParent(scene);
	   buildingsShopDialog.attachToParent(scene);
	   
	   foodClicker.registerTouchArea(scene);
	   woodClicker.registerTouchArea(scene);
	   
	   buyClickersUpgradeMenuBtn.registerTouchArea(scene);
	   buyPeopleMenuBtn.registerTouchArea(scene);
	   buyBuildingsMenuBtn.registerTouchArea(scene);
	   buyGoldMenuBtn.registerTouchArea(scene);
	   
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
   public void onDestroy() {
      super.onDestroy();
      gameManager.save(this);
   }
   
   private void updateCountViewers() {
      foodCountView.changeCount(gameManager.getFoodCount());
      goldCountView.changeCount(gameManager.getGoldCount());
      woodCountView.changeCount(gameManager.getWoodCount());
      
      clickersShopDialog.onResourceCountChanged(gameManager.getFoodCount(), gameManager.getGoldCount(), gameManager.getWoodCount());
   }

   @Override
   public void onMenuButtonClicked(IMenuButton menuButton) {
      if(menuButton == buyClickersUpgradeMenuBtn) {
         
         foodClicker.unregisterTouchArea(scene);
         woodClicker.unregisterTouchArea(scene);
         
         buyClickersUpgradeMenuBtn.unregisterTouchArea(scene);          
         buyPeopleMenuBtn.unregisterTouchArea(scene);
         buyBuildingsMenuBtn.unregisterTouchArea(scene);
         buyGoldMenuBtn.unregisterTouchArea(scene);
         
         clickersShopDialog.registerTouchArea(scene);
         clickersShopDialog.onResourceCountChanged(gameManager.getFoodCount(), gameManager.getGoldCount(), gameManager.getWoodCount());
         clickersShopDialog.show();         
         
         return;
      }
      
      if(menuButton == buyPeopleMenuBtn) {
         Log.i("MENU_BUTTONS", "Workers");
         return;
      }
      
      if(menuButton == buyBuildingsMenuBtn) {
         foodClicker.unregisterTouchArea(scene);
         woodClicker.unregisterTouchArea(scene);
         
         buyClickersUpgradeMenuBtn.unregisterTouchArea(scene);          
         buyPeopleMenuBtn.unregisterTouchArea(scene);
         buyBuildingsMenuBtn.unregisterTouchArea(scene);
         buyGoldMenuBtn.unregisterTouchArea(scene);
         
         buildingsShopDialog.registerTouchArea(scene);
         buildingsShopDialog.onResourceCountChanged(gameManager.getFoodCount(), gameManager.getGoldCount(), gameManager.getWoodCount());
         buildingsShopDialog.show();         
         return;
      }
      
      if(menuButton == buyGoldMenuBtn) {
         Log.i("MENU_BUTTONS", "Gold");
         return;
      }
      
   }

   @Override
   public void onDialogClosed(IDialog dialog) {
      dialog.unregisterTouchArea(scene);
      dialog.hide();      
      
      foodClicker.registerTouchArea(scene);
      woodClicker.registerTouchArea(scene);
      
      buyClickersUpgradeMenuBtn.registerTouchArea(scene);          
      buyPeopleMenuBtn.registerTouchArea(scene);
      buyBuildingsMenuBtn.registerTouchArea(scene);
      buyGoldMenuBtn.registerTouchArea(scene);      
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
    
}
