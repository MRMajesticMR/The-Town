package ru.majestic.thetown.game;

import ru.majestic.thetown.game.clickers.IClicker;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IClickersManager {
   
   public static final int TOTAL_CLICKERS_COUNT    = 2;

   public static final int CLICKER_TYPE_FOOD       = 0;
   public static final int CLICKER_TYPE_WOOD       = 1;
   
   public void       load              (SharedPreferences prefs);
   public void       save              (Editor prefsEditor);
   
   public IClicker   getClicker        (int clickerType);
   
}
