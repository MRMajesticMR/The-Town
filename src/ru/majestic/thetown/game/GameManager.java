package ru.majestic.thetown.game;

public class GameManager {

   private static GameManager instance;
   
   private int foodCount;
   private int woodCount;
   
   private GameManager() {
      
   }
   
   public static GameManager getInstance() {
      if(instance == null)
         instance = new GameManager();
      return instance;
   }
   
   public void load() {
      foodCount = 0;
      woodCount = 0;
   }
   
   public void addWood(int wood) {
      woodCount += wood;
   }
   
   public void addFood(int food) {
      foodCount += food;
   }

   public int getFoodCount() {
      return foodCount;
   }

   public int getWoodCount() {
      return woodCount;
   }
   
}
