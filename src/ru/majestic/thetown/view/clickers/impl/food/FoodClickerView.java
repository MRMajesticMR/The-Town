package ru.majestic.thetown.view.clickers.impl.food;

import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;

public class FoodClickerView extends AClickerViewSkeleton {

   static final int X = 0;
   static final int Y = 560;        
   
   static final float WIDTH    = 200.0f;
   static final float HEIGHT   = 210.0f;
   
   static final float FARM_WIDTH    = 100;
   static final float FARM_HEIGHT   = FARM_WIDTH * 0.66f;   
   
   static final float COW_BROWN_WIDTH    = 40;
   static final float COW_BROWN_HEIGHT   = COW_BROWN_WIDTH * 0.74f;
   
   static final float COW_BROWN_NEAREST_WIDTH    = 60;
   static final float COW_BROWN_NEAREST_HEIGHT   = COW_BROWN_NEAREST_WIDTH * 0.74f;
   
   static final float CHICKEN_WIDTH    = 20;
   static final float CHICKEN_HEIGHT   = CHICKEN_WIDTH * 1.04f;
      
   
   static final float SHEEP_WIDTH    = 40;
   static final float SHEEP_HEIGHT   = SHEEP_WIDTH * 0.81f;
   
   Sprite                  farmPic;
   
   FoodClickerAnimalView   brownCow;
   FoodClickerAnimalView   brownCowNearest;
   
   FoodClickerAnimalView   sheepFar;
   FoodClickerAnimalView   sheepNear;
   
   FoodClickerAnimalView   chickenFar;
   FoodClickerAnimalView   chickenMid;
   FoodClickerAnimalView   chickenNear;
   
   public FoodClickerView() {
      super(X, Y, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      farmPic = new Sprite(5, 0, FARM_WIDTH, FARM_HEIGHT, ResourceManager.getInstance().getFoodClickerFarmTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      brownCow          = new FoodClickerAnimalView(80, 65, COW_BROWN_WIDTH, COW_BROWN_HEIGHT, ResourceManager.getInstance().getFoodClickerCowBrownTexture(), 30, true);           
      brownCowNearest   = new FoodClickerAnimalView(5, 130, COW_BROWN_NEAREST_WIDTH, COW_BROWN_NEAREST_HEIGHT, ResourceManager.getInstance().getFoodClickerCowBrownTexture(), 60, false);
      
      sheepFar          = new FoodClickerAnimalView(5, 85, SHEEP_WIDTH, SHEEP_HEIGHT, ResourceManager.getInstance().getFoodCliclerSheepTexture(), 44, false);
      sheepNear         = new FoodClickerAnimalView(100, 120, SHEEP_WIDTH * 1.2f, SHEEP_HEIGHT * 1.2f, ResourceManager.getInstance().getFoodCliclerSheepTexture(), 40, false);      
      
      chickenFar        = new FoodClickerAnimalView(130, 75, CHICKEN_WIDTH, CHICKEN_HEIGHT, ResourceManager.getInstance().getFoodClickerChickenTexture(), 40, true);
      chickenMid        = new FoodClickerAnimalView(15, 100, CHICKEN_WIDTH * 1.1f, CHICKEN_HEIGHT * 1.1f, ResourceManager.getInstance().getFoodClickerChickenTexture(), 70, false);
      chickenNear       = new FoodClickerAnimalView(70, 110, CHICKEN_WIDTH * 1.1f, CHICKEN_HEIGHT * 1.1f, ResourceManager.getInstance().getFoodClickerChickenTexture(), 50, false);
      
      attachChild(farmPic);
      attachChild(brownCow);
      attachChild(sheepFar);      
      attachChild(chickenFar);
      attachChild(chickenMid);
      attachChild(chickenNear);
      attachChild(sheepNear);
      attachChild(brownCowNearest);
   }   

}
