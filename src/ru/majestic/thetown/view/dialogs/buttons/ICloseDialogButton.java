package ru.majestic.thetown.view.dialogs.buttons;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;

public interface ICloseDialogButton extends IClickableView {

   public void setOnCloseDialogButtonClickedListener(OnCloseDialogButtonClickedListener onCloseDialogButtonClickedListener);
   
}
