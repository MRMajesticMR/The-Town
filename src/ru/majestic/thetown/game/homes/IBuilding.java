package ru.majestic.thetown.game.homes;

import org.andengine.opengl.texture.region.ITextureRegion;

public interface IBuilding {

   public String           getTitle          ();
   public int              getWoodCost       ();
   public int              getExp            ();
   public int              getHomePlaces     ();
   public ITextureRegion   getBuildingImage  ();
   public int              getCurrentCount   ();
   
}
