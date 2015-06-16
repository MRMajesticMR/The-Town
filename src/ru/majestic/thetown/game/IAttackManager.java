package ru.majestic.thetown.game;

import ru.majestic.thetown.game.attack.IAttack;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IAttackManager {

   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   
   public IAttack    getAttack         ();
   public void       startAttackTimeObserve();
   public void       stopAttackTimeObserve();
   
}
