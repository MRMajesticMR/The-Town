package ru.majestic.thetown.game.cargo;

import java.math.BigInteger;

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
   public void add(BigInteger count) {
      super.add(count);
      if(getCurrentCount().compareTo(getSize()) >= 0) {
         remove(getCurrentCount().subtract(getSize()));
         
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
   public BigInteger getSize() {
      return calculateSize(getLevel());
   }

   @Override
   public BigInteger getUpgradePrice() {
      return calculateUpgradePrice(getLevel());
   }
   
   @Override
   public boolean isFull() {
      return getCurrentCount() == getSize();
   }
      
   @Override
   public BigInteger getNextLevelSize() {
      return calculateSize(getLevel() + 1);
   }
   
   @Override
   public void upgrade() {
      level++;
   }
   
   private BigInteger calculateSize(int level) {            
      return new BigInteger(String.valueOf(level)).multiply(new BigInteger("100")).pow(2);           
   }
   
   private BigInteger calculateUpgradePrice(int level) {
      return new BigInteger(String.valueOf(level)).multiply(new BigInteger("100"));
   }   

}
