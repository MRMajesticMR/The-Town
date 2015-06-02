package ru.majestic.thetown.game.town;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ITown {

   public void       load         (SharedPreferences prefs);
   public void       save         (Editor prefsEditor);
   
   public int     getLvl          ();
   public int     getCurrentExp   ();
   public int     getExpToNextLvl ();
   public void    addExp         (int expCount);   
   
}
