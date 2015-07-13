package ru.majestic.thetown.resources.dialogs.impl;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.dialogs.IDialogsResourceManager;
import ru.majestic.thetown.resources.dialogs.bonus.IBonusRewardDialogsResourceManager;
import ru.majestic.thetown.resources.dialogs.bonus.impl.BonusRewardDialogsResourceManager;
import android.content.Context;

public class DialogsResourceManager implements IDialogsResourceManager {

   private BitmapTextureAtlas    bitmapTextureAtlas;   
   
   private ITextureRegion        dialogsBackgroundTexture;
   private ITiledTextureRegion   closeDialogButtonTexture;
   
   private IBonusRewardDialogsResourceManager bonusRewardDialogsResourceManager;
   
   @Override
   public void load(Context context, Engine engine) {
      bitmapTextureAtlas                  = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024);      
      
      dialogsBackgroundTexture   = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas, context, "gfx/dialogs/dialogs_background.png", 0, 0);
      closeDialogButtonTexture   = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(bitmapTextureAtlas, context, "gfx/dialogs/close_btn.png", 0, 700, 2, 1);      
      
      bitmapTextureAtlas.load();                
      
      bonusRewardDialogsResourceManager = new BonusRewardDialogsResourceManager();
      bonusRewardDialogsResourceManager.load(context, engine);
   }

   @Override
   public void unload() {      
      bitmapTextureAtlas.unload();
      
      bonusRewardDialogsResourceManager.unload();
   }

   @Override
   public ITextureRegion getDialogBackground() {
      return dialogsBackgroundTexture;
   }

   @Override
   public ITiledTextureRegion getCloseButtonTexture() {
      return closeDialogButtonTexture;
   }

   @Override
   public IBonusRewardDialogsResourceManager getBonusRewardDialogsResourceManager() {
      return bonusRewardDialogsResourceManager;
   }   

}
