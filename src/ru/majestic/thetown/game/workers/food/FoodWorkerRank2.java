package ru.majestic.thetown.game.workers.food;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AFoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class FoodWorkerRank2 extends AFoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_FOOD_WORKER_RANK_2";
   
   public FoodWorkerRank2() {
      super("Food R.2", 100, 10, 10, 10);
   }   
   
   @Override
   public ITextureRegion getWorkerImage() {
      return ResourceManager.getInstance().getHomeIconTextureRegion();
   }

   @Override
   protected String getSaveTagForCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
