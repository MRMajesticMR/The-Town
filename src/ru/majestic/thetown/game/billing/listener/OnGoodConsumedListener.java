package ru.majestic.thetown.game.billing.listener;

public interface OnGoodConsumedListener {

   public void onGoodConsumed       (String productId);
   public void onGoodConsumeError   ();
   
}
