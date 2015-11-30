package ru.majestic.thetown.view.clickers.adder;

import java.math.BigInteger;

import ru.majestic.thetown.view.IView;

public interface IClickersAdderView extends IView {

   public void       setValue    (BigInteger value);
   public void       show        (float x, float y);
   public boolean    isVisible   ();
   
}
