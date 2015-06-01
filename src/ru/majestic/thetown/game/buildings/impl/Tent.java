package ru.majestic.thetown.game.buildings.impl;

import ru.majestic.thetown.game.buildings.ABuilding;
import ru.majestic.thetown.resources.ResourceManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Tent extends ABuilding {
   
   private static final String SAVE_TAG_TENT_CURRENT_COUNT = "SAVE_TAG_TENT_CURRENT_COUNT";
   
   public Tent() {
      super("Tent", 1, 1, 1, ResourceManager.getInstance().getHomeIconTextureRegion());
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putInt(SAVE_TAG_TENT_CURRENT_COUNT, getCurrentCount());
   }

   @Override
   public void load(SharedPreferences prefs) {
      currentCount = prefs.getInt(SAVE_TAG_TENT_CURRENT_COUNT, 0);
   }

}
