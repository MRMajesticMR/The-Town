package ru.majestic.thetown.game.workers.wood;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AWoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class WoodWorkerRank4 extends AWoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_WOOD_WORKER_RANK_4";
   
   public WoodWorkerRank4() {
      super("Wood R.4", new BigInteger("1000"), new BigInteger("1000"), new BigInteger("1000"));
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
