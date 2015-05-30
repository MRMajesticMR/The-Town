package ru.majestic.thetown.view.menu.listeners;

public interface OnShopsMenuButtonClickedListener {

   public enum ShopType {
      CLICKERS,
      WORKERS,
      BUILDINGS,
      GOLD
   }
   
   public void onNeedOpenShopDialog(ShopType shopType); 
   
}
