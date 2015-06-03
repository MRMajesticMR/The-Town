package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IBuildingsManager;
import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.town.ITown;
import ru.majestic.thetown.game.town.impl.Town;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GameManager implements IGameManager {
   
   private static final String PREFFS_NAME = "THE_TOWN_PREFFS";
   
   private static final String PREFF_KEY_FOOD            = "PREFF_KEY_FOOD";
   private static final String PREFF_KEY_GOLD            = "PREFF_KEY_GOLD";
   private static final String PREFF_KEY_WOOD            = "PREFF_KEY_WOOD";
   private static final String PREFF_KEY_HOME_COUNT      = "PREFF_KEY_HOME_COUNT";
   
   private int foodCount;
   private int woodCount;
   private int goldCount;
   private int homeCount;
   
   private final IBuildingsManager  buildingsManager;
   private final IClickersManager   clickersManager;
   private final ITown              town;
   private final IWorkersManager    workersManager;
   
   public GameManager() {
      buildingsManager  = new BuildingsManager();
      clickersManager   = new ClickersManager();
      town              = new Town();
      workersManager    = new WorkersManager();
   }
   
   @Override
   public void load(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      
      foodCount      = prefs.getInt(PREFF_KEY_FOOD, 0);
      goldCount      = prefs.getInt(PREFF_KEY_GOLD, 0);
      woodCount      = prefs.getInt(PREFF_KEY_WOOD, 0);
      homeCount      = prefs.getInt(PREFF_KEY_HOME_COUNT, 0);
      
      buildingsManager.load(prefs);
      clickersManager.load(prefs);
      town.load(prefs);
   }
   
   @Override
   public void save(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();
      
      editor.putInt(PREFF_KEY_FOOD, getFoodCount());
      editor.putInt(PREFF_KEY_GOLD, getGoldCount());
      editor.putInt(PREFF_KEY_WOOD, getWoodCount());
      editor.putInt(PREFF_KEY_HOME_COUNT, getHomeCount());    
      
      buildingsManager.save(editor);
      clickersManager.save(editor);
      town.save(editor);
      
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
   public void removeWood(int wood) {
      woodCount -= wood;
   }

   @Override
   public void removeFood(int food) {
      foodCount -= food;      
   }

   @Override
   public int getHomeCount() {
      return homeCount;
   }

   @Override
   public IBuildingsManager getBuildingsManager() {
      return buildingsManager;
   }

   @Override
   public IClickersManager getClickersManager() {
      return clickersManager;
   }

   @Override
   public ITown getTown() {
      return town;
   }

   @Override
   public IWorkersManager getWorkersManager() {
      return workersManager;
   }
   
}
