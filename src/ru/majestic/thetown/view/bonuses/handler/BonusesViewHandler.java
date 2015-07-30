package ru.majestic.thetown.view.bonuses.handler;

import java.util.Random;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.bonuses.IBonusesViewHandler;
import ru.majestic.thetown.view.bonuses.IPlaneView;
import ru.majestic.thetown.view.bonuses.handler.listeners.OnBonusViewLandedListener;
import ru.majestic.thetown.view.bonuses.impl.BonusCargoView;
import ru.majestic.thetown.view.bonuses.impl.PlaneView;
import ru.majestic.thetown.view.bonuses.listeners.OnBonusTouchTheGroundListener;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneClickedListener;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneOutOfViewListener;

public class BonusesViewHandler implements IBonusesViewHandler,
                                           OnPlaneOutOfViewListener,
                                           OnPlaneClickedListener,
                                           OnBonusTouchTheGroundListener,
                                           Runnable {

   static final float GROUND_LEVEL = 430;
   
   static final int PERIOD = 30000;
   
   private final Scene  scene;
   
   private IPlaneView         planeView;
   private BonusCargoView     bonusCargoView;
   
   private boolean         working;
   
   private OnBonusViewLandedListener onBonusDropedListener;
   
   public BonusesViewHandler(Scene scene, Entity parentLayer) {
      this.scene              = scene;
      
      planeView = new PlaneView();      
      planeView.setOnPlaneOutOfViewListener(this);     
      planeView.setOnPlaneClickedListener(this);
      planeView.attachToParent(parentLayer);
      
      bonusCargoView = new BonusCargoView();
      bonusCargoView.setGroundLevel(GROUND_LEVEL);
      bonusCargoView.setOnBonusTouchTheGroundListener(this);
      bonusCargoView.attachToParent(parentLayer);            
   }

   @Override
   public void run() {
      try {
         Thread.sleep(PERIOD);
      } catch (InterruptedException e) {
      }
      
      startPlane();
   }
   
   private void startPlane() {
      planeView.setX(- planeView.getWidth());
      planeView.setY(new Random(System.currentTimeMillis()).nextInt(130) + 70);
      planeView.setBonus();
      planeView.registerTouchArea(scene);
      planeView.unpause();
   }

   @Override
   public void begin() {
      working = true;
      startTimer();
   }

   @Override
   public void end() {
      working = false;
   }
   
   @Override
   public void setOnBonusViewLandedListener(OnBonusViewLandedListener onBonusDropedListener) {
      this.onBonusDropedListener = onBonusDropedListener;
   }

   @Override
   public void onPlaneOutOfView(IPlaneView planeView) {
      planeView.pause();
      planeView.unregisterTouchArea(scene);
      startTimer();
   }
   
   private void startTimer() {
      if(working) {
         new Thread(this).start();
      }
   }

   @Override
   public void onPlaneClicked(IPlaneView planeView) {
      if(planeView.hasBonus()) {
         bonusCargoView.drop(planeView.getX() + (planeView.getWidth() - bonusCargoView.getWidth()) / 2, planeView.getY() + planeView.getHeight());
      }
   }

   @Override
   public void onBonusTouchTheGround() {
      onBonusDropedListener.onBonusViewLandedListener();      
   }   
   
}
