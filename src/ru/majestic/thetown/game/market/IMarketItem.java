package ru.majestic.thetown.game.market;

import java.math.BigInteger;

public interface IMarketItem {

   public enum Type {
      WOOD,
      FOOD
   }
   
   public Type          getItemType       ();
   public BigInteger    getGoldPrice      ();
   public BigInteger    getProductCount   ();
   
}
