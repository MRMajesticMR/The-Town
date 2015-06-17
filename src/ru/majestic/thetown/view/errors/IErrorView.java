package ru.majestic.thetown.view.errors;

import ru.majestic.thetown.view.IView;

public interface IErrorView extends IView {

   public void       show        (String message);
   public boolean    isVisible   ();
   
}
