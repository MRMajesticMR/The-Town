package ru.majestic.thetown.game.town.impl;

import ru.majestic.thetown.game.town.ITown;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Town implements ITown {

   private static final String TAG_FOR_SAVE_TOWN_CURRENT_LVL = "TAG_FOR_SAVE_TOWN_CURRENT_LVL";
   private static final String TAG_FOR_SAVE_TOWN_CURRENT_EXP = "TAG_FOR_SAVE_TOWN_CURRENT_EXP";   
   
   private int currentLvl;
   private int currentExp;
   
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
      return (int) (Math.pow(currentLvl, 1.7));
   }

   @Override
   public void addExp(int expCount) {
      this.currentExp += expCount;
      
      while(currentExp >= getExpToNextLvl()) {
         currentLvl++;
      }
   }      

}
