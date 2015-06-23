package ru.majestic.thetown.game.billing;

import ru.majestic.thetown.game.billing.listener.OnGoodConsumedListener;


public interface IGoodsConsumeHelper {

   
   public void setOnGoodConsumedListener(OnGoodConsumedListener onGoodConsumedListener);
   public void consume(String productId, String token);
   
}
