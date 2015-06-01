package ru.majestic.thetown.game;

import ru.majestic.thetown.game.buildings.IBuilding;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IBuildingsManager {

   public static final int BUILDING_TYPE_TENT         = 0;
   public static final int BUILDING_TYPE_BIG_TENT     = 1;
   public static final int BUILDING_TYPE_SHACK        = 2;
   public static final int BUILDING_TYPE_HUT          = 3;
   public static final int BUILDING_TYPE_LOG_CABIN    = 4;
   
   
   public void       load                       (SharedPreferences prefs);
   public void       save                       (Editor prefsEditor);
   
   public IBuilding  getBuilding                (int buildingType);
   public int        getTotalHomePlacesCount    ();
   
}
