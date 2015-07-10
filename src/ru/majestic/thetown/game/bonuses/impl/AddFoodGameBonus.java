package ru.majestic.thetown.game.bonuses.impl;

import ru.majestic.thetown.game.bonuses.AGameBonus;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import android.util.Log;

public class AddFoodGameBonus extends AGameBonus {

   private final long foodBonus;
   
   private final FoodCargo foodCargo;
   
   public AddFoodGameBonus(FoodCargo foodCargo, int townLvl) {
      this.foodCargo = foodCargo;     
      this.foodBonus = calculateBonus(townLvl);
   }
   
   @Override
   protected void executeBonus() {
      Log.d("BONUS", "Add food: " + foodBonus);
      foodCargo.add(foodBonus);
   }

   @Override
   protected void executeDoubledBonus() {
      foodCargo.add(foodBonus * 2);
   }
   
   private long calculateBonus(int townLvl) {
      return (long) Math.pow((townLvl * 10), 1.4f);
   }


}
