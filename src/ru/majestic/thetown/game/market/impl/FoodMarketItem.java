package ru.majestic.thetown.game.market.impl;

import ru.majestic.thetown.game.market.AMarketItem;

public class FoodMarketItem extends AMarketItem {

   public FoodMarketItem(long goldPrice, long productCount) {
      super(goldPrice, productCount);
   }

   @Override
   public Type getItemType() {
      return Type.FOOD;
   }

}
