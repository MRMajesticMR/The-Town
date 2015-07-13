package ru.majestic.thetown.resources.dialogs.bonus.impl;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import android.content.Context;
import android.graphics.Color;

import ru.majestic.thetown.resources.dialogs.bonus.IBonusRewardDialogsResourceManager;

public class BonusRewardDialogsResourceManager implements IBonusRewardDialogsResourceManager {

   private Engine                engine;
   
   private BitmapTextureAtlas    textureAtlas;   
   private BitmapTextureAtlas    improveNoteFontTextureAtlas;
   private BitmapTextureAtlas    bonusDialogsTitleFontTextureAtlas;
   private BitmapTextureAtlas    bonusDialogsMessageFontTextureAtlas;
   
   private ITiledTextureRegion   improveButtonTexture;   
   private Font                  bonusDialogTitleFont;
   private Font                  improveNoteFont;
   private ITextureRegion        improveBoteTexture;
   private Font                  bonusDialogMessageFont;
   
   @Override
   public void load(Context context, Engine engine) {
      this.engine = engine;
      
      textureAtlas                        = new BitmapTextureAtlas(engine.getTextureManager(), 256, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);      
      improveNoteFontTextureAtlas         = new BitmapTextureAtlas(engine.getTextureManager(), 128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      bonusDialogsTitleFontTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      bonusDialogsMessageFontTextureAtlas = new BitmapTextureAtlas(engine.getTextureManager(), 128, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      improveButtonTexture          = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(textureAtlas, context, "gfx/dialogs/bonus/improve_btn.png", 0, 0, 2, 1);
      improveBoteTexture            = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureAtlas, context, "gfx/dialogs/bonus/improve_note.png", 0, 64);
      
      improveNoteFont               = FontFactory.createFromAsset(engine.getFontManager(), improveNoteFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 16, true, Color.parseColor("#000000"));
      bonusDialogTitleFont          = FontFactory.createFromAsset(engine.getFontManager(), bonusDialogsTitleFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 22, true, Color.parseColor("#000000"));
      bonusDialogMessageFont        = FontFactory.createFromAsset(engine.getFontManager(), bonusDialogsMessageFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 28, true, Color.parseColor("#000000"));
      
      textureAtlas.load();
    
      engine.getTextureManager().loadTexture(bonusDialogsTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(improveNoteFontTextureAtlas);
      engine.getTextureManager().loadTexture(bonusDialogsMessageFontTextureAtlas);
      
      engine.getFontManager().loadFont(bonusDialogTitleFont);
      engine.getFontManager().loadFont(improveNoteFont);
      engine.getFontManager().loadFont(bonusDialogMessageFont);
      
      bonusDialogTitleFont.prepareLetters("You've got bonus!".toCharArray());
      improveNoteFont.prepareLetters("Improve your bonus!".toCharArray());
      bonusDialogMessageFont.prepareLetters("1234567890+.MTAB".toCharArray());
   }
   @Override
   public void unload() {
      textureAtlas.unload();
      
      engine.getTextureManager().unloadTexture(bonusDialogsTitleFontTextureAtlas);
      engine.getTextureManager().unloadTexture(improveNoteFontTextureAtlas);
      engine.getTextureManager().unloadTexture(bonusDialogsMessageFontTextureAtlas);
      
      engine.getFontManager().unloadFont(bonusDialogTitleFont);      
      engine.getFontManager().unloadFont(improveNoteFont);
      engine.getFontManager().unloadFont(bonusDialogMessageFont);
   }
   
   @Override
   public ITiledTextureRegion getImproveButtonTexture() {
      return improveButtonTexture;
   }

   @Override
   public Font getBonusDialogTitleFont() {
      return bonusDialogTitleFont;
   }
   
   @Override
   public ITextureRegion getImproveNoteTexture() {
      return improveBoteTexture;
   }
   
   @Override
   public Font getImproveNoteFont() {
      return improveNoteFont;
   }
   @Override
   public Font getBonusDialogMessageFont() {
      return bonusDialogMessageFont;
   }
   
}
