package ru.majestic.thetown.game.attack.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.game.town.ITown;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Attack implements IAttack {

   private static final String   SAVE_TAG_NEXT_ATTACK_TIME  = "SAVE_TAG_NEXT_ATTACK_TIME";
   private static final String   SAVE_TAG_ATTACK_POWER      = "SAVE_TAG_ATTACK_POWER";
   
   private static final int      ATTACK_PERIOD = 1000 * 60 * 60 * 3;
   
   private long         nextAttackTime;
   private BigInteger   attackPower;
   
   @Override
   public void load(SharedPreferences prefs) {      
      nextAttackTime = prefs.getLong(SAVE_TAG_NEXT_ATTACK_TIME, System.currentTimeMillis() + ATTACK_PERIOD);
      attackPower    = new BigInteger(prefs.getString(SAVE_TAG_ATTACK_POWER, "3"));            
   }

   @Override
   public void save(Editor prefsEditor) {
      prefsEditor.putLong(SAVE_TAG_NEXT_ATTACK_TIME, getTimeToNextAttack());
      prefsEditor.putString(SAVE_TAG_ATTACK_POWER, getAttackPower().toString());
   }

   @Override
   public long getTimeToNextAttack() {
      return nextAttackTime;
   }

   @Override
   public void update(ITown town) {
      nextAttackTime = System.currentTimeMillis() + ATTACK_PERIOD;
      attackPower    = new BigInteger(String.valueOf(town.getLvl())).pow(2);
   }

   @Override
   public BigInteger getAttackPower() {
      return attackPower;
   }

   @Override
   public BigInteger getWoodReward() {     
      return new BigInteger(String.valueOf(attackPower)).pow(3).add(new BigInteger("1000"));
   }

   @Override
   public BigInteger getFoodReward() {
      return new BigInteger(String.valueOf(attackPower)).pow(3).add(new BigInteger("1000"));
   }

}
