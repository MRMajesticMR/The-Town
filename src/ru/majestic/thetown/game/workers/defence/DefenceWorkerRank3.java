package ru.majestic.thetown.game.workers.defence;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class DefenceWorkerRank3 extends ADefenceWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_DEFENCE_WORKER_RANK_3";
   
   public DefenceWorkerRank3() {
      super("Defender R.3", 1000, 100, 100, 100);
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
