package ru.majestic.thetown.application;

import ru.majestic.thetown.notifications.TheTownNotificationManager;
import android.app.Application;

import com.flurry.android.FlurryAgent;

public class TheTownApplication extends Application {
      
   @Override
   public void onCreate() {
      super.onCreate();
            
      FlurryAgent.init(this, "MYW6Q6GVNZJKMYMTP2KV");
      
      TheTownNotificationManager.startAlarmManager(this);                 
   }

}
