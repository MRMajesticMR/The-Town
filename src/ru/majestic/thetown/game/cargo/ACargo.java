package ru.majestic.thetown.game.cargo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class ACargo implements ICargo {

   private static final String SAVE_SUFFIX_COUNT = "_COUNT";
   
   private long count;
   
   protected abstract String getSaveTag();
   
   @Override
   public void load(SharedPreferences prefs) {
      count = prefs.getLong(getSaveTag() + SAVE_SUFFIX_COUNT, 0);
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putLong(getSaveTag() + SAVE_SUFFIX_COUNT, getCurrentCount());      
   }

   @Override
   public long getCurrentCount() {
      return count;
   }

   @Override
   public void add(long count) {
      this.count += count;
   }

   @Override
   public void remove(long count) {
      this.count -= count;
   }

}
