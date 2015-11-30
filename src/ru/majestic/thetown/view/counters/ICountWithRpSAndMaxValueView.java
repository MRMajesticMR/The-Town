package ru.majestic.thetown.view.counters;

import java.math.BigInteger;

public interface ICountWithRpSAndMaxValueView extends ICountWithRpSView {
   
   public void onMaxValueChanged(BigInteger maxValue);

}
