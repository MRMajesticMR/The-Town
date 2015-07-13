package ru.majestic.thetown.view.dialogs.bonus.impl;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.bonus.ABonusRewardDialog;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class AddWoodBonusRewardDialog extends ABonusRewardDialog {

   private final Text      woodCountTxt;
   private final Sprite    woodIcon;
   
   public AddWoodBonusRewardDialog(Scene scene) {
      super(scene);
      
      woodCountTxt      = new Text(0, 0, ResourceManager.getInstance().getDialogsResourceManager().getBonusRewardDialogsResourceManager().getBonusDialogMessageFont(), "+100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      woodIcon          = new Sprite(0, 0, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      updateCounterPosition();
      
      attachChild(woodCountTxt);
      attachChild(woodIcon);
   }
   
   public void setAddWoodCount(long addWoodCount) {
      woodCountTxt.setText( "+" + BigValueFormatter.format(addWoodCount));
      
      updateCounterPosition();
   }
   
   private void updateCounterPosition() {
      woodCountTxt.setX((getWidth() - woodCountTxt.getWidth() - 23) / 2);
      woodCountTxt.setY(65);
      
      woodIcon.setWidth(40);
      woodIcon.setHeight(40);
      woodIcon.setX(woodCountTxt.getX() + woodCountTxt.getWidth() + 6);
      woodIcon.setY(65);
   }

}
