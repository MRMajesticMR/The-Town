package ru.majestic.thetown.view.bonuses.handler;

import java.util.Random;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.bonuses.IBonusesViewHandler;
import ru.majestic.thetown.view.bonuses.IPlaneView;
import ru.majestic.thetown.view.bonuses.impl.PlaneView;
import ru.majestic.thetown.view.bonuses.listeners.OnPlaneOutOfViewListener;

public class BonusesViewHandler implements IBonusesViewHandler,
                                           OnPlaneOutOfViewListener,
                                           Runnable {

   private static final int PERIOD = 10000;
   
   private final Scene  scene;
   
   private IPlaneView planeView;
   private boolean working;
   
   public BonusesViewHandler(Scene scene, Entity parentLayer) {
      this.scene        = scene;
      
      planeView = new PlaneView();      
      planeView.setOnPlaneOutOfViewListener(this);      
      planeView.attachToParent(parentLayer);
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
      planeView.setY(new Random(System.currentTimeMillis()).nextInt(200) + 50);
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
   
}
