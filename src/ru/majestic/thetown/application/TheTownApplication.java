package ru.majestic.thetown.application;

import com.flurry.android.FlurryAgent;

import ru.majestic.thetown.notifications.TheTownNotificationManager;
import android.app.Application;

public class TheTownApplication extends Application {
      
   @Override
   public void onCreate() {
      super.onCreate();
            
      FlurryAgent.init(this, "MYW6Q6GVNZJKMYMTP2KV");
      
      TheTownNotificationManager.startAlarmManager(this);     
   }

}
