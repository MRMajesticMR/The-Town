package ru.majestic.thetown.view;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public interface IClicker {

   public static final int CLICKER_WIDTH_AND_HEIGHT = 200;
   
   public void attachToScene                    (Scene scene);
	public void setOnClickerClickedListener      (OnClickerClickedListener onClickerClickedListener);	
	
}
