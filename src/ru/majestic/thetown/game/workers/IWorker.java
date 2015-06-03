package ru.majestic.thetown.game.workers;

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
   public int                 getFoodCost       ();
   public int                 getExp            ();
   public int                 getHomePlaces     ();
   public ITextureRegion      getWorkerImage    ();
   public int                 getCurrentCount   ();
   
   public WorkerType          getType           ();
   
   public void                buy               ();
   public void                buy               (int count);
   
}
