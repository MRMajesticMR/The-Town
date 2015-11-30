package ru.majestic.thetown.view.counters;

import java.math.BigInteger;

public interface ICountWithMaxValueView extends ICountView {
   
   public void onMaxValueChanged(BigInteger maxValue);
   
}
