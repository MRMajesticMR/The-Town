package ru.majestic.thetown.view.dialogs.bonus.factory.impl;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.game.bonuses.impl.AddFoodGameBonus;
import ru.majestic.thetown.game.bonuses.impl.AddWoodGameBonus;
import ru.majestic.thetown.view.dialogs.bonus.ABonusRewardDialog;
import ru.majestic.thetown.view.dialogs.bonus.factory.IBonusRewardDialogsFactory;
import ru.majestic.thetown.view.dialogs.bonus.impl.AddFoodBonusRewardDialog;
import ru.majestic.thetown.view.dialogs.bonus.impl.AddWoodBonusRewardDialog;

public class BonusRewardDialogsFactory implements IBonusRewardDialogsFactory {

   private AddFoodBonusRewardDialog addFoodBonusRewardDialog;
   private AddWoodBonusRewardDialog addWoodBonusRewardDialog;
   
   public BonusRewardDialogsFactory(Scene scene) {
      addFoodBonusRewardDialog = new AddFoodBonusRewardDialog(scene);
      addWoodBonusRewardDialog = new AddWoodBonusRewardDialog(scene);
   }
   
   @Override
   public ABonusRewardDialog createBonusRewardDialog(IGameBonus gameBonus) {
      if(gameBonus instanceof AddFoodGameBonus) {
         ((AddFoodGameBonus) gameBonus).configDialog(addFoodBonusRewardDialog);
         return addFoodBonusRewardDialog;
      }
      
      if(gameBonus instanceof AddWoodGameBonus) {
         ((AddWoodGameBonus) gameBonus).configDialog(addWoodBonusRewardDialog);
         return addWoodBonusRewardDialog;
      }
      
      throw new IllegalArgumentException();
   }

   @Override
   public void updateBonusRewardDialog(IGameBonus gameBonus, ABonusRewardDialog bonusRewardDialog) {
      if(gameBonus instanceof AddFoodGameBonus) {
         ((AddFoodGameBonus) gameBonus).configDialog(addFoodBonusRewardDialog);
      }
      
      if(gameBonus instanceof AddWoodGameBonus) {
         ((AddWoodGameBonus) gameBonus).configDialog(addWoodBonusRewardDialog);
      }
   }

}
