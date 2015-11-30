package ru.majestic.thetown.game.workers.wood;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AWoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class WoodWorkerRank5 extends AWoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_WOOD_WORKER_RANK_5";
   
   public WoodWorkerRank5() {
      super("Wood R.5", new BigInteger("10000"), new BigInteger("10000"), new BigInteger("10000"));
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
