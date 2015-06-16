package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import android.content.Context;
import android.graphics.Color;

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
   private ITextureRegion  swordsIconTextureRegion;
   
   private BitmapTextureAtlas buttonsBitmapTextureAtlas;
   
   private ITextureRegion  menuButtonTextureRegion;
   
   private BitmapTextureAtlas    plusBtnTextureAtlas;
   
   private ITiledTextureRegion   plusBtnTextureRegion;
   
   private BitmapTextureAtlas    buildingShopPanelIconsTextureAtlas;
   
   private ITextureRegion        expIconTextureRegion;
   private ITiledTextureRegion   buyBtnTextureRegion;
   
   private BitmapTextureAtlas    shopBitmapTextureAtlas;
   private ITextureRegion        shopBackgroundTextureRegion;
   private ITextureRegion        shopItemBackgroundTextureRegion;
   
   
   private BitmapTextureAtlas shopTitleFontTextureAtlas;
   private ITexture           countersFontTextureAtlas;
   private BitmapTextureAtlas countersPerSecondsFontTextureAtlas;
   private BitmapTextureAtlas menuFontTextureAtlas;
   private BitmapTextureAtlas shopTextFontTextureAtlas;
   private BitmapTextureAtlas townLvlFontTextureAtlas;
   private BitmapTextureAtlas addersFontTextureAtlas;
   
   private BitmapTextureAtlas shopBuildingsTitleFontTextureAtlas;
   private BitmapTextureAtlas shopBuildingsTextFontTextureAtlas;
   
   private BitmapTextureAtlas frontBackgroundTextureAtlas;
   private BitmapTextureAtlas midBackgroundTextureAtlas;
   
   private ITextureRegion     backgroundMidLayerTextureRegion;
   private ITextureRegion     backgroundFrontLayerTextureRegion;
   
   private Font               shopTitleFont;
   private Font               countersFont;
   private Font               countersPerSecondsFont;
   private Font               menuButtonsFont;
   private Font               shopTextFont;
   private Font               townLvlFont;
   
   private Font               addersFont;
   
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
      
      clickersBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 512, 256);      
      
      foodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker_bgnd.png", 0, 0);
      woodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/wood_clicker.png", 256, 0);
      
      buttonsBitmapTextureAtlas     = new BitmapTextureAtlas(engine.getTextureManager(), 512, 256);
      
      menuButtonTextureRegion       = BitmapTextureAtlasTextureRegionFactory.createFromAsset(buttonsBitmapTextureAtlas, context, "gfx/buttons/menu_button_background.png", 0, 0);
      
      iconsBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 512, 512);
      
      foodIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/food_icon.png", 0, 0);
      woodIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/wood_icon.png", 128, 0);
      goldIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/gold_icon.png", 0, 128);
      homeIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/home_icon.png", 128, 128);
      swordsIconTextureRegion    = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/swords_icon.png", 256, 0);
      
      plusBtnTextureAtlas        = new BitmapTextureAtlas(engine.getTextureManager(), 128, 64);
      
      plusBtnTextureRegion       = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(plusBtnTextureAtlas, context, "gfx/buttons/plus_btn.png", 0, 0, 2, 1);
      
      buildingShopPanelIconsTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      buyBtnTextureRegion                 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(buildingShopPanelIconsTextureAtlas, context, "gfx/buttons/buy_btn.png", 0, 0, 2, 1);
      expIconTextureRegion                = BitmapTextureAtlasTextureRegionFactory.createFromAsset(buildingShopPanelIconsTextureAtlas, context, "gfx/exp_icon.png", 128, 0);
      
      shopBitmapTextureAtlas              = new BitmapTextureAtlas(engine.getTextureManager(), 2048, 2048);
      shopBackgroundTextureRegion         = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_background.png", 0, 0);
      shopItemBackgroundTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_item_background.png", 1024, 0);
      
      clickersBitmapTextureAtlas.load();
      buttonsBitmapTextureAtlas.load();
      iconsBitmapTextureAtlas.load();
      plusBtnTextureAtlas.load();
      buildingShopPanelIconsTextureAtlas.load();  
      shopBitmapTextureAtlas.load();
      
      loadFonts(context);
      loadBackground(context);
   }
   
   private void loadFonts(Context context) {
      shopTitleFontTextureAtlas           = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      countersFontTextureAtlas            = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      countersPerSecondsFontTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      menuFontTextureAtlas                = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopTextFontTextureAtlas            = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      townLvlFontTextureAtlas             = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      addersFontTextureAtlas              = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopBuildingsTitleFontTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      shopBuildingsTextFontTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);            
      
      int fontsColor = Color.parseColor("#000000");
      
      shopTitleFont           = FontFactory.createFromAsset(engine.getFontManager(), shopTitleFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 20, true, fontsColor);
      countersFont            = FontFactory.createFromAsset(engine.getFontManager(), countersFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 16, true, fontsColor);
      countersPerSecondsFont  = FontFactory.createFromAsset(engine.getFontManager(), countersPerSecondsFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 12, true, fontsColor);
      menuButtonsFont         = FontFactory.createFromAsset(engine.getFontManager(), menuFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 18, true, fontsColor);
      shopTextFont            = FontFactory.createFromAsset(engine.getFontManager(), shopTextFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 12, true, fontsColor);
      townLvlFont             = FontFactory.createFromAsset(engine.getFontManager(), townLvlFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 12, true, fontsColor);
      addersFont              = FontFactory.createFromAsset(engine.getFontManager(), addersFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 18, true, fontsColor);
      shopBuildingsTitleFont  = FontFactory.createFromAsset(engine.getFontManager(), shopBuildingsTitleFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 20, true, fontsColor);
      shopBuildingsTextFont   = FontFactory.createFromAsset(engine.getFontManager(), shopBuildingsTextFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 20, true, fontsColor);
      
      engine.getTextureManager().loadTexture(shopTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersPerSecondsFontTextureAtlas);
      engine.getTextureManager().loadTexture(menuFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopTextFontTextureAtlas);
      engine.getTextureManager().loadTexture(townLvlFontTextureAtlas);
      engine.getTextureManager().loadTexture(addersFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopBuildingsTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopBuildingsTextFontTextureAtlas);           
            
      engine.getFontManager().loadFont(shopTitleFont);
      engine.getFontManager().loadFont(countersFont);
      engine.getFontManager().loadFont(countersPerSecondsFont);      
      engine.getFontManager().loadFont(menuButtonsFont);
      engine.getFontManager().loadFont(shopTextFont);
      engine.getFontManager().loadFont(townLvlFont);
      engine.getFontManager().loadFont(addersFont);      
      engine.getFontManager().loadFont(shopBuildingsTitleFont);
      engine.getFontManager().loadFont(shopBuildingsTextFont);
   }
   
   private void loadBackground(Context context) {
      midBackgroundTextureAtlas     = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);
      frontBackgroundTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      backgroundMidLayerTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createFromAsset(midBackgroundTextureAtlas, context, "gfx/environment/clouds/light_day.png", 0, 0);
      backgroundFrontLayerTextureRegion   = BitmapTextureAtlasTextureRegionFactory.createFromAsset(frontBackgroundTextureAtlas, context, "gfx/environment/midground.png", 0, 0);
      
      midBackgroundTextureAtlas.load();
      frontBackgroundTextureAtlas.load();
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

   public Font getTownLvlFont() {
      return townLvlFont;
   }

   public ITextureRegion getSwordsIconTextureRegion() {
      return swordsIconTextureRegion;
   }

   public ITextureRegion getBackgroundMidLayerTextureRegion() {
      return backgroundMidLayerTextureRegion;
   }

   public ITextureRegion getBackgroundFrontLayerTextureRegion() {
      return backgroundFrontLayerTextureRegion;
   }

   public Font getAddersFont() {
      return addersFont;
   }

   public ITextureRegion getMenuButtonTextureRegion() {
      return menuButtonTextureRegion;
   }

   public ITextureRegion getShopBackgroundTextureRegion() {
      return shopBackgroundTextureRegion;
   }

   public ITextureRegion getShopItemBackgroundTextureRegion() {
      return shopItemBackgroundTextureRegion;
   }        
   
}
