package ru.majestic.thetown.game.listener;

public interface OnBillingOperationCompleteListener {
   
   public void onBillingOperationComplete (String productId);
   public void onBillingOperationError    ();
   
}
