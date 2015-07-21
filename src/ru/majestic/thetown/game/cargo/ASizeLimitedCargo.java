package ru.majestic.thetown.game.cargo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class ASizeLimitedCargo extends ACargo implements ISizeLimitedCargo {

   private static final String SAVE_SUFFIX_LEVEL = "_LEVEL";
   
   private int level;
   
   private OnCargoFullListener onCargoFullListener;
   
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
         
         if(onCargoFullListener != null)
            onCargoFullListener.onCargoFull(this);
      }      
   }
   
   @Override
   public int getLevel() {
      return level;
   }
   
   @Override
   public void setOnCargoFullListener(OnCargoFullListener onCargoFullListener) {
      this.onCargoFullListener = onCargoFullListener;      
   }

   @Override
   public void removeOnCargoFullListener() {
      this.onCargoFullListener = null;
   }

   @Override
   public long getSize() {
      return calculateSize(getLevel());
   }

   @Override
   public long getUpgradePrice() {
      return calculateUpgradePrice(getLevel());
   }
   
   @Override
   public boolean isFull() {
      return getCurrentCount() == getSize();
   }
      
   @Override
   public long getNextLevelSize() {
      return calculateSize(getLevel() + 1);
   }
   
   @Override
   public void upgrade() {
      level++;
   }
   
   private long calculateSize(int level) {
      return (long) Math.pow((level * 100.0f), 1.3f);            
   }
   
   private long calculateUpgradePrice(int level) {
      return (long) Math.pow((level * 100.0f), 1.0005f);
   }   

}
