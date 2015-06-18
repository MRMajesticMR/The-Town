package ru.majestic.thetown.game.workers.food;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AFoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class FoodWorkerRank5 extends AFoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_FOOD_WORKER_RANK_5";
   
   public FoodWorkerRank5() {
      super("Food R.5", 91045, 10000, 10000, 10000);
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
