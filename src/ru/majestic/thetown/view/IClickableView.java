package ru.majestic.thetown.view;

import org.andengine.entity.scene.Scene;

public interface IClickableView extends IView {

   public void registerTouchArea    (Scene scene);
   public void unregisterTouchArea  (Scene scene);
   
}
