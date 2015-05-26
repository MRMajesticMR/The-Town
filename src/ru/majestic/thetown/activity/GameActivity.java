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
import ru.majestic.thetown.view.IClicker;
import ru.majestic.thetown.view.ICountView;
import ru.majestic.thetown.view.impl.FoodClicker;
import ru.majestic.thetown.view.impl.WoodClicker;
import ru.majestic.thetown.view.impl.counters.FoodCounterView;
import ru.majestic.thetown.view.impl.counters.GoldCounterView;
import ru.majestic.thetown.view.impl.counters.WoodCounterView;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener {

	private Camera 	camera;
	
	private IClicker foodClicker;
	private IClicker woodClicker;
	
	private ICountView foodCountView;
	private ICountView goldCountView;
	private ICountView woodCountView;   
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
		GameManager.getInstance().load();
	   ResourceManager.getInstance().loadResources(this, getEngine());
	   
	   foodClicker = new FoodClicker();
	   woodClicker = new WoodClicker();
	   
	   foodCountView = new FoodCounterView();
	   goldCountView = new GoldCounterView();
	   woodCountView = new WoodCounterView();
	   
	   foodClicker.setOnClickerClickedListener(this);
	   woodClicker.setOnClickerClickedListener(this);
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		
		pOnCreateSceneCallback.onCreateSceneFinished(new TheTownScene());
	}

	@Override
	public void onPopulateScene(Scene scene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		
	   foodClicker.attachToScene(scene);
	   woodClicker.attachToScene(scene);	  
	   
	   foodCountView.attachToScene(scene);
	   goldCountView.attachToScene(scene);
	   woodCountView.attachToScene(scene);
	   
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
    
}
