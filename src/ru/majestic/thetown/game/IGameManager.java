package ru.majestic.thetown.game;

import android.content.Context;

public interface IGameManager {

   public void load(Context context);
   public void save(Context context);
   
   public void addWood(int wood);
   public void addFood(int food);
   
   public void removeWood(int wood);
   public void removeFood(int food);
   
   public void upFoodClickerLvl();
   public void upWoodClickerLvl();
   
   public int getFoodCount    ();
   public int getWoodCount    ();
   public int getGoldCount    ();
   public int getHomeMaxCount ();
   public int getHomeCount    ();
   
   public int getFoodClickerLvl();
   public int getWoodClickerLvl();
}
