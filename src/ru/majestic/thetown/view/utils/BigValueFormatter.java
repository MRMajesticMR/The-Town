package ru.majestic.thetown.view.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class BigValueFormatter {
   
   static final DecimalFormat format = new DecimalFormat("#.##");
   
   private static final Map<BigDecimal, String> values;

   static {
       Map<BigDecimal, String> tempCommandsMap = new LinkedHashMap<BigDecimal, String>();
       tempCommandsMap.put(new BigDecimal("1000000000000000"),       "EE");
       tempCommandsMap.put(new BigDecimal("1000000000000"),       "DD");
       tempCommandsMap.put(new BigDecimal("1000000000"),       "CC");
       tempCommandsMap.put(new BigDecimal("1000000"),       "BB");             
       tempCommandsMap.put(new BigDecimal("1000"),       "AA");
       
       values = Collections.unmodifiableMap(tempCommandsMap);
   }

   public static String format(BigInteger value) {
   
       BigDecimal decimalValue = new BigDecimal(value);
       
       Iterator<BigDecimal> kiesIter = values.keySet().iterator();
       
       while(kiesIter.hasNext()) {
          BigDecimal currentMappedValue = kiesIter.next();
          
          if(decimalValue.compareTo(currentMappedValue) >= 0) {
             return format.format(Float.valueOf(decimalValue.divide(currentMappedValue).toString())) + values.get(currentMappedValue);
          }
       }

       return value.toString();
   }      
}
