package ru.majestic.thetown.game.cargo.impl;

import ru.majestic.thetown.game.cargo.ACargo;

public class GoldCargo extends ACargo {

   @Override
   protected String getSaveTag() {
      return "CARGO_GOLD";
   }

}
