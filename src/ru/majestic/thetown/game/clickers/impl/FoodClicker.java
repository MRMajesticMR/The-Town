package ru.majestic.thetown.game.clickers.impl;

import ru.majestic.thetown.game.clickers.AClicker;

public class FoodClicker extends AClicker {

   private static final String TAG_FOR_SAVE_CURRENT_LVL = "TAG_FOR_SAVE_CURRENT_LVL_CLICKER_FOOD";
   
   @Override
   protected String getTagForSaveCurrentLvl() {
      return TAG_FOR_SAVE_CURRENT_LVL;
   }

   @Override
   public String getTitle() {
      return "Food";
   }

}
