package ru.majestic.thetown.game.market.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.market.AMarketItem;

public class WoodMarketItem extends AMarketItem {

   public WoodMarketItem(BigInteger goldPrice, BigInteger productCount) {
      super(goldPrice, productCount);
   }

   @Override
   public Type getItemType() {
      return Type.WOOD;
   }

}
