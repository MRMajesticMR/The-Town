package ru.majestic.thetown.game.town;

import java.math.BigInteger;

import ru.majestic.thetown.game.town.listeners.OnTownNewLevelObtainedListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ITown {

   public void       load         (SharedPreferences prefs);
   public void       save         (Editor prefsEditor);
   
   public int              getLvl                              ();
   public BigInteger       getCurrentExp                       ();
   public BigInteger       getExpToNextLvl                     ();
   public void             addExp                              (BigInteger expCount);   
   
   public void             addOnTownNewLevelObtainedListener      (OnTownNewLevelObtainedListener onTownNewLevelObtainedListener);
   public void             removeOnTownNewLevelObtainedListener   (OnTownNewLevelObtainedListener onTownNewLevelObtainedListener);
   
}
