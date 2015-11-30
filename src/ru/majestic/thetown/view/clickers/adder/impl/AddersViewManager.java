package ru.majestic.thetown.view.clickers.adder.impl;

import java.math.BigInteger;

import org.andengine.entity.Entity;

import ru.majestic.thetown.view.clickers.adder.IAddersViewManager;
import ru.majestic.thetown.view.clickers.adder.IClickersAdderView;

public class AddersViewManager implements IAddersViewManager {

   private static final int ADDERS_BUFFER_SIZE = 10;
   
   private static final int ADDER_TYPE_WOOD = 0;
   private static final int ADDER_TYPE_FOOD = 1;
   private static final int ADDER_TYPE_GOLD = 2;   
   
   private IClickersAdderView[][] addersViews;      
   
   public AddersViewManager() {
      addersViews = new IClickersAdderView[3][10];
      
      for(int i = 0; i < ADDERS_BUFFER_SIZE; i++) {
         addersViews[ADDER_TYPE_WOOD][i] = new WoodAdderView();
         addersViews[ADDER_TYPE_FOOD][i] = new FoodAdderView();
         addersViews[ADDER_TYPE_GOLD][i] = new GoldAdderView();
      }
   }
   
   @Override
   public void showAdder(float x, float y, BigInteger value, AdderType adderType) {
      int type = -1;
      
      switch(adderType) {
      case WOOD:
         type = ADDER_TYPE_WOOD;
         break;
         
      case FOOD:
         type = ADDER_TYPE_FOOD;
         break;
         
      case GOLD:
         type = ADDER_TYPE_GOLD;
         break;
      }
      
      IClickersAdderView adderView = getAdderFromInvisible(type);      
      
      if(adderView != null) {
         adderView.setValue(value);
         adderView.show(x, y);
      }
   }
   
   private IClickersAdderView getAdderFromInvisible(int adderType) {
      for(IClickersAdderView adder: addersViews[adderType]) {
         if(!adder.isVisible())
            return adder; 
      }
      
      return null;
   }

   @Override
   public void attachAdders(Entity parentLayer) {
      for(int i = 0; i < ADDERS_BUFFER_SIZE; i++) {         
         addersViews[ADDER_TYPE_WOOD][i].attachToParent(parentLayer);
         addersViews[ADDER_TYPE_FOOD][i].attachToParent(parentLayer);
         addersViews[ADDER_TYPE_GOLD][i].attachToParent(parentLayer);
      }
   }

}
