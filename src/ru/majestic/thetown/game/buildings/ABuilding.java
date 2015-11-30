package ru.majestic.thetown.game.buildings;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class ABuilding implements IBuilding {

   private String          title;
   private BigInteger      exp;
   private BigInteger      homePlaces;
   private ITextureRegion  buildingImage;
   
   protected int     currentCount;
   
   public ABuilding(String title, BigInteger exp, BigInteger homePlaces, ITextureRegion buildingImage) {
      this.title           = title;
      this.exp             = exp;
      this.homePlaces      = homePlaces;
      this.buildingImage   = buildingImage;
   }

   @Override
   public String getTitle() {
      return title;
   }
   
   @Override
   public BigInteger getWoodCost() {
      return new BigInteger(String.valueOf(getCurrentCount())).divide(new BigInteger("10")).add(new BigInteger("1"));
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
