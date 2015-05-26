package ru.majestic.thetown.view;

import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public interface IClicker extends IView {

   public static final int CLICKER_WIDTH_AND_HEIGHT = 200;   
   
	public void setOnClickerClickedListener      (OnClickerClickedListener onClickerClickedListener);	
	
}
