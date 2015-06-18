package ru.majestic.thetown.game.workers.food;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AFoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class FoodWorkerRank1 extends AFoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_FOOD_WORKER_RANK_1";
   
   public FoodWorkerRank1() {
      super("Food R.1", 4, 1, 1, 1);
   }   
   
   @Override
   public ITextureRegion getWorkerImage() {
      return ResourceManager.getInstance().getWorkerFoodTextureRegion();
   }

   @Override
   protected String getSaveTagForCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
