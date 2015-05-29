package ru.majestic.thetown.game;

public class GameManagerHelper {

   public static int calculateResourcesPerClickFromLvl(int lvl) {
      return (int) Math.round(Math.pow(lvl, 1.8d));
   }
   
   public static int calculateUpgradeCostFromLvl(int lvl) {
      return (int) Math.round(Math.pow(lvl * lvl, 1.5d));
   }
   
}
