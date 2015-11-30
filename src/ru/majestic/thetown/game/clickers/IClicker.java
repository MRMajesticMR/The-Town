package ru.majestic.thetown.game.clickers;

import java.math.BigInteger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface IClicker {

   public void    save                    (Editor prefsEditor);
   public void    load                    (SharedPreferences prefs);
   
   public int            getCurrentLvl           ();
   public BigInteger     getResourcesPerClick    ();
   public BigInteger     getUpgradePrice         ();
   public void           upgrade                 ();
   
   public String  getTitle                ();
}
