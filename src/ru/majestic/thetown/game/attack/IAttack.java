package ru.majestic.thetown.game.attack;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IAttack {

   public void       load                 (SharedPreferences prefs);
   public void       save                 (Editor prefsEditor);
   
   public long       getTimeToNextAttack  ();
   public void       update               ();
   public int        getAttackPower       ();
   public void       execute              ();
   
   
}
