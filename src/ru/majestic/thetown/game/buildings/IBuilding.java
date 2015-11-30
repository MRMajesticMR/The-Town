package ru.majestic.thetown.game.buildings;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IBuilding {

   public void             save              (Editor prefsEditor);
   public void             load              (SharedPreferences prefs);   
   
   public String           getTitle          ();
   public BigInteger       getWoodCost       ();
   public BigInteger       getExp            ();
   public BigInteger       getHomePlaces     ();
   public ITextureRegion   getBuildingImage  ();
   public int              getCurrentCount   ();
   
   public void             buy               ();
   public void             buy               (int count);
   
}
