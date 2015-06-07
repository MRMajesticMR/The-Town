package ru.majestic.thetown.view.utils;

import java.math.BigDecimal;

public class BigValueFormatter {

   private static final long AA        = 1000000000000L;
   private static final long BILLION   = 1000000000L;
   private static final long MILLION   = 1000000L;
   private static final long THOUSAND  = 1000L;
   
   public static String format(long value) {
                  
      if(value >= AA) {
         BigDecimal bd = new BigDecimal(Float.toString(value / (float) AA));
         bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
         return bd.floatValue() + "AA";
      }
      
      if(value >= BILLION) {
         BigDecimal bd = new BigDecimal(Float.toString(value / (float) BILLION));
         bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
         return bd.floatValue() + "B";
      }
      
      if(value >= MILLION) {
         BigDecimal bd = new BigDecimal(Float.toString(value / (float) MILLION));
         bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
         return bd.floatValue() + "M";
      }
      
      if(value >= THOUSAND) {
         BigDecimal bd = new BigDecimal(Float.toString(value / (float) THOUSAND));
         bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
         return bd.floatValue() + "T";      
      }
      
      return String.valueOf(value);
   }
   
}
