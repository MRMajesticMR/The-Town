package ru.majestic.thetown.game.cargo;

public interface ISizeLimitedCargo extends ICargo {

   public int  getLevel          ();
   public long getSize           ();
   public long getUpgradePrice   ();
   public boolean isFull         ();
   
}
