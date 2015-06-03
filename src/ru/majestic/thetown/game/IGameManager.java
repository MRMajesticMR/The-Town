package ru.majestic.thetown.game;

import ru.majestic.thetown.game.town.ITown;
import android.content.Context;

public interface IGameManager {

   public void load(Context context);
   public void save(Context context);
   
   public void addWood(int wood);
   public void addFood(int food);
   
   public void removeWood(int wood);
   public void removeFood(int food);
   
   public int getFoodCount    ();
   public int getWoodCount    ();
   public int getGoldCount    ();
   
   public IBuildingsManager   getBuildingsManager  ();
   public IClickersManager    getClickersManager   ();
   public ITown               getTown              ();
   public IWorkersManager     getWorkersManager    ();
}
