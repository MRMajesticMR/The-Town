package ru.majestic.thetown.game;

import java.math.BigInteger;

public class GameManagerHelper {

   public static BigInteger calculateResourcesPerClickFromLvl(int lvl) {
      return new BigInteger(String.valueOf(lvl)).pow(2);
   }
   
   public static BigInteger calculateUpgradeCostFromLvl(int lvl) {
      return new BigInteger(String.valueOf(lvl)).pow(3);
   }
   
}
