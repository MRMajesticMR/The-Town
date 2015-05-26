package ru.majestic.thetown.andengine;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;

public class TheTownScene extends Scene {
	
	public TheTownScene() {
		setBackground(new Background(0.0f, 1.0f, 0.0f));
		setBackgroundEnabled(true);
	}

}
