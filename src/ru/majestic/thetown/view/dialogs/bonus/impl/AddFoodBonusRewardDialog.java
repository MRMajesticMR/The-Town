package ru.majestic.thetown.view.dialogs.bonus.impl;

import java.math.BigInteger;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.dialogs.bonus.ABonusRewardDialog;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class AddFoodBonusRewardDialog extends ABonusRewardDialog {

   private final Text      foodCountTxt;
   private final Sprite    foodIcon;
   
   public AddFoodBonusRewardDialog(Scene scene) {
      super(scene);
      
      foodCountTxt      = new Text(0, 0, FontsManager.getInstance().getFont(28), "+100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      foodIcon          = new Sprite(0, 0, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      updateCounterPosition();
      
      attachChild(foodCountTxt);
      attachChild(foodIcon);
   }
   
   public void setAddFoodCount(BigInteger addFoodCount) {
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
