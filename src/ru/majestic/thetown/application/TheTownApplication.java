package ru.majestic.thetown.application;

import ru.majestic.thetown.notifications.TheTownNotificationManager;
import android.app.Application;

public class TheTownApplication extends Application {
      
   @Override
   public void onCreate() {
      super.onCreate();
      
      TheTownNotificationManager.startAlarmManager(this);      
   }

}
