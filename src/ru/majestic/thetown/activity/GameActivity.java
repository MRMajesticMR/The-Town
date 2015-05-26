package ru.majestic.thetown.activity;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.util.Log;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.andengine.TheTownEngineOptions;
import ru.majestic.thetown.andengine.TheTownScene;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.IClicker;
import ru.majestic.thetown.view.impl.FoodClicker;
import ru.majestic.thetown.view.impl.WoodClicker;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener {

	private Camera 	camera;
	
	private IClicker foodClicker;
	private IClicker woodClicker;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
		
	   ResourceManager.getInstance().loadResources(this, getEngine());
	   
	   foodClicker = new FoodClicker();
	   woodClicker = new WoodClicker();
	   
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
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}

   @Override
   public void onClickerClicked(IClicker clicker) {
      if(clicker == foodClicker) {
         Log.i("CLICKED", "More food!");
      }
      
      if(clicker == woodClicker) {
         Log.i("CLICKED", "More wood!");
      }
      
   }

    
    
}
