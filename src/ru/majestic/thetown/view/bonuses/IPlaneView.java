package ru.majestic.thetown.view.bonuses;

import ru.majestic.thetown.view.IMovableClickableView;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneClickedListener;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneOutOfViewListener;

public interface IPlaneView extends IMovableClickableView {

   public void       setOnPlaneOutOfViewListener   (OnPlaneOutOfViewListener onPlaneOutOfViewListener);
   public void       setOnPlaneClickedListener     (OnPlaneClickedListener onPlaneClickedListener);   
}
