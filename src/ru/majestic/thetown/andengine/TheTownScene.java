package ru.majestic.thetown.andengine;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.resources.ResourceManager;

public class TheTownScene extends Scene {
   
	public TheTownScene() {
	   AutoParallaxBackground background = new AutoParallaxBackground(1, 1, 1, 50);
	   
	   background.attachParallaxEntity(new ParallaxEntity(1.0f, new Sprite(0, 0, ResourceManager.getInstance().getBackgroundMidLayerTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager())));
	   background.attachParallaxEntity(new ParallaxEntity(0.0f, new Sprite(0, 400, ResourceManager.getInstance().getBackgroundFrontLayerTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager())));
      
		setBackground(background);
		setBackgroundEnabled(true);
	}

}
