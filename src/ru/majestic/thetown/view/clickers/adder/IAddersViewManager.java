package ru.majestic.thetown.view.clickers.adder;

import java.math.BigInteger;

import org.andengine.entity.Entity;

public interface IAddersViewManager {
   
   public enum AdderType {
      FOOD,
      WOOD,
      GOLD
   }
   
   public void attachAdders   (Entity parentLayer);   
   public void showAdder      (float x, float y, BigInteger value, AdderType adderType);
   
}
