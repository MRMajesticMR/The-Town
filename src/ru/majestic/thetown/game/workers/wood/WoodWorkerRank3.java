package ru.majestic.thetown.game.workers.wood;

import java.math.BigInteger;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.AWoodWorker;
import ru.majestic.thetown.resources.ResourceManager;

public class WoodWorkerRank3 extends AWoodWorker {

   private static final String SAVE_TAG_CURRENT_COUNT = "SAVE_TAG_CURRENT_COUNT_WOOD_WORKER_RANK_3";
   
   public WoodWorkerRank3() {
      super("Wood R.3", new BigInteger("100"), new BigInteger("100"), new BigInteger("100"));
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
