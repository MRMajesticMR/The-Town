package ru.majestic.thetown.game.workers.defence;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class DefenceWorkerRank2 extends ADefenceWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_DEFENCE_WORKER_RANK_2";
   
   public DefenceWorkerRank2() {
      super("Defender R.2", 100, 10, 10, 10);
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
