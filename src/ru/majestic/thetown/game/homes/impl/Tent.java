package ru.majestic.thetown.game.homes.impl;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.homes.IBuilding;
import ru.majestic.thetown.resources.ResourceManager;

public class Tent implements IBuilding {

   private String title;
   private int woodCost;
   private int exp;
   private int homePlaces;
   private int currentCount;
   
   public Tent() {
      this.title = "Tent";
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
      return ResourceManager.getInstance().getHomeIconTextureRegion();
   }

   @Override
   public String getTitle() {
      return title;
   }

   @Override
   public int getCurrentCount() {
      return currentCount;
   }

}
