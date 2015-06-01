package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IBuildingsManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.game.buildings.impl.BigTent;
import ru.majestic.thetown.game.buildings.impl.Hut;
import ru.majestic.thetown.game.buildings.impl.Logcabin;
import ru.majestic.thetown.game.buildings.impl.Shack;
import ru.majestic.thetown.game.buildings.impl.Tent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class BuildingsManager implements IBuildingsManager {

   private static final int TOTAL_BUILDINGS_TYPE_COUNT = 5;
   
   private IBuilding[] buildings;
   
   public BuildingsManager() {
      buildings = new IBuilding[TOTAL_BUILDINGS_TYPE_COUNT];
      
      buildings[BUILDING_TYPE_TENT]       = new Tent();
      buildings[BUILDING_TYPE_BIG_TENT]   = new BigTent();
      buildings[BUILDING_TYPE_SHACK]      = new Shack();
      buildings[BUILDING_TYPE_HUT]        = new Hut();
      buildings[BUILDING_TYPE_LOG_CABIN]  = new Logcabin();
   }
   
   @Override
   public void load(SharedPreferences prefs) {
      for(IBuilding building: buildings)
         building.load(prefs);
   }

   @Override
   public void save(Editor prefsEditor) {
      for(IBuilding building: buildings)
         building.save(prefsEditor);      
   }

   @Override
   public IBuilding getBuilding(int buildingType) {            
      return buildings[buildingType];
   }

   @Override
   public int getTotalHomePlacesCount() {
      int count = 0;
      
      for(IBuilding building: buildings) {
         count += building.getCurrentCount() * building.getHomePlaces();
      }
      
      return count;
   }

}
