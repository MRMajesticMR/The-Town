package ru.majestic.thetown.andengine;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;

public class TheTownEngineOptions extends EngineOptions {

	public TheTownEngineOptions(Camera camera) {
		super(true, ScreenOrientation.PORTRAIT_FIXED, new FillResolutionPolicy(), camera);
		getAudioOptions().setNeedsSound(true);
	}

}
