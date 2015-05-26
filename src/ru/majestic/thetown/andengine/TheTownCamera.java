package ru.majestic.thetown.andengine;

import org.andengine.engine.camera.Camera;

public class TheTownCamera extends Camera {

	public static final int CAMERA_WIDTH 	  = 480;
	public static final int CAMERA_HEIGHT    = 800;
	
	public TheTownCamera() {
		super(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	}

}
