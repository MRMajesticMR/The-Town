package ru.majestic.thetown.view.clickers;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public interface IClickerView extends IClickableView {   
   
	public void setOnClickerClickedListener      (OnClickerClickedListener onClickerClickedListener);
	
}
