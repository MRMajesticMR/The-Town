package ru.majestic.thetown.debug;

import android.util.Log;

public class DebugConfig {

   private static final int STATE_DEBUG      = 0;
   private static final int STATE_PRODUCTION = 1;
   
   private static final int CURRENT_STATE = STATE_DEBUG;
   
   public static boolean isDebug() {
      return CURRENT_STATE == STATE_DEBUG;
   }
   
   public static void log(String logTag, String message) {
      Log.d(logTag, message);
   }
   
   
}
