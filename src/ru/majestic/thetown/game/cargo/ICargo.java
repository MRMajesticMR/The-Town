package ru.majestic.thetown.game.cargo;

import java.math.BigInteger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ICargo {

   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public BigInteger getCurrentCount   ();
   public void       add               (BigInteger count);
   public void       remove            (BigInteger count);
   public void       clear             ();
   
}
