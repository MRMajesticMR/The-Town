package ru.majestic.thetown.game.cargo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ICargo {

   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public long       getCurrentCount   ();
   public void       add               (long count);
   public void       remove            (long count);
   public void       clear             ();
   
}
