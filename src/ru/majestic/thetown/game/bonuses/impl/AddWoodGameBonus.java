package ru.majestic.thetown.game.bonuses.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.bonuses.AGameBonus;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;
import ru.majestic.thetown.view.dialogs.bonus.impl.AddWoodBonusRewardDialog;

public class AddWoodGameBonus extends AGameBonus {

   private BigInteger woodBonus;
   
   private final WoodCargo woodCargo;
   
   public AddWoodGameBonus(WoodCargo woodCargo, int townLvl) {
      this.woodCargo = woodCargo;
      this.woodBonus = calculateBonus(townLvl);
   }
   
   private BigInteger calculateBonus(int townLvl) {
      return new BigInteger(String.valueOf(townLvl)).multiply(new BigInteger("100")).pow(2);
   }
   
   public void configDialog(AddWoodBonusRewardDialog dialog) {
      dialog.setAddWoodCount(woodBonus);
   }

   @Override
   public void doubleBonus() {
      woodBonus = woodBonus.multiply(new BigInteger("2"));
      
   }

   @Override
   public void execute() {
      woodCargo.add(woodBonus);      
   }

}
