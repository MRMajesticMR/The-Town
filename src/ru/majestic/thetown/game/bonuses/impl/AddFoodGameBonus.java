package ru.majestic.thetown.game.bonuses.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.bonuses.AGameBonus;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.view.dialogs.bonus.impl.AddFoodBonusRewardDialog;

public class AddFoodGameBonus extends AGameBonus {

   private BigInteger foodBonus;
   
   private final FoodCargo foodCargo;
   
   public AddFoodGameBonus(FoodCargo foodCargo, int townLvl) {
      this.foodCargo = foodCargo;     
      this.foodBonus = calculateBonus(townLvl);
   }
   
   private BigInteger calculateBonus(int townLvl) {
      return new BigInteger(String.valueOf(townLvl)).multiply(new BigInteger("100")).pow(2);
   }
   
   public void configDialog(AddFoodBonusRewardDialog dialog) {
      dialog.setAddFoodCount(foodBonus);
   }

   @Override
   public void doubleBonus() {
      foodBonus = foodBonus.multiply(new BigInteger("2"));
   }

   @Override
   public void execute() {
      foodCargo.add(foodBonus);      
   }


}
