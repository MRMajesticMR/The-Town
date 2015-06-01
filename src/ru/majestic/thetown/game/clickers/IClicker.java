package ru.majestic.thetown.game.clickers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IClicker {

   public void    save                    (Editor prefsEditor);
   public void    load                    (SharedPreferences prefs);
   
   public int     getCurrentLvl           ();
   public int     getResourcesPerClick    ();
   public int     getUpgradePrice         ();
   public void    upgrade                 ();
   
   public String  getTitle                ();
}
