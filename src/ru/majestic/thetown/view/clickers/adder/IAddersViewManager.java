package ru.majestic.thetown.view.clickers.adder;

import org.andengine.entity.Entity;

public interface IAddersViewManager {
   
   public enum AdderType {
      FOOD,
      WOOD,
      GOLD
   }
   
   public void attachAdders   (Entity parentLayer);   
   public void showAdder      (float x, float y, long value, AdderType adderType);
   
}
