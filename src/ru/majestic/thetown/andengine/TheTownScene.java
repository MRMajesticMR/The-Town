package ru.majestic.thetown.andengine;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.resources.ResourceManager;

public class TheTownScene extends Scene {
   
	public TheTownScene() {
	   AutoParallaxBackground background = new AutoParallaxBackground(1, 1, 1, 60);
	   
	   background.attachParallaxEntity(new ParallaxEntity(0.3f, new Sprite(0, 0, 850, 550, ResourceManager.getInstance().getCloudsTexture(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager())));
	   background.attachParallaxEntity(new ParallaxEntity(0.0f, new Sprite(0, 180, TheTownCamera.CAMERA_WIDTH, 620, ResourceManager.getInstance().getRocksTexture(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager())));
      
		setBackground(background);
		setBackgroundEnabled(true);
	}

}
