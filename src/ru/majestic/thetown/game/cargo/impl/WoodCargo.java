package ru.majestic.thetown.game.cargo.impl;

import ru.majestic.thetown.game.cargo.ASizeLimitedCargo;

public class WoodCargo extends ASizeLimitedCargo {

   @Override
   protected String getSaveTag() {
      return "CARGO_WOOD";
   }

}
