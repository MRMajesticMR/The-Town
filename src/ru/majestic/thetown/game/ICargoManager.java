package ru.majestic.thetown.game;

import ru.majestic.thetown.game.cargo.ICargo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ICargoManager {

   public static final int CARGO_TYPE_FOOD = 0;
   public static final int CARGO_TYPE_WOOD = 1;
   public static final int CARGO_TYPE_GOLD = 2;   
   
   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public ICargo     getCargo          (int cargoType);
}
