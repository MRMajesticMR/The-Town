package ru.majestic.thetown.game.market.impl;

import java.math.BigInteger;

import ru.majestic.thetown.game.market.AMarketItem;

public class FoodMarketItem extends AMarketItem {

   public FoodMarketItem(BigInteger goldPrice, BigInteger productCount) {
      super(goldPrice, productCount);
   }

   @Override
   public Type getItemType() {
      return Type.FOOD;
   }

}
