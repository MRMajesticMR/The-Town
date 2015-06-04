package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
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
   private ITextureRegion  homeIconTextureRegion;
   
   private BitmapTextureAtlas    plusBtnTextureAtlas;
   
   private ITiledTextureRegion   plusBtnTextureRegion;
   
   private BitmapTextureAtlas    buildingShopPanelIconsTextureAtlas;
   
   private ITextureRegion        expIconTextureRegion;
   private ITiledTextureRegion   buyBtnTextureRegion;
   
   private BitmapTextureAtlas shopTitleFontTextureAtlas;
   private BitmapTextureAtlas countersFontTextureAtlas;
   private BitmapTextureAtlas countersPerSecondsFontTextureAtlas;
   private BitmapTextureAtlas menuFontTextureAtlas;
   private BitmapTextureAtlas shopTextFontTextureAtlas;
   
   private BitmapTextureAtlas shopBuildingsTitleFontTextureAtlas;
   private BitmapTextureAtlas shopBuildingsTextFontTextureAtlas;
   
   private Font               shopTitleFont;
   private Font               countersFont;
   private Font               countersPerSecondsFont;
   private Font               menuButtonsFont;
   private Font               shopTextFont;
   
   private Font               shopBuildingsTitleFont;
   private Font               shopBuildingsTextFont;
   
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
      homeIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/home_icon.png", 128, 128);
      
      plusBtnTextureAtlas        = new BitmapTextureAtlas(engine.getTextureManager(), 128, 64);
      
      plusBtnTextureRegion       = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(plusBtnTextureAtlas, context, "gfx/buttons/plus_btn.png", 0, 0, 2, 1);
      
      buildingShopPanelIconsTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256);
      
      buyBtnTextureRegion                 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(buildingShopPanelIconsTextureAtlas, context, "gfx/buttons/buy_btn.png", 0, 0, 2, 1);
      expIconTextureRegion                = BitmapTextureAtlasTextureRegionFactory.createFromAsset(buildingShopPanelIconsTextureAtlas, context, "gfx/exp_icon.png", 128, 0);
      
      clickersBitmapTextureAtlas.load();
      iconsBitmapTextureAtlas.load();
      plusBtnTextureAtlas.load();
      buildingShopPanelIconsTextureAtlas.load();
      
      loadFonts();
   }
   
   private void loadFonts() {
      shopTitleFontTextureAtlas           = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      countersFontTextureAtlas            = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      countersPerSecondsFontTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      menuFontTextureAtlas                = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopTextFontTextureAtlas            = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopBuildingsTitleFontTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopBuildingsTextFontTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      shopTitleFont           = new Font(engine.getFontManager(), shopTitleFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 26, true, Color.BLACK);
      countersFont            = new Font(engine.getFontManager(), countersFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 26, true, Color.BLACK);
      countersPerSecondsFont  = new Font(engine.getFontManager(), countersPerSecondsFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 16, true, Color.BLACK);
      menuButtonsFont         = new Font(engine.getFontManager(), menuFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 26, true, Color.BLACK);
      shopTextFont            = new Font(engine.getFontManager(), shopTextFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 20, true, Color.BLACK);
      shopBuildingsTitleFont  = new Font(engine.getFontManager(), shopBuildingsTitleFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 24, true, Color.BLACK);
      shopBuildingsTextFont   = new Font(engine.getFontManager(), shopBuildingsTextFontTextureAtlas, Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 20, true, Color.BLACK);
      
      engine.getTextureManager().loadTexture(shopTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersPerSecondsFontTextureAtlas);
      engine.getTextureManager().loadTexture(menuFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopTextFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopBuildingsTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopBuildingsTextFontTextureAtlas);
            
      engine.getFontManager().loadFont(shopTitleFont);
      engine.getFontManager().loadFont(countersFont);
      engine.getFontManager().loadFont(countersPerSecondsFont);      
      engine.getFontManager().loadFont(menuButtonsFont);
      engine.getFontManager().loadFont(shopTextFont);
      engine.getFontManager().loadFont(shopBuildingsTitleFont);
      engine.getFontManager().loadFont(shopBuildingsTextFont);
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

   public Font getCountersPerSecondsFont() {
      return countersPerSecondsFont;
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

   public ITiledTextureRegion getPlusBtnTextureRegion() {
      return plusBtnTextureRegion;
   }

   public ITextureRegion getHomeIconTextureRegion() {
      return homeIconTextureRegion;
   }

   public Font getShopBuildingsTitleFont() {
      return shopBuildingsTitleFont;
   }

   public ITextureRegion getExpIconTextureRegion() {
      return expIconTextureRegion;
   }

   public Font getShopBuildingsTextFont() {
      return shopBuildingsTextFont;
   }

   public ITiledTextureRegion getBuyBtnTextureRegion() {
      return buyBtnTextureRegion;
   }   
   
   
   
}
