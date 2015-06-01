package ru.majestic.thetown.view.dialogs;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;

public interface IDialog extends IClickableView {

   public void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener);
   
   public void    show  ();
   public void    hide  ();
   public boolean isVisible();   
   
}
