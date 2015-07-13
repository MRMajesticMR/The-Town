package ru.majestic.thetown.ads.impl;

import android.app.Activity;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.VideoCallbacks;

import ru.majestic.thetown.ads.IAdsManager;
import ru.majestic.thetown.ads.listeners.OnAdShowenListener;

public class AppodealAdsManager implements IAdsManager, VideoCallbacks {

   private static final String APPODEAL_KEY = "33150b2ce04c3df5b669372db0a62534b7747d1559156485";
   
   private Activity              activity;
   private OnAdShowenListener    onAdShowenListener;
   
   public AppodealAdsManager(Activity activity) {
      this.activity = activity;
      
      Appodeal.initialize(activity, APPODEAL_KEY, Appodeal.VIDEO);
      
      Appodeal.setVideoCallbacks(this);
   }
   
   @Override
   public void show() {
      Appodeal.show(activity, Appodeal.VIDEO);
   }

   @Override
   public boolean isAdReady() {
      return Appodeal.isLoaded(Appodeal.VIDEO);
   }

   @Override
   public void setOnAdShowenListener(OnAdShowenListener onAdShowenListener) {
      this.onAdShowenListener = onAdShowenListener;      
   }
   
   @Override
   public void onVideoFinished() {
      this.onAdShowenListener.onAdShowen();            
   }

   @Override
   public void onVideoClosed() {
      //.      
   }

   @Override
   public void onVideoFailedToLoad() {
      //.      
   }   

   @Override
   public void onVideoLoaded() {
      //.      
   }

   @Override
   public void onVideoShown() {
      //.      
   }

}
