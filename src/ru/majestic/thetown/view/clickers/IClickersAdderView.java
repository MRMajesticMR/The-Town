package ru.majestic.thetown.view.clickers;

import ru.majestic.thetown.view.IView;

public interface IClickersAdderView extends IView {

   public void       setValue    (long value);
   public void       show        (float x, float y);
   public boolean    isVisible   ();
   
}
