package ru.majestic.thetown.game.workers.food;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AFoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class FoodWorkerRank3 extends AFoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_FOOD_WORKER_RANK_3";
   
   public FoodWorkerRank3() {
      super("Food R.3", 467, 100, 100, 100);
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
