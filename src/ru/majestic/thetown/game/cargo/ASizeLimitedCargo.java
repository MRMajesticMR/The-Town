package ru.majestic.thetown.game.cargo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class ASizeLimitedCargo extends ACargo implements ISizeLimitedCargo {

   private static final String SAVE_SUFFIX_LEVEL = "_LEVEL";
   
   private int level;
   
   @Override
   public void load(SharedPreferences prefs) {
      super.load(prefs);
      
      level = prefs.getInt(getSaveTag() + SAVE_SUFFIX_LEVEL, 1);
   }

   @Override
   public void save(Editor prefsEditor) {
      super.save(prefsEditor);
      
      prefsEditor.putInt(getSaveTag() + SAVE_SUFFIX_LEVEL, getLevel());      
   }
   
   @Override
   public void add(long count) {
      super.add(count);
      if(getCurrentCount() > getSize()) {
         remove(getCurrentCount() - getSize());
      }      
   }
   
   @Override
   public int getLevel() {
      return level;
   }

   @Override
   public long getSize() {
      return calculateSize(getLevel());
   }

   @Override
   public long getUpgradePrice() {
      return calculateUpgradePrice(getLevel());
   }
   
   private long calculateSize(int level) {
      return level;
   }
   
   private long calculateUpgradePrice(int level) {
      return level;
   }

   @Override
   public boolean isFull() {
      return getCurrentCount() == getSize();
   }

}
