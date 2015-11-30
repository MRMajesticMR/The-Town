package ru.majestic.thetown.game.town.impl;

import java.math.BigInteger;
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
   
   private int          currentLvl;
   private BigInteger   currentExp;
   
   private List<OnTownNewLevelObtainedListener> onTownNewLevelObtainedListeners;
   
   public Town() {
      onTownNewLevelObtainedListeners = new ArrayList<OnTownNewLevelObtainedListener>();
   }
   
   @Override
   public void load(SharedPreferences prefs) {
      currentLvl = prefs.getInt(TAG_FOR_SAVE_TOWN_CURRENT_LVL, 1);
      currentExp = new BigInteger(prefs.getString(TAG_FOR_SAVE_TOWN_CURRENT_EXP, "0"));
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putInt(TAG_FOR_SAVE_TOWN_CURRENT_LVL, getLvl());
      prefsEditor.putString(TAG_FOR_SAVE_TOWN_CURRENT_EXP, getCurrentExp().toString());
   }

   @Override
   public int getLvl() {
      return currentLvl;
   }

   @Override
   public BigInteger getCurrentExp() {
      return currentExp;
   }

   @Override
   public BigInteger getExpToNextLvl() {
      return new BigInteger(String.valueOf(currentLvl)).pow(2);
   }

   @Override
   public void addExp(BigInteger expCount) {
      currentExp = currentExp.add(expCount);
      
      while(currentExp.compareTo(getExpToNextLvl()) >= 0) {
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
