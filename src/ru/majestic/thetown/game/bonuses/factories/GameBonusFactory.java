package ru.majestic.thetown.game.bonuses.factories;

import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.game.bonuses.IGameBonusFactory;
import ru.majestic.thetown.game.bonuses.impl.AddWoodGameBonus;

public class GameBonusFactory implements IGameBonusFactory {

   private static final int GAME_BONUSES_COUNT = 1;
   
   private static final int BONUS_INDEX_WOOD = 0;
   
   private IGameBonus[] gameBonuses;
   
   public GameBonusFactory() {
      gameBonuses = new IGameBonus[GAME_BONUSES_COUNT];
      
      gameBonuses[BONUS_INDEX_WOOD] = new AddWoodGameBonus();
   }
   
   @Override
   public IGameBonus createBonus() {
      return gameBonuses[BONUS_INDEX_WOOD];
   }

   
}
