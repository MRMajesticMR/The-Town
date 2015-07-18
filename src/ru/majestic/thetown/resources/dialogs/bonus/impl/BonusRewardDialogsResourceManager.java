package ru.majestic.thetown.resources.dialogs.bonus.impl;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.dialogs.bonus.IBonusRewardDialogsResourceManager;
import android.content.Context;

public class BonusRewardDialogsResourceManager implements IBonusRewardDialogsResourceManager {

   private BitmapTextureAtlas    textureAtlas;   
   
   private ITiledTextureRegion   improveButtonTexture;   
   
   @Override
   public void load(Context context, Engine engine) {
      textureAtlas                        = new BitmapTextureAtlas(engine.getTextureManager(), 512, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);      
      
      improveButtonTexture          = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(textureAtlas, context, "gfx/dialogs/bonus/improve_btn.png", 0, 0, 2, 1);      
      
      textureAtlas.load();          
   }
   @Override
   public void unload() {
      textureAtlas.unload();            
   }
   
   @Override
   public ITiledTextureRegion getImproveButtonTexture() {
      return improveButtonTexture;
   }     
   
}
