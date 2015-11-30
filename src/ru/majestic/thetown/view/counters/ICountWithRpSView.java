package ru.majestic.thetown.view.counters;

import java.math.BigInteger;

public interface ICountWithRpSView extends ICountView {

   public void updateResourcesPerSecondValue(BigInteger resourcesPerSecond);
   
}
