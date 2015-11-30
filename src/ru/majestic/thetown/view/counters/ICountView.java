package ru.majestic.thetown.view.counters;

import java.math.BigInteger;

import ru.majestic.thetown.view.IView;

public interface ICountView extends IView {

   public void changeCount(BigInteger newValue);   
   
}
