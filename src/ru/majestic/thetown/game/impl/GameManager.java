package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IGameManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GameManager implements IGameManager {
   
   private static final String PREFFS_NAME = "THE_TOWN_PREFFS";
   
   private static final String PREFF_KEY_FOOD = "PREFF_KEY_FOOD";
   private static final String PREFF_KEY_GOLD = "PREFF_KEY_GOLD";
   private static final String PREFF_KEY_WOOD = "PREFF_KEY_WOOD";
   
   private static final String PREFF_KEY_FOOD_CLICKER_LVL = "PREFF_KEY_FOOD_CLICKER_LVL";
   private static final String PREFF_KEY_WOOD_CLICKER_LVL = "PREFF_KEY_WOOD_CLICKER_LVL";
   
   private int foodCount;
   private int woodCount;
   private int goldCount;
   
   private int foodClickerLvl;
   private int woodClickerLvl;
   
   @Override
   public void load(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      
      foodCount = prefs.getInt(PREFF_KEY_FOOD, 0);
      goldCount = prefs.getInt(PREFF_KEY_GOLD, 0);
      woodCount = prefs.getInt(PREFF_KEY_WOOD, 0);
      
      foodClickerLvl = prefs.getInt(PREFF_KEY_FOOD_CLICKER_LVL, 1);
      woodClickerLvl = prefs.getInt(PREFF_KEY_WOOD_CLICKER_LVL, 1);      
   }
   
   @Override
   public void save(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();
      
      editor.putInt(PREFF_KEY_FOOD, getFoodCount());
      editor.putInt(PREFF_KEY_GOLD, getGoldCount());
      editor.putInt(PREFF_KEY_WOOD, getWoodCount());
      
      editor.putInt(PREFF_KEY_FOOD_CLICKER_LVL, getFoodClickerLvl());
      editor.putInt(PREFF_KEY_WOOD_CLICKER_LVL, getWoodClickerLvl());
      
      editor.commit();
   }
   
   @Override
   public void addWood(int wood) {
      woodCount += wood;
   }
   
   @Override
   public void addFood(int food) {
      foodCount += food;
   }

   @Override
   public int getFoodCount() {
      return foodCount;
   }

   @Override
   public int getWoodCount() {
      return woodCount;
   }

   @Override
   public int getGoldCount() {
      return goldCount;
   }

   @Override
   public void upFoodClickerLvl() {
      this.foodClickerLvl++;
   }

   @Override
   public void upWoodClickerLvl() {
      this.woodClickerLvl++;      
   }

   @Override
   public int getFoodClickerLvl() {
      return foodClickerLvl;
   }

   @Override
   public int getWoodClickerLvl() {
      return woodClickerLvl;
   }

   @Override
   public void removeWood(int wood) {
      woodCount -= wood;
   }

   @Override
   public void removeFood(int food) {
      foodCount -= food;      
   }
   
}