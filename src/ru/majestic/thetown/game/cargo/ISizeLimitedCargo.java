package ru.majestic.thetown.game.cargo;

public interface ISizeLimitedCargo extends ICargo {

   public interface OnCargoFullListener {
      
      public void onCargoFull(ISizeLimitedCargo cargo);
      
   }
   
   public void setOnCargoFullListener(OnCargoFullListener onCargoFullListener);
   public void removeOnCargoFullListener();
   
   public int  getLevel          ();
   public long getSize           ();
   public long getUpgradePrice   ();
   public boolean isFull         ();
   public long getNextLevelSize  ();
   
}
