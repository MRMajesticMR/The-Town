package ru.majestic.thetown.activity;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.util.Log;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.andengine.TheTownEngineOptions;
import ru.majestic.thetown.andengine.TheTownScene;
import ru.majestic.thetown.game.GameManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.IClicker;
import ru.majestic.thetown.view.clickers.impl.FoodClicker;
import ru.majestic.thetown.view.clickers.impl.WoodClicker;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.impl.FoodCounterView;
import ru.majestic.thetown.view.counters.impl.GoldCounterView;
import ru.majestic.thetown.view.counters.impl.WoodCounterView;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;
import ru.majestic.thetown.view.menu.IBottomMenu;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;
import ru.majestic.thetown.view.menu.buttons.impl.TextMenuButton;
import ru.majestic.thetown.view.menu.buttons.listeners.OnMenuButtonClickedListener;
import ru.majestic.thetown.view.menu.impl.BottomMenu;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener,
                                                              OnMenuButtonClickedListener {

	private Camera 	camera;
	
	private IClicker foodClicker;
	private IClicker woodClicker;
	
	private ICountView foodCountView;
	private ICountView goldCountView;
	private ICountView woodCountView;   
	
	private IBottomMenu bottomMenu;
	
	private IMenuButton buyClickersUpgradeMenuBtn;
   private IMenuButton buyPeopleMenuBtn;
   private IMenuButton buyBuildingsMenuBtn;
   private IMenuButton buyGoldMenuBtn;
   
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
		GameManager.getInstance().load(this);
	   ResourceManager.getInstance().loadResources(this, getEngine());
	   
	   foodClicker = new FoodClicker();
	   woodClicker = new WoodClicker();
	   
	   foodCountView = new FoodCounterView();
	   goldCountView = new GoldCounterView();
	   woodCountView = new WoodCounterView();
	   
	   bottomMenu = new BottomMenu();
	   
	   buyClickersUpgradeMenuBtn    = new TextMenuButton("Clickers");	   	   
	   buyPeopleMenuBtn          = new TextMenuButton("Workers");
	   buyBuildingsMenuBtn       = new TextMenuButton("Buildings");
	   buyGoldMenuBtn            = new TextMenuButton("Gold");
	   
	   foodClicker.setOnClickerClickedListener(this);
	   woodClicker.setOnClickerClickedListener(this);	   	   
	   
	   buyClickersUpgradeMenuBtn.setOnMenuButtonClickedListener(this);
	   buyPeopleMenuBtn.setOnMenuButtonClickedListener(this);
	   buyBuildingsMenuBtn.setOnMenuButtonClickedListener(this);
	   buyGoldMenuBtn.setOnMenuButtonClickedListener(this);
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		
		pOnCreateSceneCallback.onCreateSceneFinished(new TheTownScene());
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
   public void onClickerClicked(IClicker clicker) {
      if(clicker == foodClicker) {
         GameManager.getInstance().addFood(1);
         foodCountView.changeCount(GameManager.getInstance().getFoodCount());
      }
      
      if(clicker == woodClicker) {
         GameManager.getInstance().addWood(1);
         woodCountView.changeCount(GameManager.getInstance().getWoodCount());
      }            
   }
   
   @Override
   public void onDestroy() {
      super.onDestroy();
      GameManager.getInstance().save(this);
   }
   
   private void updateCountViewers() {
      foodCountView.changeCount(GameManager.getInstance().getFoodCount());
      goldCountView.changeCount(GameManager.getInstance().getGoldCount());
      woodCountView.changeCount(GameManager.getInstance().getWoodCount());
   }

   @Override
   public void onMenuButtonClicked(IMenuButton menuButton) {
      if(menuButton == buyClickersUpgradeMenuBtn) {
         Log.i("MENU_BUTTONS", "Clickers");
         return;
      }
      
      if(menuButton == buyPeopleMenuBtn) {
         Log.i("MENU_BUTTONS", "Workers");
         return;
      }
      
      if(menuButton == buyBuildingsMenuBtn) {
         Log.i("MENU_BUTTONS", "Buildings");
         return;
      }
      
      if(menuButton == buyGoldMenuBtn) {
         Log.i("MENU_BUTTONS", "Gold");
         return;
      }
      
   }
    
}
