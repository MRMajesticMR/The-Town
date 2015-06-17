package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IAttackManager;
import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.game.attack.impl.Attack;
import ru.majestic.thetown.game.listener.OnTimeToAttackListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AttackManager implements IAttackManager, Runnable {
   
   private final  IAttack                 attack;   
   private        boolean                 observe;
   private        OnTimeToAttackListener  onTimeToAttackListener;
   
   public AttackManager() {
      attack = new Attack();
   }
   
   @Override
   public void load(SharedPreferences prefs) {
      attack.load(prefs);
   }

   @Override
   public void save(Editor prefsEditor) {
      attack.save(prefsEditor);
   }

   @Override
   public IAttack getAttack() {
      return attack;
   }

   @Override
   public void run() {
      while(observe) {
         
         if(System.currentTimeMillis() > attack.getTimeToNextAttack()) {
            onTimeToAttackListener.onTimeToAttack();
         }
         
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e){};
      }      
   }

   @Override
   public void startAttackTimeObserve() {
      observe = true;
      
      new Thread(this).start();
   }

   @Override
   public void stopAttackTimeObserve() {
      observe = false;
   }
   
   @Override
   public void setOnTimeToAttackListener(OnTimeToAttackListener onTimeToAttackListener) {
      this.onTimeToAttackListener = onTimeToAttackListener;
   }   
}
