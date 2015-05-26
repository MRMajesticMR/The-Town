package ru.majestic.thetown.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GameManager {

   private static GameManager instance;
   
   private static final String PREFFS_NAME = "THE_TOWN_PREFFS";
   
   private static final String PREFF_KEY_FOOD = "PREFF_KEY_FOOD";
   private static final String PREFF_KEY_GOLD = "PREFF_KEY_GOLD";
   private static final String PREFF_KEY_WOOD = "PREFF_KEY_WOOD";
   
   private int foodCount;
   private int woodCount;
   private int goldCount;
   
   private GameManager() {
      
   }
   
   public static GameManager getInstance() {
      if(instance == null)
         instance = new GameManager();
      return instance;
   }
   
   public void load(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      
      foodCount = prefs.getInt(PREFF_KEY_FOOD, 0);
      goldCount = prefs.getInt(PREFF_KEY_GOLD, 0);
      woodCount = prefs.getInt(PREFF_KEY_WOOD, 0);      
   }
   
   public void save(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();
      editor.putInt(PREFF_KEY_FOOD, getFoodCount());
      editor.putInt(PREFF_KEY_GOLD, getGoldCount());
      editor.putInt(PREFF_KEY_WOOD, getWoodCount());
      editor.commit();
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

   public int getGoldCount() {
      return goldCount;
   }
   
}
