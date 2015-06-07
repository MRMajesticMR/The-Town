package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IBuildingsManager;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.game.buildings.impl.BuildingRank2;
import ru.majestic.thetown.game.buildings.impl.BuildingRank4;
import ru.majestic.thetown.game.buildings.impl.BuildingRank5;
import ru.majestic.thetown.game.buildings.impl.BuildingRank3;
import ru.majestic.thetown.game.buildings.impl.BuildingRank1;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class BuildingsManager implements IBuildingsManager {

   private static final int TOTAL_BUILDINGS_TYPE_COUNT = 5;
   
   private IBuilding[] buildings;
   
   public BuildingsManager() {
      buildings = new IBuilding[TOTAL_BUILDINGS_TYPE_COUNT];
      
      buildings[BUILDING_TYPE_TENT]       = new BuildingRank1();
      buildings[BUILDING_TYPE_BIG_TENT]   = new BuildingRank2();
      buildings[BUILDING_TYPE_SHACK]      = new BuildingRank3();
      buildings[BUILDING_TYPE_HUT]        = new BuildingRank4();
      buildings[BUILDING_TYPE_LOG_CABIN]  = new BuildingRank5();
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
