package ru.majestic.thetown.game;

import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.game.listener.OnTimeToAttackListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IAttackManager {

   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   
   public void       setOnTimeToAttackListener  (OnTimeToAttackListener onTimeToAttackListener);
   public IAttack    getAttack                  ();
   public void       startAttackTimeObserve     ();
   public void       stopAttackTimeObserve      ();
   
}
