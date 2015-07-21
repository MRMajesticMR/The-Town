package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.cargo.ICargo;
import ru.majestic.thetown.game.cargo.ISizeLimitedCargo;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.game.cargo.impl.GoldCargo;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class CargoManager implements ICargoManager {
   
   private WoodCargo woodCargo;
   private FoodCargo foodCargo;
   private GoldCargo goldCargo;
   
   public CargoManager() {
      
      woodCargo = new WoodCargo();
      foodCargo = new FoodCargo();
      goldCargo = new GoldCargo();
   }

   @Override
   public void load(SharedPreferences prefs) {
      woodCargo.load(prefs);
      foodCargo.load(prefs);
      goldCargo.load(prefs);            
   }

   @Override
   public void save(Editor prefsEditor) {
      woodCargo.save(prefsEditor);
      foodCargo.save(prefsEditor);
      goldCargo.save(prefsEditor);     
   }

   @Override
   public ICargo getGoldCargo() {
      return goldCargo;
   }

   @Override
   public ISizeLimitedCargo getWoodCargo() {
      return woodCargo;
   }

   @Override
   public ISizeLimitedCargo getFoodCargo() {
      return foodCargo;
   }

}
