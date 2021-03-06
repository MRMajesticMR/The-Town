package ru.majestic.thetown.notifications;

import java.math.BigInteger;

import ru.majestic.thetown.R;
import ru.majestic.thetown.activity.GameActivity;
import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.game.attack.impl.Attack;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;
import ru.majestic.thetown.game.impl.GameManager;
import ru.majestic.thetown.game.impl.WorkersManager;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.IWorkersProductionHandler;
import ru.majestic.thetown.game.workers.impl.WorkersProductionHandler;
import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;
import ru.majestic.thetown.statistic.StatisticsEventsManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.NotificationCompat;

public class TheTownNotificationManager extends BroadcastReceiver {

   private static final long ALARM_MANAGER_INTERVAL      = 1000 * 60 * 10; //30 MIN   
      
   private static final long TIME_TO_ATTACK_HALF_HOUR    = 1000 * 60 * 30;
   private static final long TIME_TO_ATTACK_HOUR         = TIME_TO_ATTACK_HALF_HOUR * 2;     
   
   private static final String SAVE_TAG_HALF_HOUR  = "SAVE_TAG_HALF_HOUR";
   private static final String SAVE_TAG_HOUR       = "SAVE_TAG_HOUR";
   private static final String SAVE_TAG_ATTACKED   = "SAVE_TAG_ATTACKED";
   
   private static final int NOTIFICATION_ID_CARGO_FULL = 100;
   
   public enum AttackTimeType {
      HOUR, 
      HALF_HOUR
   }   
   
