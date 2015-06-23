package ru.majestic.thetown.game.market;

public abstract class AMarketItem implements IMarketItem {

   private long goldPrice;
   private long productCount;
   
   public AMarketItem(long goldPrice, long productCount) {
      this.goldPrice       = goldPrice;
      this.productCount    = productCount;
   }

   @Override
   public long getGoldPrice() {
      return goldPrice;
   }

   @Override
   public long getProductCount() {
      return productCount;
   }

}
