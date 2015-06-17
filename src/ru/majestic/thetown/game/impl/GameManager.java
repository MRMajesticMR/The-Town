package ru.majestic.thetown.game.impl;

import ru.majestic.thetown.game.IAttackManager;
import ru.majestic.thetown.game.IBuildingsManager;
import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.IWorkersManager;
import ru.majestic.thetown.game.town.ITown;
import ru.majestic.thetown.game.town.impl.Town;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GameManager implements IGameManager {
   
   public static final String PREFFS_NAME               = "THE_TOWN_PREFFS";
   
   private final IBuildingsManager  buildingsManager;
   private final IClickersManager   clickersManager;
   private final ITown              town;
   private final IWorkersManager    workersManager;
   private final ICargoManager      cargoManager;
   private final IAttackManager     attackManager;
   
   
   public GameManager() {
      buildingsManager  = new BuildingsManager();
      clickersManager   = new ClickersManager();
      town              = new Town();
      workersManager    = new WorkersManager();
      cargoManager      = new CargoManager();
      attackManager     = new AttackManager();
   }
   
   @Override
   public void load(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      
      buildingsManager.load(prefs);
      clickersManager.load(prefs);
      town.load(prefs);
      workersManager.load(prefs);
      cargoManager.load(prefs);
      attackManager.load(prefs);
   }
   
   @Override
   public void save(Context context) {
      SharedPreferences prefs = context.getSharedPreferences(PREFFS_NAME, Context.MODE_PRIVATE);
      Editor editor = prefs.edit();  
      
      buildingsManager.save(editor);
      clickersManager.save(editor);
      town.save(editor);
      workersManager.save(editor);
      cargoManager.save(editor);
      attackManager.save(editor);
      
      editor.commit();
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

   @Override
   public ICargoManager getCargoManager() {
      return cargoManager;
   }

   @Override
   public IAttackManager getAttackManager() {
      return attackManager;
   }
   
}
