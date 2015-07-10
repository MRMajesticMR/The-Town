package ru.majestic.thetown.game.bonuses.impl;

import ru.majestic.thetown.game.bonuses.AGameBonus;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;
import android.util.Log;

public class AddWoodGameBonus extends AGameBonus {

   private final long woodBonus;
   
   private final WoodCargo woodCargo;
   
   public AddWoodGameBonus(WoodCargo woodCargo, int townLvl) {
      this.woodCargo = woodCargo;
      this.woodBonus = calculateBonus(townLvl);
   }
   
   @Override
   protected void executeBonus() {
      Log.d("BONUS", "Add wood: " + woodBonus);
      woodCargo.add(woodBonus);
   }

   @Override
   protected void executeDoubledBonus() {
      woodCargo.add(woodBonus * 2);
   }
   
   private long calculateBonus(int townLvl) {
      return (long) Math.pow((townLvl * 10), 1.4f);
   }

}
