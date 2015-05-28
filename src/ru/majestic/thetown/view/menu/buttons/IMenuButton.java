package ru.majestic.thetown.view.menu.buttons;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.menu.buttons.listeners.OnMenuButtonClickedListener;

public interface IMenuButton extends IClickableView {

   public void setOnMenuButtonClickedListener(OnMenuButtonClickedListener onMenuButtonClickedListener);
   
   public void setButtonWidth    (float width);
   public void setButtonHeight   (float height);
   public void setButtonX        (float x);
   
   
}
