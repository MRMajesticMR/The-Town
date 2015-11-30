package ru.majestic.thetown.game.cargo;

import java.math.BigInteger;

public interface ISizeLimitedCargo extends ICargo {

   public interface OnCargoFullListener {
      
      public void onCargoFull(ISizeLimitedCargo cargo);
      
   }
   
   public void setOnCargoFullListener(OnCargoFullListener onCargoFullListener);
   public void removeOnCargoFullListener();
   
   public int           getLevel          ();
   public BigInteger    getSize           ();
   public BigInteger    getUpgradePrice   ();
   public boolean       isFull            ();
   public BigInteger    getNextLevelSize  ();
   public void          upgrade           ();
   
}
