package ru.majestic.thetown.game.market;

import java.math.BigInteger;

public abstract class AMarketItem implements IMarketItem {

   private BigInteger goldPrice;
   private BigInteger productCount;
   
   public AMarketItem(BigInteger goldPrice, BigInteger productCount) {
      this.goldPrice       = goldPrice;
      this.productCount    = productCount;
   }

   @Override
   public BigInteger getGoldPrice() {
      return goldPrice;
   }

   @Override
   public BigInteger getProductCount() {
      return productCount;
   }

}
