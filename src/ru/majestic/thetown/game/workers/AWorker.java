package ru.majestic.thetown.game.workers;

import java.math.BigInteger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class AWorker implements IWorker{

   private String          title;
   private BigInteger             exp;
   private BigInteger             homePlaces;
   private BigInteger             currentCount;
   private BigInteger      resourcesPerSec;
   
   protected abstract String getSaveTagForCurrentCount();
   
   public AWorker(String title, BigInteger exp, BigInteger homePlace, BigInteger resourcesPerSec) {
      this.title        = title;
      this.exp          = exp;
      this.homePlaces   = homePlace;
      this.resourcesPerSec = resourcesPerSec;
   }
   
   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putString(getSaveTagForCurrentCount(), getCurrentCount().toString());
   }

   @Override
   public void load(SharedPreferences prefs) {
      currentCount = new BigInteger(prefs.getString(getSaveTagForCurrentCount(), "0"));
   }

   @Override
   public String getTitle() {
      return title;
   }

   @Override
   public BigInteger getFoodCost() {
      return getCurrentCount().divide(new BigInteger("10")).add(new BigInteger("1"));
   }

   @Override
   public BigInteger getExp() {
      return exp;
   }

   @Override
   public BigInteger getHomePlaces() {
      return homePlaces;
   }

   @Override
   public BigInteger getCurrentCount() {
      return currentCount;
   }

   @Override
   public void buy() {
      buy(1);      
   }

   @Override
   public void buy(int count) {
      currentCount = currentCount.add(new BigInteger(String.valueOf(count)));
   }

   @Override
   public BigInteger getResourcesPerSec() {
      return resourcesPerSec;
   }
}
