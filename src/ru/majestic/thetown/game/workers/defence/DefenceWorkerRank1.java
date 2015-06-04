package ru.majestic.thetown.game.workers.defence;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class DefenceWorkerRank1 extends ADefenceWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_DEFENCE_WORKER_RANK_1";
   
   public DefenceWorkerRank1() {
      super("Defender R.1", 10, 1, 1, 1);
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
