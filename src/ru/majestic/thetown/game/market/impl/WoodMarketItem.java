package ru.majestic.thetown.game.market.impl;

import ru.majestic.thetown.game.market.AMarketItem;

public class WoodMarketItem extends AMarketItem {

   public WoodMarketItem(long goldPrice, long productCount) {
      super(goldPrice, productCount);
   }

   @Override
   public Type getItemType() {
      return Type.WOOD;
   }

}
