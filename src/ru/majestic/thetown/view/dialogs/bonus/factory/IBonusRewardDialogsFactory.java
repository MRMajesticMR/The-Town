package ru.majestic.thetown.view.dialogs.bonus.factory;

import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.view.dialogs.bonus.ABonusRewardDialog;

public interface IBonusRewardDialogsFactory {
   
   public ABonusRewardDialog createBonusRewardDialog(IGameBonus gameBonus);
   public void updateBonusRewardDialog(IGameBonus gameBonus, ABonusRewardDialog bonusRewardDialog);

}
