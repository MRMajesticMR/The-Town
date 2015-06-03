package ru.majestic.thetown.game.workers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class AWorker implements IWorker{

   private String title;
   private int    foodCost;
   private int    exp;
   private int    homePlaces;
   private int    currentCount;
   private int    resourcesPerSec;
   
   protected abstract String getSaveTagForCurrentCount();
   
   public AWorker(String title, int foodCost, int exp, int homePlace, int resourcesPerSec) {
      this.title        = title;
      this.foodCost     = foodCost;
      this.exp          = exp;
      this.homePlaces   = homePlace;
      this.resourcesPerSec = resourcesPerSec;
   }
   
   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putInt(getSaveTagForCurrentCount(), getCurrentCount());
   }

   @Override
   public void load(SharedPreferences prefs) {
      currentCount = prefs.getInt(getSaveTagForCurrentCount(), 0);
   }

   @Override
   public String getTitle() {
      return title;
   }

   @Override
   public int getFoodCost() {
      return foodCost;
   }

   @Override
   public int getExp() {
      return exp;
   }

   @Override
   public int getHomePlaces() {
      return homePlaces;
   }

   @Override
   public int getCurrentCount() {
      return currentCount;
   }

   @Override
   public void buy() {
      buy(1);      
   }

   @Override
   public void buy(int count) {
      currentCount += count;
   }

   @Override
   public int getResourcesPerSec() {
      return resourcesPerSec;
   }
}
