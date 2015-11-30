package ru.majestic.thetown.game.workers;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IWorker {

   public enum WorkerType {
      FOOD,
      WOOD,
      DEFENCE
   }
   
   public void                save              (Editor prefsEditor);
   public void                load              (SharedPreferences prefs);   
   
   public String              getTitle          ();
   public BigInteger          getFoodCost       ();
   public BigInteger          getExp            ();
   public BigInteger          getHomePlaces     ();
   public ITextureRegion      getWorkerImage    ();
   public BigInteger          getCurrentCount   ();
   public BigInteger          getResourcesPerSec();
   
   public WorkerType          getType           ();
   
   public void                buy               ();
   public void                buy               (int count);
   
}
