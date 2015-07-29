package ru.majestic.thetown.resources.bonuses.impl;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.bonuses.IBonusesResourcesManager;
import android.content.Context;

public class BonusesResourcesManager implements IBonusesResourcesManager {

   private BitmapTextureAtlas bonusesTextureAtlas;
   
   private ITextureRegion        planeTextureRegion;
   private ITiledTextureRegion   cargoTextureRegion;
   
   @Override
   public void load(Context context, Engine engine) {
      bonusesTextureAtlas = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 128);
      
      planeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bonusesTextureAtlas, context, "gfx/bonuses/plane.png", 0, 0);
      cargoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bonusesTextureAtlas, context, "gfx/bonuses/cargo.png", 128, 0, 5, 1);
      
      bonusesTextureAtlas.load();
   }

   @Override
   public void unload() {
      bonusesTextureAtlas.unload();
   }

   @Override
   public ITextureRegion getPlaneTextureRegion() {
      return planeTextureRegion;
   }

   @Override
   public ITiledTextureRegion getCargoTextureRegion() {
      return cargoTextureRegion;
   }

}
