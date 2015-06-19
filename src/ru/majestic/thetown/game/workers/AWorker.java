package ru.majestic.thetown.game.workers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class AWorker implements IWorker{

   private String title;
   private float  priceKoeff;
   private int    exp;
   private int    homePlaces;
   private int    currentCount;
   private int    resourcesPerSec;
   
   protected abstract String getSaveTagForCurrentCount();
   
   public AWorker(String title, float priceKoeff, int exp, int homePlace, int resourcesPerSec) {
      this.title        = title;
      this.priceKoeff     = priceKoeff;
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
      return (int) Math.pow(priceKoeff * ((getCurrentCount() / 10.0f) + 1), 1.0005f);
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
