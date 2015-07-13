package ru.majestic.thetown.view.dialogs.bonus.impl;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.bonus.ABonusRewardDialog;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class AddFoodBonusRewardDialog extends ABonusRewardDialog {

   private final Text      foodCountTxt;
   private final Sprite    foodIcon;
   
   public AddFoodBonusRewardDialog(Scene scene) {
      super(scene);
      
      foodCountTxt      = new Text(0, 0, ResourceManager.getInstance().getDialogsResourceManager().getBonusRewardDialogsResourceManager().getBonusDialogMessageFont(), "+100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      foodIcon          = new Sprite(0, 0, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      updateCounterPosition();
      
      attachChild(foodCountTxt);
      attachChild(foodIcon);
   }
   
   public void setAddFoodCount(long addFoodCount) {
      foodCountTxt.setText( "+" + BigValueFormatter.format(addFoodCount));
      
      updateCounterPosition();
   }
   
   private void updateCounterPosition() {
      foodCountTxt.setX((getWidth() - foodCountTxt.getWidth() - 23) / 2);
      foodCountTxt.setY(65);
      
      foodIcon.setWidth(40);
      foodIcon.setHeight(40);
      foodIcon.setX(foodCountTxt.getX() + foodCountTxt.getWidth() + 6);
      foodIcon.setY(65);
   }

}
