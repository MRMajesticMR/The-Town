package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.color.Color;

import android.content.Context;
import android.graphics.Typeface;

public class ResourceManager {

   private static ResourceManager instance;
   
   private Engine engine;
   
   private BitmapTextureAtlas clickersBitmapTextureAtlas;
   
   private ITextureRegion  foodClickerBgndTextureRegion;
   private ITextureRegion  woodClickerBgndTextureRegion;
   
   private BitmapTextureAtlas iconsBitmapTextureAtlas;
   
   private ITextureRegion  foodIconTextureRegion;
   private ITextureRegion  woodIconTextureRegion;
   private ITextureRegion  goldIconTextureRegion;
   
   private BitmapTextureAtlas shopTitleFontTextureAtlas;
   private BitmapTextureAtlas countersFontTextureAtlas;
   private BitmapTextureAtlas menuFontTextureAtlas;
   private BitmapTextureAtlas shopTextFontTextureAtlas;
   
   private Font               shopTitleFont;
   private Font               countersFont;
   private Font               menuButtonsFont;
   private Font               shopTextFont;
   
   private ResourceManager() {
      
   }
   
   public static ResourceManager getInstance() {
      if(instance == null)
         instance = new ResourceManager();
      return instance;
   }
   
   public void loadResources(Context context, Engine engine) {
      this.engine = engine;
      
      clickersBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 256, 128);      
      
      foodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker_bgnd.png", 0, 0);
      woodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/wood_clicker_bgnd.png", 128, 0);
      
      iconsBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256);
      
      foodIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/food_icon.png", 0, 0);
      woodIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/wood_icon.png", 128, 0);
      goldIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/gold_icon.png", 0, 128);
            
      clickersBitmapTextureAtlas.load();
      iconsBitmapTextureAtlas.load();
      
      loadFonts();
   }
   
   private void loadFonts() {
      shopTitleFontTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      countersFontTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      menuFontTextureAtlas       = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopTextFontTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      shopTitleFont     = new Font(engine.getFontManager(), shopTitleFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.BLACK);
      countersFont      = new Font(engine.getFontManager(), countersFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32, true, Color.BLACK);
      menuButtonsFont   = new Font(engine.getFontManager(), menuFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 26, true, Color.BLACK);
      shopTextFont      = new Font(engine.getFontManager(), shopTextFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 22, true, Color.BLACK);
      
      engine.getTextureManager().loadTexture(shopTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersFontTextureAtlas);
      engine.getTextureManager().loadTexture(menuFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopTextFontTextureAtlas);
      
      engine.getFontManager().loadFont(shopTitleFont);
      engine.getFontManager().loadFont(countersFont);
      engine.getFontManager().loadFont(menuButtonsFont);
      engine.getFontManager().loadFont(shopTextFont);
   }
   
   public Engine getEngine() {
      return engine;
   }
   
   public ITextureRegion getFoodClickerBgndTextureRegion() {
      return foodClickerBgndTextureRegion;
   }
   
   public ITextureRegion getWoodClickerBgndTextureRegion() {
      return woodClickerBgndTextureRegion;
   }
   
   public Font getCountersFont() {
      return countersFont;
   }

   public Font getMenuButtonsFont() {
      return menuButtonsFont;
   }

   public Font getShopTitleFont() {
      return shopTitleFont;
   }

   public Font getShopTextFont() {
      return shopTextFont;
   }

   public ITextureRegion getFoodIconTextureRegion() {
      return foodIconTextureRegion;
   }

   public ITextureRegion getWoodIconTextureRegion() {
      return woodIconTextureRegion;
   }

   public ITextureRegion getGoldIconTextureRegion() {
      return goldIconTextureRegion;
   }
   
   
   
}
