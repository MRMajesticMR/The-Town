package ru.majestic.thetown.game;

import android.app.PendingIntent;
import android.content.Context;

public interface IBillingManager {

   public static final String ITEM_TOKEN_TEN_GOLD       = "buy_gold_ten";
   public static final String ITEM_TOKEN_HUNDRED_GOLD   = "buy_gold_hundred";
   public static final String ITEM_TOKEN_THOUSAND_GOLD  = "buy_gold_thousand";   
   
   
   public void init     (Context context);
   public void deinit   (Context context);
   public PendingIntent getPendingIntentForPurchased     (Context context, String itemToken);
   
}
