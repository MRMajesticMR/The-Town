package ru.majestic.thetown.game.buildings;

import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IBuilding {

   public void             save              (Editor prefsEditor);
   public void             load              (SharedPreferences prefs);   
   
   public String           getTitle          ();
   public int              getWoodCost       ();
   public int              getExp            ();
   public int              getHomePlaces     ();
   public ITextureRegion   getBuildingImage  ();
   public int              getCurrentCount   ();
   
   public void             buy               ();
   public void             buy               (int count);
   
}
