package ru.majestic.thetown.game.impl;

import java.util.Random;

import ru.majestic.thetown.game.IGoldFromClickerHandler;

public class GoldFromClickerHandler implements IGoldFromClickerHandler {

   private Random random;
   
   public GoldFromClickerHandler() {
      random = new Random(System.currentTimeMillis());      
   }
   
   @Override
   public boolean isGoldChance() {
      if(random.nextInt(300) == 0)
         return true;
      else
         return false;
   }

}
