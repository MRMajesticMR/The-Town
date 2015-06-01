package ru.majestic.thetown.game.clickers;

import ru.majestic.thetown.game.GameManagerHelper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class AClicker implements IClicker {
   
   private int currentLvl;

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putInt(getTagForSaveCurrentLvl(), getCurrentLvl());
   }

   @Override
   public void load(SharedPreferences prefs) {
      currentLvl = prefs.getInt(getTagForSaveCurrentLvl(), 1);
   }

   @Override
   public int getCurrentLvl() {
      return currentLvl;
   }

   @Override
   public int getResourcesPerClick() {
      return GameManagerHelper.calculateResourcesPerClickFromLvl(getCurrentLvl());
   }

   @Override
   public int getUpgradePrice() {
      return GameManagerHelper.calculateUpgradeCostFromLvl(getCurrentLvl());
   }

   @Override
   public void upgrade() {
      currentLvl++;
   }
   
   protected abstract String getTagForSaveCurrentLvl();

}
