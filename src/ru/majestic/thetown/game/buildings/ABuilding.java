package ru.majestic.thetown.game.buildings;

import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class ABuilding implements IBuilding {

   private String          title;
   private float           priceKoeff;
   private int             exp;
   private int             homePlaces;
   private ITextureRegion  buildingImage;
   
   protected int     currentCount;
   
   public ABuilding(String title, float priceKoeff, int exp, int homePlaces, ITextureRegion buildingImage) {
      this.title           = title;
      this.priceKoeff      = priceKoeff;
      this.exp             = exp;
      this.homePlaces      = homePlaces;
      this.buildingImage   = buildingImage;
   }

   @Override
   public String getTitle() {
      return title;
   }
   
   @Override
   public int getWoodCost() {
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
   public ITextureRegion getBuildingImage() {
      return buildingImage;
   }
   
   @Override
   public int getCurrentCount() {
      return currentCount;
   }
   
   @Override
   public void buy() {
      this.buy(1);
   }

   @Override
   public void buy(int count) {
      currentCount += count;
   }
   
   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putInt(getSaveDataCurrentCount(), getCurrentCount());
   }

   @Override
   public void load(SharedPreferences prefs) {
      currentCount = prefs.getInt(getSaveDataCurrentCount(), 0);
   }
   
   
   protected abstract String getSaveDataCurrentCount();
}
