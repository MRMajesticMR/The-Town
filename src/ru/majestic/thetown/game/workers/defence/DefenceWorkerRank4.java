package ru.majestic.thetown.game.workers.defence;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.ADefenceWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class DefenceWorkerRank4 extends ADefenceWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_DEFENCE_WORKER_RANK_4";
   
   public DefenceWorkerRank4() {
      super("Defender R.4", new BigInteger("1000"), new BigInteger("1000"), new BigInteger("1000"));
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
