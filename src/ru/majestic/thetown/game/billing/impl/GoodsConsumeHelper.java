package ru.majestic.thetown.game.billing.impl;

import com.android.vending.billing.IInAppBillingService;

import android.content.Context;
import android.os.RemoteException;
import ru.majestic.thetown.game.billing.IGoodsConsumeHelper;
import ru.majestic.thetown.game.billing.listener.OnGoodConsumedListener;

public class GoodsConsumeHelper implements IGoodsConsumeHelper, Runnable {

   
   private OnGoodConsumedListener   onGoodConsumedListener;
   private IInAppBillingService     inAppBillingService;
   private Context                  context;
   
   private String                   productId;
   private String                   goodToken;
   
   public GoodsConsumeHelper(IInAppBillingService inAppBillingService, Context context) {
      this.inAppBillingService   = inAppBillingService;
      this.context               = context;
   }

   
   @Override
   public void setOnGoodConsumedListener(OnGoodConsumedListener onGoodConsumedListener) {
      this.onGoodConsumedListener = onGoodConsumedListener;
   }
   
   @Override
   public void consume(String productId, String token) {
      this.productId = productId;
      this.goodToken = token;
      
      new Thread(this).start();
   }

   @Override
   public void run() {
      try {
         int response = inAppBillingService.consumePurchase(3, context.getPackageName(), goodToken);
         if(response == 0) 
            onGoodConsumedListener.onGoodConsumed(productId);
         else
            onGoodConsumedListener.onGoodConsumeError();
         
      } catch (RemoteException e) {
         e.printStackTrace();
      }
   }

}
