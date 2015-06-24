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
   
   private SoundsManager soundsManager;
   
   private BitmapTextureAtlas clickersBitmapTextureAtlas;
   
   private ITextureRegion  foodClickerBgndTextureRegion;
   private ITextureRegion  woodClickerBgndTextureRegion;
   
   private BitmapTextureAtlas    iconsBitmapTextureAtlas;   
   private ITextureRegion        foodIconTextureRegion;
   private ITextureRegion        woodIconTextureRegion;
   private ITextureRegion        goldIconTextureRegion;
   private ITextureRegion        homeIconTextureRegion;
   private ITextureRegion        swordsIconTextureRegion;
   private ITextureRegion        shiledIconTextureRegion;
   private ITiledTextureRegion   soundIconTextureRegion;
   
   private BitmapTextureAtlas buttonsBitmapTextureAtlas;
   
   private ITextureRegion  menuButtonTextureRegion;
   
   
   private BitmapTextureAtlas    buildingShopPanelIconsTextureAtlas;
   
   private ITextureRegion        expIconTextureRegion;
   private ITiledTextureRegion   buyBtnTextureRegion;
   
   private BitmapTextureAtlas    shopBitmapTextureAtlas;
   private ITextureRegion        shopBackgroundTextureRegion;
   private ITextureRegion        shopItemBackgroundTextureRegion;
   private ITextureRegion        shopResPanelBackgroundTextureRegion;
   private ITiledTextureRegion   closeBtnTextureRegion;
   
   private BitmapTextureAtlas    clickersShopTextureAtals;
   private ITextureRegion        clickersUpgraderBackgroundTextureRegion;
   private ITiledTextureRegion   upgBtnTextureRegion;
   
   private BitmapTextureAtlas    workersShopTextureAtals;
   private ITextureRegion        workersTypeBtnBgndTextureRegion;
   private ITextureRegion        workerWoodTextureRegion;
   private ITextureRegion        workerFoodTextureRegion;
   private ITextureRegion        workerDefenceTextureRegion;
   
   private BitmapTextureAtlas    marketShopTextureAtals;
   private ITextureRegion        marketShopItemBackgroundTextureRegion;
   
   private BitmapTextureAtlas    attackTextureAtals;
   private ITiledTextureRegion   closeButtonTextureRegion;
   private ITextureRegion        attackDialogBgndTextureRegion;
   
   private BitmapTextureAtlas shopTitleFontTextureAtlas;
   private ITexture           countersFontTextureAtlas;
   private BitmapTextureAtlas countersPerSecondsFontTextureAtlas;
   private BitmapTextureAtlas menuFontTextureAtlas;
   private BitmapTextureAtlas shopTextFontTextureAtlas;
   private BitmapTextureAtlas townLvlFontTextureAtlas;
   private BitmapTextureAtlas addersFontTextureAtlas;
   
   private BitmapTextureAtlas shopBuildingsTitleFontTextureAtlas;
   private BitmapTextureAtlas shopBuildingsTextFontTextureAtlas;
   
   private BitmapTextureAtlas attackResultTitleFontTextureAtlas;
   private BitmapTextureAtlas attackResultFontTextureAtlas;
   
   private BitmapTextureAtlas billingResultFontTextureAtlas;
   
   private BitmapTextureAtlas errorFontTextureAtlas;
   
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
   
   private Font               attackResultTitleTextFont;
   private Font               attackResultTextFont;
   
   private Font               billingResultTextFont;
   
   private Font               errorTextFont;
   
   private ResourceManager() {
      
   }
   
   public static ResourceManager getInstance() {
      if(instance == null)
         instance = new ResourceManager();
      return instance;
   }
   
   public void loadResources(Context context, Engine engine) {
      this.engine = engine;
      
      soundsManager = new SoundsManager(engine.getSoundManager(), context);
      
      clickersBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 512);      
      
      foodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker.png", 0, 0);
      woodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/wood_clicker.png", 512, 0);
      
      buttonsBitmapTextureAtlas     = new BitmapTextureAtlas(engine.getTextureManager(), 512, 256);
      
      menuButtonTextureRegion       = BitmapTextureAtlasTextureRegionFactory.createFromAsset(buttonsBitmapTextureAtlas, context, "gfx/buttons/menu_button_background.png", 0, 0);
      
      iconsBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 512, 256);      
      foodIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/food_icon.png", 0, 0);
      woodIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/wood_icon.png", 128, 0);
      goldIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/gold_icon.png", 0, 128);
      homeIconTextureRegion      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/home_icon.png", 128, 128);
      swordsIconTextureRegion    = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/swords_icon.png", 256, 0);
      shiledIconTextureRegion    = BitmapTextureAtlasTextureRegionFactory.createFromAsset(iconsBitmapTextureAtlas, context, "gfx/shield_icon.png", 384, 0);
      soundIconTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(iconsBitmapTextureAtlas, context, "gfx/icons/sound_icon.png", 256, 128, 2, 1);
      
      buildingShopPanelIconsTextureAtlas  = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      buyBtnTextureRegion                 = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(buildingShopPanelIconsTextureAtlas, context, "gfx/buttons/buy_btn.png", 0, 0, 2, 1);
      expIconTextureRegion                = BitmapTextureAtlasTextureRegionFactory.createFromAsset(buildingShopPanelIconsTextureAtlas, context, "gfx/exp_icon.png", 0, 128);
      
      shopBitmapTextureAtlas              = new BitmapTextureAtlas(engine.getTextureManager(), 2048, 2048);
      shopBackgroundTextureRegion         = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_background.png", 0, 0);
      shopItemBackgroundTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_item_background.png", 1024, 0);
      shopResPanelBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_res_panel_background.png", 1024, 200);
      closeBtnTextureRegion               = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(shopBitmapTextureAtlas, context, "gfx/buttons/close_dialog_btn.png", 1024, 400, 2, 1);
      
      
      clickersShopTextureAtals                  = new BitmapTextureAtlas(engine.getTextureManager(), 512, 512);
      clickersUpgraderBackgroundTextureRegion   = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/clickers/clickers_upgrader_background.png", 0, 0);
      upgBtnTextureRegion                       = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(clickersShopTextureAtals, context, "gfx/shops/clickers/upg_btn.png", 0, 256, 2, 1);
      
      workersShopTextureAtals                   = new BitmapTextureAtlas(engine.getTextureManager(), 512, 512);
      workersTypeBtnBgndTextureRegion           = BitmapTextureAtlasTextureRegionFactory.createFromAsset(workersShopTextureAtals, context, "gfx/shops/workers/workers_type_btn_bgnd.png", 0, 0);
      workerWoodTextureRegion                   = BitmapTextureAtlasTextureRegionFactory.createFromAsset(workersShopTextureAtals, context, "gfx/shops/workers/worker_wood_icon.png", 0, 256);
      workerFoodTextureRegion                   = BitmapTextureAtlasTextureRegionFactory.createFromAsset(workersShopTextureAtals, context, "gfx/shops/workers/worker_food_icon.png", 128, 256);
      workerDefenceTextureRegion                = BitmapTextureAtlasTextureRegionFactory.createFromAsset(workersShopTextureAtals, context, "gfx/shops/workers/worker_defence_icon.png", 128, 384);
      
      marketShopTextureAtals                    = new BitmapTextureAtlas(engine.getTextureManager(), 512, 256);
      marketShopItemBackgroundTextureRegion     = BitmapTextureAtlasTextureRegionFactory.createFromAsset(marketShopTextureAtals, context, "gfx/shops/market/market_item_background.png", 0, 0);
      
      attackTextureAtals                        = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024);
      closeButtonTextureRegion                  = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(attackTextureAtals, context, "gfx/attack/close_btn.png", 0, 0, 2, 1);
      attackDialogBgndTextureRegion             = BitmapTextureAtlasTextureRegionFactory.createFromAsset(attackTextureAtals, context, "gfx/attack/attack_dialog_background.png", 0, 64);
      
      clickersBitmapTextureAtlas.load();
      buttonsBitmapTextureAtlas.load();
      iconsBitmapTextureAtlas.load();
      buildingShopPanelIconsTextureAtlas.load();  
      shopBitmapTextureAtlas.load();
      clickersShopTextureAtals.load();
      workersShopTextureAtals.load();
      marketShopTextureAtals.load();
      attackTextureAtals.load();
      
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
      attackResultTitleFontTextureAtlas   = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      attackResultFontTextureAtlas        = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      billingResultFontTextureAtlas       = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      errorFontTextureAtlas               = new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);      
      
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
      attackResultTitleTextFont = FontFactory.createFromAsset(engine.getFontManager(), attackResultTitleFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 28, true, fontsColor);
      attackResultTextFont    = FontFactory.createFromAsset(engine.getFontManager(), attackResultFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 18, true, fontsColor);
      billingResultTextFont   = FontFactory.createFromAsset(engine.getFontManager(), billingResultFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 22, true, fontsColor);
      errorTextFont           = FontFactory.createFromAsset(engine.getFontManager(), errorFontTextureAtlas, context.getAssets(), "fonts/main.ttf", 32, true, Color.parseColor("#FF0000"));            
      
      engine.getTextureManager().loadTexture(shopTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersFontTextureAtlas);
      engine.getTextureManager().loadTexture(countersPerSecondsFontTextureAtlas);
      engine.getTextureManager().loadTexture(menuFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopTextFontTextureAtlas);
      engine.getTextureManager().loadTexture(townLvlFontTextureAtlas);
      engine.getTextureManager().loadTexture(addersFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopBuildingsTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(shopBuildingsTextFontTextureAtlas);
      engine.getTextureManager().loadTexture(attackResultTitleFontTextureAtlas);
      engine.getTextureManager().loadTexture(attackResultFontTextureAtlas);
      engine.getTextureManager().loadTexture(billingResultFontTextureAtlas);      
      engine.getTextureManager().loadTexture(errorFontTextureAtlas);
      
      engine.getFontManager().loadFont(shopTitleFont);
      engine.getFontManager().loadFont(countersFont);
      engine.getFontManager().loadFont(countersPerSecondsFont);      
      engine.getFontManager().loadFont(menuButtonsFont);
      engine.getFontManager().loadFont(shopTextFont);
      engine.getFontManager().loadFont(townLvlFont);
      engine.getFontManager().loadFont(addersFont);      
      engine.getFontManager().loadFont(shopBuildingsTitleFont);
      engine.getFontManager().loadFont(shopBuildingsTextFont);
      engine.getFontManager().loadFont(attackResultTitleTextFont);
      engine.getFontManager().loadFont(attackResultTextFont);
      engine.getFontManager().loadFont(billingResultTextFont);
      engine.getFontManager().loadFont(errorTextFont);           
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
   
   public SoundsManager getSoundsManager() {
      return soundsManager;
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

   public ITiledTextureRegion getUpgBtnTextureRegion() {
      return upgBtnTextureRegion;
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
   
   public ITextureRegion getShiledIconTextureRegion() {
      return shiledIconTextureRegion;
   }

   public ITextureRegion getShopBackgroundTextureRegion() {
      return shopBackgroundTextureRegion;
   }

   public ITextureRegion getShopItemBackgroundTextureRegion() {
      return shopItemBackgroundTextureRegion;
   }

   public Font getAttackResultTitleTextFont() {
      return attackResultTitleTextFont;
   }

   public Font getErrorTextFont() {
      return errorTextFont;
   }

   public ITextureRegion getShopResPanelBackgroundTextureRegion() {
      return shopResPanelBackgroundTextureRegion;
   }

   public ITiledTextureRegion getCloseBtnTextureRegion() {
      return closeBtnTextureRegion;
   }

   public ITextureRegion getClickersUpgraderBackgroundTextureRegion() {
      return clickersUpgraderBackgroundTextureRegion;
   }

   public ITextureRegion getWorkersTypeBtnBgndTextureRegion() {
      return workersTypeBtnBgndTextureRegion;
   }

   public ITextureRegion getWorkerWoodTextureRegion() {
      return workerWoodTextureRegion;
   }

   public ITextureRegion getWorkerFoodTextureRegion() {
      return workerFoodTextureRegion;
   }

   public ITextureRegion getWorkerDefenceTextureRegion() {
      return workerDefenceTextureRegion;
   }

   public ITiledTextureRegion getCloseButtonTextureRegion() {
      return closeButtonTextureRegion;
   }

   public ITextureRegion getAttackDialogBgndTextureRegion() {
      return attackDialogBgndTextureRegion;
   }

   public ITiledTextureRegion getSoundIconTextureRegion() {
      return soundIconTextureRegion;
   }

   public Font getAttackResultTextFont() {
      return attackResultTextFont;
   }

   public Font getBillingResultTextFont() {
      return billingResultTextFont;
   }

   public ITextureRegion getMarketShopItemBackgroundTextureRegion() {
      return marketShopItemBackgroundTextureRegion;
   }
   
   
              
}
