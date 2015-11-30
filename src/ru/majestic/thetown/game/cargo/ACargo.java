package ru.majestic.thetown.game.cargo;

import java.math.BigInteger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class ACargo implements ICargo {

   private static final String SAVE_SUFFIX_COUNT = "_COUNT";
   
   private BigInteger count;
   
   protected abstract String getSaveTag();
   
   @Override
   public void load(SharedPreferences prefs) {      
      count = new BigInteger(prefs.getString(getSaveTag() + SAVE_SUFFIX_COUNT, "0"));
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putString(getSaveTag() + SAVE_SUFFIX_COUNT, getCurrentCount().toString());      
   }

   @Override
   public BigInteger getCurrentCount() {
      return count;
   }

   @Override
   public void add(BigInteger count) {
      this.count = this.count.add(count);
   }

   @Override
   public void remove(BigInteger count) {
      this.count = this.count.subtract(count);
   }

   @Override
   public void clear() {
      count = new BigInteger("0");
   }

}
