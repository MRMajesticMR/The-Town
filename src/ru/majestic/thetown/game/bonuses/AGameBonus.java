package ru.majestic.thetown.game.bonuses;

public abstract class AGameBonus implements IGameBonus {

   private boolean bonusDoubled;
   
   public AGameBonus() {
      bonusDoubled = false;
   }
   
   protected abstract void executeBonus         ();
   protected abstract void executeDoubledBonus  ();

   @Override
   public void doubleBonus() {
      bonusDoubled = true;
   }

   @Override
   public void execute() {
      if(bonusDoubled) {
         executeDoubledBonus();
      } else {
         executeBonus();
      }
   }

}
