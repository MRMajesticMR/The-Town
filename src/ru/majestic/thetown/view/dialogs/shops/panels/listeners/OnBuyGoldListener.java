package ru.majestic.thetown.view.dialogs.shops.panels.listeners;

public interface OnBuyGoldListener {

   public enum BuyType {
      TEN,
      HUNDRED,
      THOUSAND
   }
   
   public void onBuyGold(BuyType buyType);
   
}
