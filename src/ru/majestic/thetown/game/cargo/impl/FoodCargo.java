package ru.majestic.thetown.game.cargo.impl;

import ru.majestic.thetown.game.cargo.ASizeLimitedCargo;

public class FoodCargo extends ASizeLimitedCargo {

   @Override
   protected String getSaveTag() {
      return "CARGO_FOOD";
   }   

}
