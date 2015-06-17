package ru.majestic.thetown.view.errors.impl;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.errors.IErrorView;

public class ErrorViewManager {

   private static final List<IErrorView> errorViews = new ArrayList<IErrorView>();
   
   public static void showError(Scene scene, String message) {
      IErrorView errorView = getInvisibleErrorView();
      
      if(errorView == null) {
         errorView = new ErrorView();
         errorView.attachToParent(scene);
         
         errorViews.add(errorView);         
      }            
      
      errorView.show(message);      
   }
   
   private static IErrorView getInvisibleErrorView() {
      for(IErrorView errorView: errorViews) {
         if(!errorView.isVisible())
            return errorView;
      }
      
      return null;
   }
   
}
