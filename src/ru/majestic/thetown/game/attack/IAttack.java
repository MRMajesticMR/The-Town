package ru.majestic.thetown.game.attack;

import ru.majestic.thetown.game.town.ITown;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IAttack {

   public void       load                 (SharedPreferences prefs);
   public void       save                 (Editor prefsEditor);
   
   public long       getTimeToNextAttack  ();
   public void       update               (ITown town);
   public int        getAttackPower       ();
   
   public long       getWoodReward        ();
   public long       getFoodReward        ();
}
