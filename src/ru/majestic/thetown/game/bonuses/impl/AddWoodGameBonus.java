package ru.majestic.thetown.game.bonuses.impl;

import ru.majestic.thetown.game.bonuses.AGameBonus;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;
import ru.majestic.thetown.view.dialogs.bonus.impl.AddWoodBonusRewardDialog;

public class AddWoodGameBonus extends AGameBonus {

   private long woodBonus;
   
   private final WoodCargo woodCargo;
   
   public AddWoodGameBonus(WoodCargo woodCargo, int townLvl) {
      this.woodCargo = woodCargo;
      this.woodBonus = calculateBonus(townLvl);
   }
   
   private long calculateBonus(int townLvl) {
      return (long) Math.pow((townLvl * 100), 1.4f);
   }
   
   public void configDialog(AddWoodBonusRewardDialog dialog) {
      dialog.setAddWoodCount(woodBonus);
   }

   @Override
   public void doubleBonus() {
      woodBonus *= 2;
      
   }

   @Override
   public void execute() {
      woodCargo.add(woodBonus);      
   }

}
