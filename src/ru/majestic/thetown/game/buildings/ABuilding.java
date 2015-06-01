package ru.majestic.thetown.game.buildings;

import org.andengine.opengl.texture.region.ITextureRegion;

public abstract class ABuilding implements IBuilding {

   private String          title;
   private int             woodCost;
   private int             exp;
   private int             homePlaces;
   private ITextureRegion  buildingImage;
   
   protected int     currentCount;
   
   public ABuilding(String title, int woodCost, int exp, int homePlaces, ITextureRegion buildingImage) {
      this.title           = title;
      this.woodCost        = woodCost;
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
      return woodCost;
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
   
}
