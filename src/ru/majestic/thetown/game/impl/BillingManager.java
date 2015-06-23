package ru.majestic.thetown.game.impl;

import org.json.JSONException;
import org.json.JSONObject;

import ru.majestic.thetown.game.IBillingManager;
import ru.majestic.thetown.game.billing.IGoodsConsumeHelper;
import ru.majestic.thetown.game.billing.impl.GoodsConsumeHelper;
import ru.majestic.thetown.game.billing.listener.OnGoodConsumedListener;
import ru.majestic.thetown.game.listener.OnBillingOperationCompleteListener;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.android.vending.billing.IInAppBillingService;

public class BillingManager implements IBillingManager, 
                                       ServiceConnection,
                                       OnGoodConsumedListener {

   private OnBillingOperationCompleteListener      onBillingOperationCompleteListener;
   private IGoodsConsumeHelper                     goodsConsumeHelper;
   private IInAppBillingService                    billingService;   
   private Context                                 context;
   
   public BillingManager() {
      
   }
   
   @Override
   public void init(Context context) {
      this.context = context;

      Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      serviceIntent.setPackage("com.android.vending");
      context.bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
   }

   @Override
   public void deinit() {
      if(billingService != null) {
         context.unbindService(this);
      }      
   }

   @Override
   public PendingIntent getPendingIntentForPurchased(String itemToken) {      
      if(billingService != null) {
         try {
            Bundle buyIntentBundle = billingService.getBuyIntent(3, context.getPackageName(), itemToken, "inapp", "qweqwedasdasd");
            return buyIntentBundle.getParcelable("BUY_INTENT");                        
         } catch (RemoteException e) {
            e.printStackTrace();
            onBillingOperationCompleteListener.onBillingOperationError();
         }
      }
      
      return null;
   }

   @Override
   public void onServiceConnected(ComponentName name, IBinder service) {
      billingService = IInAppBillingService.Stub.asInterface(service);
      
      goodsConsumeHelper = new GoodsConsumeHelper(billingService, context);
      goodsConsumeHelper.setOnGoodConsumedListener(this);
   }

   @Override
   public void onServiceDisconnected(ComponentName name) {
      billingService = null;      
   }

   @Override
   public void onBillingResultReceived(Intent data) {
      String receivedData = data.getStringExtra("INAPP_PURCHASE_DATA");
      
      try {
         JSONObject dataJSON = new JSONObject(receivedData);
         
         String productId        = dataJSON.getString("productId");
         String purchaseToken    = dataJSON.getString("purchaseToken");
         
         goodsConsumeHelper.consume(productId, purchaseToken);
      } catch (JSONException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void onGoodConsumed(String productId) {
      onBillingOperationCompleteListener.onBillingOperationComplete(productId);
   }

   @Override
   public void onGoodConsumeError() {
      onBillingOperationCompleteListener.onBillingOperationError();
   }

   @Override
   public void setOnBillingOperationCompleteListener(OnBillingOperationCompleteListener onBillingOperationCompleteListener) {
      this.onBillingOperationCompleteListener = onBillingOperationCompleteListener;
   }   
   
}
