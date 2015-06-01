package ru.majestic.thetown.game.buildings.impl;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Tent extends ABuilding {
   
   public Tent() {
      super("Tent", 1, 1, 1, ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   public void save(Editor prefsEditor) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void load(SharedPreferences prefs) {
      // TODO Auto-generated method stub
      
   }

}
