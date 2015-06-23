package ru.majestic.thetown.game;

import ru.majestic.thetown.game.listener.OnBillingOperationCompleteListener;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public interface IBillingManager {
   
   public void             init                                      (Context context);
   public void             deinit                                    ();
   
   public void             setOnBillingOperationCompleteListener     (OnBillingOperationCompleteListener onBillingOperationCompleteListener);
   public PendingIntent    getPendingIntentForPurchased              (String itemToken);
   public void             onBillingResultReceived                   (Intent data);
   
}
