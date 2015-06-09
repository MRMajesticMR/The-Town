package ru.majestic.thetown.game.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.cargo.ICargo;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.game.cargo.impl.GoldCargo;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;

public class CargoManager implements ICargoManager {

   private static final int CARGO_COUNT = 3;
   
   private ICargo[] cargos;
   
   public CargoManager() {
      cargos = new ICargo[CARGO_COUNT];
      
      cargos[CARGO_TYPE_WOOD] = new WoodCargo();
      cargos[CARGO_TYPE_FOOD] = new FoodCargo();
      cargos[CARGO_TYPE_GOLD] = new GoldCargo();
   }
   
   @Override
   public ICargo getCargo(int cargoType) {
      return cargos[cargoType];
   }

   @Override
   public void load(SharedPreferences prefs) {
      for(ICargo cargo: cargos)
         cargo.load(prefs);
   }

   @Override
   public void save(Editor prefsEditor) {
      for(ICargo cargo: cargos)
         cargo.save(prefsEditor);      
   }

}
