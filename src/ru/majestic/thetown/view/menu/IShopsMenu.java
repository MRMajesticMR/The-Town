package ru.majestic.thetown.view.menu;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.menu.listeners.OnShopsMenuButtonClickedListener;

public interface IShopsMenu extends IClickableView {

   public void setOnShopsMenuButtonClickedListener(OnShopsMenuButtonClickedListener onShopsMenuButtonClickedListener);
   public void clearAllSelection();
   
}
