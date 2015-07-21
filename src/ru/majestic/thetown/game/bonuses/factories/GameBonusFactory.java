package ru.majestic.thetown.game.bonuses.factories;

import java.util.Random;

import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.game.bonuses.IGameBonusFactory;
import ru.majestic.thetown.game.bonuses.impl.AddFoodGameBonus;
import ru.majestic.thetown.game.bonuses.impl.AddWoodGameBonus;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;

public class GameBonusFactory implements IGameBonusFactory {

   private IGameManager gameManager;
   
   public GameBonusFactory(IGameManager gameManager) {
      this.gameManager = gameManager;
   }
   
   @Override
   public IGameBonus createBonus() {
      switch(new Random(System.currentTimeMillis()).nextInt(2)) {
      case 0:
         return new AddWoodGameBonus((WoodCargo) gameManager.getCargoManager().getWoodCargo(), gameManager.getTown().getLvl());
         
      case 1:
         return new AddFoodGameBonus((FoodCargo) gameManager.getCargoManager().getFoodCargo(), gameManager.getTown().getLvl());
         
      default:
         return null;
      }
   }

   
}
