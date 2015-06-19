package ru.majestic.thetown.game.attack.impl;

import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.game.town.ITown;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Attack implements IAttack {

   private static final String   SAVE_TAG_NEXT_ATTACK_TIME  = "SAVE_TAG_NEXT_ATTACK_TIME";
   private static final String   SAVE_TAG_ATTACK_POWER      = "SAVE_TAG_ATTACK_POWER";
   
   private static final int      ATTACK_PERIOD = 1000 * 60 * 60 * 3;
   
   private long   nextAttackTime;
   private int    attackPower;
   
   @Override
   public void load(SharedPreferences prefs) {      
      nextAttackTime = prefs.getLong(SAVE_TAG_NEXT_ATTACK_TIME, System.currentTimeMillis() + ATTACK_PERIOD);
      attackPower    = prefs.getInt(SAVE_TAG_ATTACK_POWER, 0);            
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putLong(SAVE_TAG_NEXT_ATTACK_TIME, getTimeToNextAttack());
      prefsEditor.putInt(SAVE_TAG_ATTACK_POWER, getAttackPower());
   }

   @Override
   public long getTimeToNextAttack() {
      return nextAttackTime;
   }

   @Override
   public void update(ITown town) {
      nextAttackTime = System.currentTimeMillis() + ATTACK_PERIOD;
      attackPower    = (int) (Math.pow(2, town.getLvl())) + 1;
   }

   @Override
   public int getAttackPower() {
      return attackPower;
   }

}
