package ru.majestic.thetown.game.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.game.clickers.impl.FoodClicker;
import ru.majestic.thetown.game.clickers.impl.WoodClicker;

public class ClickersManager implements IClickersManager {

   private IClicker[] clickers;
   
   public ClickersManager() {
      clickers = new IClicker[TOTAL_CLICKERS_COUNT];
      
      clickers[CLICKER_TYPE_FOOD] = new FoodClicker();
      clickers[CLICKER_TYPE_WOOD] = new WoodClicker();
   }
   
   @Override
   public void load(SharedPreferences prefs) {
      for(IClicker clicker: clickers)
         clicker.load(prefs);
   }

   @Override
   public void save(Editor prefsEditor) {
      for(IClicker clicker: clickers)
         clicker.save(prefsEditor);      
   }

   @Override
   public IClicker getClicker(int clickerType) {
      return clickers[clickerType];
   }

}
