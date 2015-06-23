package ru.majestic.thetown.game.market;

public interface IMarketItem {

   public enum Type {
      WOOD,
      FOOD
   }
   
   public Type    getItemType       ();
   public long    getGoldPrice      ();
   public long    getProductCount   ();
   
}
