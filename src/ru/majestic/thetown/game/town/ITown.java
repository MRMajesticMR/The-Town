package ru.majestic.thetown.game.town;

import ru.majestic.thetown.game.town.listeners.OnTownNewLevelObtainedListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ITown {

   public void       load         (SharedPreferences prefs);
   public void       save         (Editor prefsEditor);
   
   public int              getLvl                              ();
   public int              getCurrentExp                       ();
   public int              getExpToNextLvl                     ();
   public void             addExp                              (int expCount);   
   
   public void             addOnTownNewLevelObtainedListener      (OnTownNewLevelObtainedListener onTownNewLevelObtainedListener);
   public void             removeOnTownNewLevelObtainedListener   (OnTownNewLevelObtainedListener onTownNewLevelObtainedListener);
   
}
