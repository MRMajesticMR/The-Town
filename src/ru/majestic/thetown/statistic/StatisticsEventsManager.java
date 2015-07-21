package ru.majestic.thetown.statistic;

import java.util.HashMap;
import java.util.Map;

import com.flurry.android.FlurryAgent;


public class StatisticsEventsManager {
   
   public static final String LAUNCH_MODE_TAG = "launch_mode";
   
   public static final String LAUNCH_MODE_NOTIFICATION_CARGO_FULL    = "cargo_full";
   public static final String LAUNCH_MODE_NOTIFICATION_BEFORE_ATTACK = "notif_before_attack";
   public static final String LAUNCH_MODE_NOTIFICATION_AFTER_ATTACK  = "notif_after_attack";
   public static final String LAUNCH_MODE_HOME_SCREEN                = "home_screen";

   private static final String FLURRY_EVENT_APP_LAUNCH = "app_launch";
   
   private static StatisticsEventsManager instance;
   
   private StatisticsEventsManager() {
      
   }
   
   public static StatisticsEventsManager getInstance() {
      if(instance == null)
         instance = new StatisticsEventsManager();
      return instance;
   }
   
   public void onApplicationLaunched(String launchMode) {
      if(launchMode == null) {
         launchMode = LAUNCH_MODE_HOME_SCREEN;
      }
      
      final Map<String, String> params = new HashMap<String, String>();
      params.put(LAUNCH_MODE_TAG, launchMode);
      FlurryAgent.onEvent(FLURRY_EVENT_APP_LAUNCH, params);
   }
   
}
