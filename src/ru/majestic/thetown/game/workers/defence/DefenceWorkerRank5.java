package ru.majestic.thetown.game.workers.defence;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class DefenceWorkerRank5 extends ADefenceWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_DEFENCE_WORKER_RANK_5";
   
   public DefenceWorkerRank5() {
      super("Defender R.5", 100000, 10000, 10000, 10000);
   }   
   
   @Override
   public ITextureRegion getWorkerImage() {
      return ResourceManager.getInstance().getWorkerDefenceTextureRegion();
   }

   @Override
   protected String getSaveTagForCurrentCount() {
      return SAVE_TAG_CURRENT_COUNT;
   }

}
