package ru.majestic.thetown.game;

import ru.majestic.thetown.game.buildings.IBuilding;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IBuildingsManager {

   public static final int BUILDING_TYPE_TENT = 0;
   
   public void       load                       (SharedPreferences prefs);
   public void       save                       (Editor prefsEditor);
   
   public IBuilding  getBuilding                (int buildingType);
   public int        getTotalHomePlacesCount    ();
   
}
