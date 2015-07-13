package ru.majestic.thetown.view.dialogs.townlevel.impl;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.town.ITownLevelReward;
import ru.majestic.thetown.game.town.listeners.OnTownNewLevelObtainedListener;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.ADialog;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class TownLevelRewardDialog extends ADialog implements OnTownNewLevelObtainedListener, OnClickListener {

   private static final int MARGIN           = 30;
   private static final int HEIGHT           = 200; 
   private static final int PADDING          = 20;
   
   private final Scene           scene;
   
   private final ButtonSprite    closeBtn;
   private final Text            resultText;
      
   private final Sprite          woodIcon;
   private final Text            woodResultText;
   
   private final Sprite          foodIcon;
   private final Text            foodResultText;
   
   private final Sprite          goldIcon;
   private final Text            goldResultText;
   
   
   public TownLevelRewardDialog(Scene scene) {
      super(MARGIN, 230, TheTownCamera.CAMERA_WIDTH - (MARGIN * 2), HEIGHT, ResourceManager.getInstance().getAttackDialogBgndTextureRegion());
            
      setVisible(false);
      
      this.scene            = scene;
      
      closeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getCloseButtonTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      resultText            = new Text(0, PADDING, ResourceManager.getInstance().getAttackResultTitleTextFont(), "Town level increased!", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      woodIcon              = new Sprite(160, 85, 40, 40, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      woodResultText        = new Text(woodIcon.getX() + woodIcon.getWidth() + 4, woodIcon.getY() + 8, ResourceManager.getInstance().getAttackResultTextFont(), "+100.00TT", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      foodIcon              = new Sprite(PADDING, 85, 40, 40, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      foodResultText        = new Text(foodIcon.getX() + foodIcon.getWidth() + 4, foodIcon.getY() + 8, ResourceManager.getInstance().getAttackResultTextFont(), "+100.00TT", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      goldIcon              = new Sprite(310, 85, 40, 40, ResourceManager.getInstance().getGoldIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      goldResultText        = new Text(goldIcon.getX() + goldIcon.getWidth() + 4, goldIcon.getY() + 8, ResourceManager.getInstance().getAttackResultTextFont(), "+100.00TT", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      closeBtn.setWidth(100);
      closeBtn.setHeight(40);            
      closeBtn.setX((getWidth() - closeBtn.getWidth()) / 2); 
      closeBtn.setY(getHeight() - PADDING - closeBtn.getHeight());
      
      closeBtn.setOnClickListener(this);
      
      resultText.setX((getWidth() - resultText.getWidth()) / 2); 
      
      attachChild(closeBtn);
      attachChild(resultText);
      
      attachChild(woodIcon);
      attachChild(woodResultText);
      
      attachChild(foodIcon);
      attachChild(foodResultText);
      
      attachChild(goldIcon);
      attachChild(goldResultText);
   }   

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {      
      hide();
      
      notifyOnDialogClosedListener();      
   }

   @Override
   public void onTownNewLevelObtained(ITownLevelReward townLevelReward) {
      woodResultText.setText("+" + BigValueFormatter.format(townLevelReward.getWoodReward()));
      foodResultText.setText("+" + BigValueFormatter.format(townLevelReward.getFoodReward()));      
      goldResultText.setText("+" + BigValueFormatter.format(townLevelReward.getGoldReward()));
      
      show();
   }
   
   @Override
   public void show() {
      scene.registerTouchArea(closeBtn);
      setVisible(true);
   }

   @Override
   public void hide() {
      scene.unregisterTouchArea(closeBtn);
      setVisible(false);
   }

}
