package ru.majestic.thetown.view.bonuses.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.bonuses.IBonusCargoView;
import ru.majestic.thetown.view.bonuses.listeners.OnBonusTouchTheGroundListener;

public class BonusCargoView extends Sprite implements IBonusCargoView {

   private static final int WIDTH   = 30;
   private static final int HEIGHT  = 30;   
   
   private static final float SPEED = 2.0f;
   
   private static final float GROUND_LINE = 500;
   
   private OnBonusTouchTheGroundListener onBonusTouchTheGroundListener;
   
   private IGameBonus   gameBonus;
   
   public BonusCargoView() {
      super(0, 0, WIDTH, HEIGHT, ResourceManager.getInstance().getBonusesResourcesManager().getCargoTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      pause();
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void pause() {
      setVisible(false);
      setIgnoreUpdate(true);
   }

   @Override
   public void unpause() {
      setVisible(true);
      setIgnoreUpdate(false);      
   }
   
   @Override
   public void onManagedUpdate(float pSecondsElapsed) {
      setY(getY() + SPEED);
      
      if(getY() + getHeight() >= GROUND_LINE) {
         pause();
         onBonusTouchTheGroundListener.onBonusTouchTheGround(this);
      }
   }

   @Override
   public void setOnBonusTouchTheGroundListener(OnBonusTouchTheGroundListener onBonusTouchTheGroundListener) {
      this.onBonusTouchTheGroundListener = onBonusTouchTheGroundListener;
   }

   @Override
   public void setBonus(IGameBonus gameBonus) {
      this.gameBonus = gameBonus;
   }

   @Override
   public IGameBonus getBonus() {
      return gameBonus;
   }

}
