package ru.majestic.thetown.game;

public class GameManagerHelper {

   public static int calculateResourcesPerClickFromLvl(int lvl) {
      return (int) (Math.pow(lvl, 1.6f));
   }
   
   public static int calculateUpgradeCostFromLvl(int lvl) {
      return (int) (Math.pow(lvl, 1.9f));
   }
   
}
