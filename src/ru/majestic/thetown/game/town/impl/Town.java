package ru.majestic.thetown.game.town.impl;

import java.util.ArrayList;
import java.util.List;

import ru.majestic.thetown.game.town.ITown;
import ru.majestic.thetown.game.town.ITownLevelReward;
import ru.majestic.thetown.game.town.listeners.OnTownNewLevelObtainedListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class Town implements ITown {

   private static final String LOG_TAG = Town.class.getSimpleName();
   
   private static final String TAG_FOR_SAVE_TOWN_CURRENT_LVL = "TAG_FOR_SAVE_TOWN_CURRENT_LVL";
   private static final String TAG_FOR_SAVE_TOWN_CURRENT_EXP = "TAG_FOR_SAVE_TOWN_CURRENT_EXP";   
   
   private int currentLvl;
   private int currentExp;
   
   private List<OnTownNewLevelObtainedListener> onTownNewLevelObtainedListeners;
   
   public Town() {
      onTownNewLevelObtainedListeners = new ArrayList<OnTownNewLevelObtainedListener>();
   }
   
   @Override
   public void load(SharedPreferences prefs) {
      currentLvl = prefs.getInt(TAG_FOR_SAVE_TOWN_CURRENT_LVL, 1);
      currentExp = prefs.getInt(TAG_FOR_SAVE_TOWN_CURRENT_EXP, 0);
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putInt(TAG_FOR_SAVE_TOWN_CURRENT_LVL, getLvl());
      prefsEditor.putInt(TAG_FOR_SAVE_TOWN_CURRENT_EXP, getCurrentExp());
   }

   @Override
   public int getLvl() {
      return currentLvl;
   }

   @Override
   public int getCurrentExp() {
      return currentExp;
   }

   @Override
   public int getExpToNextLvl() {
      return (int) (Math.pow(currentLvl, 2.4));
   }

   @Override
   public void addExp(int expCount) {
      this.currentExp += expCount;
      
      while(currentExp >= getExpToNextLvl()) {
         currentLvl++;
         notifyListenersOnNewLevelObtained();
      }
   }

   @Override
   public void addOnTownNewLevelObtainedListener(OnTownNewLevelObtainedListener onTownNewLevelObtainedListener) {
      if(!onTownNewLevelObtainedListeners.contains(onTownNewLevelObtainedListener)) {
         onTownNewLevelObtainedListeners.add(onTownNewLevelObtainedListener);
      } else {
         Log.e(LOG_TAG, "Listener already exist");
      }
   }

   @Override
   public void removeOnTownNewLevelObtainedListener(OnTownNewLevelObtainedListener onTownNewLevelObtainedListener) {
      if(onTownNewLevelObtainedListeners.contains(onTownNewLevelObtainedListener)) {
         onTownNewLevelObtainedListeners.remove(onTownNewLevelObtainedListener);
      } else {
         Log.e(LOG_TAG, "Listener not exist");
      }
   }
   
   private void notifyListenersOnNewLevelObtained() {
      ITownLevelReward townLevelReward = new TownLevelReward(getLvl());
      
      for(OnTownNewLevelObtainedListener listener: onTownNewLevelObtainedListeners)
         listener.onTownNewLevelObtained(townLevelReward);
   }

}
