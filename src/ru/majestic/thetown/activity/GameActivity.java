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
	
	private IMenuButton upgradeClickersMenuBtn;
	private IMenuButton buyPeopleMenuBtn;
	
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
	   
	   upgradeClickersMenuBtn    = new TextMenuButton("Clickers");	   	   
	   buyPeopleMenuBtn          = new TextMenuButton("Workers");
	   
	   foodClicker.setOnClickerClickedListener(this);
	   woodClicker.setOnClickerClickedListener(this);	   	   
	   
	   upgradeClickersMenuBtn.setOnMenuButtonClickedListener(this);
	   buyPeopleMenuBtn.setOnMenuButtonClickedListener(this);
	   
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
	   
	   bottomMenu.addIMenuButton(upgradeClickersMenuBtn);
	   bottomMenu.addIMenuButton(buyPeopleMenuBtn);
	   
	   bottomMenu.attachToParent(scene);
	   
	   foodClicker.registerTouchArea(scene);
	   woodClicker.registerTouchArea(scene);
	   
	   upgradeClickersMenuBtn.registerTouchArea(scene);
	   buyPeopleMenuBtn.registerTouchArea(scene);
	   
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
      if(menuButton == upgradeClickersMenuBtn) {
         Log.i("MENU_BUTTONS", "Clickers");
         return;
      }
      
      if(menuButton == buyPeopleMenuBtn) {
         Log.i("MENU_BUTTONS", "Workers");
         return;
      }
      
   }
    
}
