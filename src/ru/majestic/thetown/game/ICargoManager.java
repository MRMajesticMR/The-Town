package ru.majestic.thetown.game;

import ru.majestic.thetown.game.cargo.ICargo;
import ru.majestic.thetown.game.cargo.ISizeLimitedCargo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface ICargoManager {   
   
   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public ICargo getGoldCargo();
   public ISizeLimitedCargo getWoodCargo();
   public ISizeLimitedCargo getFoodCargo();
}
