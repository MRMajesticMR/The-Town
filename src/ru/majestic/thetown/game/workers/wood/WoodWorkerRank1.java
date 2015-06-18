package ru.majestic.thetown.game.workers.wood;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AWoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class WoodWorkerRank1 extends AWoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_WOOD_WORKER_RANK_1";
   
   public WoodWorkerRank1() {
      super("Wood R.1", 4, 1, 1, 1);
   }   
   
   @Override
   public ITextureRegion getWorkerImage() {
      return ResourceManager.getInstance().getWorkerWoodTextureRegion();
   }

   @Override
   protected String getSaveTagForCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
