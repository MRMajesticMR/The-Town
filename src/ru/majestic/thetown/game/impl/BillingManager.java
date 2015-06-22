package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IBillingManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.android.vending.billing.IInAppBillingService;

public class BillingManager implements IBillingManager, ServiceConnection {

   private IInAppBillingService     billingService;
   
   public BillingManager() {
      
   }
   
   @Override
   public void init(Context context) {
      Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      serviceIntent.setPackage("com.android.vending");
      context.bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
   }

   @Override
   public void deinit(Context context) {
      if(billingService != null) {
         context.unbindService(this);
      }      
   }

   @Override
   public PendingIntent getPendingIntentForPurchased(Context context, String itemToken) {      
      if(billingService != null) {
         try {
            Bundle buyIntentBundle = billingService.getBuyIntent(3, context.getPackageName(), itemToken, "inapp", "qweqwedasdasd");
            return buyIntentBundle.getParcelable("BUY_INTENT");                        
         } catch (RemoteException e) {
            e.printStackTrace();
         }
      }
      
      return null;
   }

   @Override
   public void onServiceConnected(ComponentName name, IBinder service) {
      billingService = IInAppBillingService.Stub.asInterface(service);      
   }

   @Override
   public void onServiceDisconnected(ComponentName name) {
      billingService = null;      
   }   
   
}
