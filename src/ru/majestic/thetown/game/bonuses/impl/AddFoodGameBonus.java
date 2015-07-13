package ru.majestic.thetown.game.bonuses.impl;

import ru.majestic.thetown.game.bonuses.AGameBonus;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.view.dialogs.bonus.impl.AddFoodBonusRewardDialog;

public class AddFoodGameBonus extends AGameBonus {

   private long foodBonus;
   
   private final FoodCargo foodCargo;
   
   public AddFoodGameBonus(FoodCargo foodCargo, int townLvl) {
      this.foodCargo = foodCargo;     
      this.foodBonus = calculateBonus(townLvl);
   }
   
   private long calculateBonus(int townLvl) {
      return (long) Math.pow((townLvl * 100), 1.4f);
   }
   
   public void configDialog(AddFoodBonusRewardDialog dialog) {
      dialog.setAddFoodCount(foodBonus);
   }

   @Override
   public void doubleBonus() {
      foodBonus *= 2;
   }

   @Override
   public void execute() {
      foodCargo.add(foodBonus);      
   }


}
