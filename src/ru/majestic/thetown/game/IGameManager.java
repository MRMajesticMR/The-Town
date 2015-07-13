package ru.majestic.thetown.game;

import ru.majestic.thetown.game.town.ITown;
import android.content.Context;

public interface IGameManager {

   public void load(Context context);
   public void save(Context context);
   
   public IBuildingsManager   getBuildingsManager  ();
   public IClickersManager    getClickersManager   ();
   public ITown               getTown              ();
   public IWorkersManager     getWorkersManager    ();
   public ICargoManager       getCargoManager      ();
   public IAttackManager      getAttackManager     ();
   
}