   public static void startAlarmManager(Context context) {
      AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);      
      Intent intent = new Intent(context, TheTownNotificationManager.class);      
      PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);      
      alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, ALARM_MANAGER_INTERVAL, alarmIntent);
   }
   
   public static void reset(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();
      editor.putBoolean(SAVE_TAG_HALF_HOUR, false);
      editor.putBoolean(SAVE_TAG_HOUR, false);
      editor.putBoolean(SAVE_TAG_ATTACKED, false);      
      editor.commit();
   }
   
   @Override
   public void onReceive(Context context, Intent intent) {
      if(intent.getAction() == Intent.ACTION_BOOT_COMPLETED) {
         startAlarmManager(context);
      } else {      
         showNotificationIfItNeed(context);
         showCargoFullNotification(context);
      }
   }        
   
   private void showNotificationIfItNeed(Context context) {
      IAttack nextAttack = new Attack();
      nextAttack.load(context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE));      
      
      IWorkersManager workersManager = new WorkersManager();
      workersManager.load(context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE));
      
      if(nextAttack.getAttackPower().compareTo(workersManager.getResourcesPerSecond(WorkerType.DEFENCE)) > 0) {
         if(nextAttack.getTimeToNextAttack() - System.currentTimeMillis() < TheTownNotificationManager.TIME_TO_ATTACK_HALF_HOUR && !isNotifictionAlreadyShowed(context, SAVE_TAG_HALF_HOUR)) {
            saveNotificationShowed(context, SAVE_TAG_HALF_HOUR);
            showAttackNotificaton(context, AttackTimeType.HALF_HOUR);
            return;
         }
         
         if(nextAttack.getTimeToNextAttack() - System.currentTimeMillis() < TheTownNotificationManager.TIME_TO_ATTACK_HOUR && !isNotifictionAlreadyShowed(context, SAVE_TAG_HOUR)) {
            saveNotificationShowed(context, SAVE_TAG_HOUR);
            showAttackNotificaton(context, AttackTimeType.HOUR);
            return;
         }
         
         if(nextAttack.getTimeToNextAttack() - System.currentTimeMillis() < 0 && !isNotifictionAlreadyShowed(context, SAVE_TAG_ATTACKED)) {
            saveNotificationShowed(context, SAVE_TAG_ATTACKED);
            showAttackedNotificaton(context, true);
            return;
         }
      } else {
         if(nextAttack.getTimeToNextAttack() - System.currentTimeMillis() < 0 && !isNotifictionAlreadyShowed(context, SAVE_TAG_ATTACKED)) {
            saveNotificationShowed(context, SAVE_TAG_ATTACKED);
            showAttackedNotificaton(context, false);
            return;
         }
      }
   }
   
   private void showCargoFullNotification(Context context) {
      SharedPreferences gameState = context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE); 
      
      IWorkersManager workersManager = new WorkersManager();
      workersManager.load(gameState);
      
      final FoodCargo foodCargo = new FoodCargo();
      foodCargo.load(gameState);
      
      final WoodCargo woodCargo = new WoodCargo();
      woodCargo.load(gameState);
      
      IWorkersProductionHandler workersProductionHandler = new WorkersProductionHandler(workersManager);
      workersProductionHandler.setOnWokersProductionCompleteListener(new OnWokersProductionCompleteListener() {
         
         @Override
         public void onWorkersProductionComplete(BigInteger addFood, BigInteger addWood) {
            foodCargo.add(addFood);
            woodCargo.add(addWood);
         }
      });
      workersProductionHandler.load(context);            
      workersProductionHandler.save(context);
      
      Editor editor = gameState.edit();
      
      foodCargo.save(editor);
      woodCargo.save(editor);
      
      editor.commit();
                  
      NotificationCompat.Builder mBuilder = null;
      
      if(foodCargo.isFull() && woodCargo.isFull()) {      
         mBuilder = new NotificationCompat.Builder(context)
         .setSmallIcon(R.drawable.swords_icon)
         .setContentTitle("All warehouses is full")
         .setContentText("Wood and food warehouse is full. Come and upgrade it!")
         .setAutoCancel(true);                  
      } else if(foodCargo.isFull()) {
         mBuilder = new NotificationCompat.Builder(context)
         .setSmallIcon(R.drawable.swords_icon)
         .setContentTitle("Food warehouse is full")
         .setContentText("Food warehouse is full. Come and upgrade it!")
         .setAutoCancel(true);
      } else if(woodCargo.isFull()) {
         mBuilder = new NotificationCompat.Builder(context)
         .setSmallIcon(R.drawable.swords_icon)
         .setContentTitle("Wood warehouse is full")
         .setContentText("Wood warehouse is full. Come and upgrade it!")
         .setAutoCancel(true);
      }
      
      if(mBuilder != null) {
         Intent resultIntent = new Intent(context, GameActivity.class);
         resultIntent.putExtra(StatisticsEventsManager.LAUNCH_MODE_TAG, StatisticsEventsManager.LAUNCH_MODE_NOTIFICATION_CARGO_FULL);
      
         PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, 0);
      
         mBuilder.setContentIntent(resultPendingIntent);
         NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
         mNotificationManager.notify(NOTIFICATION_ID_CARGO_FULL, mBuilder.build());
      }
   }
   
   private void showAttackNotificaton(Context context, AttackTimeType attackTimeType) {
      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.swords_icon)
            .setContentTitle(getTitleString(attackTimeType))
            .setContentText("You haven't enough defence force for protect your Town! Come and buy more defenders!")
            .setAutoCancel(true);

      Intent resultIntent = new Intent(context, GameActivity.class);
      resultIntent.putExtra(StatisticsEventsManager.LAUNCH_MODE_TAG, StatisticsEventsManager.LAUNCH_MODE_NOTIFICATION_BEFORE_ATTACK);

      PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, 0);

      mBuilder.setContentIntent(resultPendingIntent);
      NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
      mNotificationManager.notify(0, mBuilder.build());
   }
   
   private String getTitleString(AttackTimeType attackTimeType) {
      switch(attackTimeType) {
      case HOUR:
         return "One hour before attack!";
      case HALF_HOUR:
         return "Half hour before attack!";
      default:
         return null;
      }
   }
   
   private void showAttackedNotificaton(Context context, boolean attackSuccess) {
      NotificationCompat.Builder mBuilder = null;
      
      if(attackSuccess) {
         mBuilder = new NotificationCompat.Builder(context)
               .setSmallIcon(R.drawable.swords_icon)
               .setContentTitle("You've been attacked!")
               .setContentText("Come and check your Town. New wave of attackers come soon.")
               .setAutoCancel(true);         
      } else {
         mBuilder = new NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.swords_icon)
            .setContentTitle("Attackers have been defeated!")
            .setContentText("Come and take your reward!")
            .setAutoCancel(true);
      }

      Intent resultIntent = new Intent(context, GameActivity.class);
      resultIntent.putExtra(StatisticsEventsManager.LAUNCH_MODE_TAG, StatisticsEventsManager.LAUNCH_MODE_NOTIFICATION_AFTER_ATTACK);
      
      PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, 0);

      mBuilder.setContentIntent(resultPendingIntent);
      NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
      mNotificationManager.notify(0, mBuilder.build());
   }
   
   private void saveNotificationShowed(Context context, String saveTag) {
      SharedPreferences prefs = context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();
      editor.putBoolean(saveTag, true);
      editor.commit();
   }
   
   private boolean isNotifictionAlreadyShowed(Context context, String saveTag) {
      SharedPreferences prefs = context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE);
      return prefs.getBoolean(saveTag, false);
   }
}
