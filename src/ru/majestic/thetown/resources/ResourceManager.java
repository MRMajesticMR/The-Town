package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.bonuses.IBonusesResourcesManager;
import ru.majestic.thetown.resources.bonuses.impl.BonusesResourcesManager;
import ru.majestic.thetown.resources.dialogs.IDialogsResourceManager;
import ru.majestic.thetown.resources.dialogs.impl.DialogsResourceManager;
import android.content.Context;

public class ResourceManager {

   private static ResourceManager instance;
   
   private Engine engine;
   
   private SoundsManager            soundsManager;
   
   private BitmapTextureAtlas clickersBitmapTextureAtlas;
   
   private ITextureRegion        foodClickerFarmTexture;
   private ITiledTextureRegion   foodClickerCowBrownTexture;
   private ITiledTextureRegion   foodClickerChickenTexture;
   private ITiledTextureRegion   foodClickerSheepTexture;
   
   private ITextureRegion        woodClickerBgndTextureRegion;
   
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
   private ITextureRegion        buyGoldPanelBackgroundTextureRegion;
   private ITextureRegion        billingResultBackgroundTextureRegion;
   
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
   
   private BitmapTextureAtlas rocksTextureAtlas;
   private BitmapTextureAtlas cloudsTextureAtlas;
   
   private ITextureRegion     cloudsTexture;
   private ITextureRegion     rocksTexture;        
   
   private final IBonusesResourcesManager bonusesResourcesManager;
   private final IDialogsResourceManager  dialogsResourceManager;
   
   private ResourceManager() {
      bonusesResourcesManager = new BonusesResourcesManager();
      dialogsResourceManager  = new DialogsResourceManager();
   }
   
   public static ResourceManager getInstance() {
      if(instance == null)
         instance = new ResourceManager();
      return instance;
   }
   
   public void loadResources(Context context, Engine engine) {
      this.engine = engine;
      
      soundsManager = new SoundsManager(engine.getSoundManager(), context);
      
      clickersBitmapTextureAtlas    = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);      
      
      foodClickerFarmTexture        = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker/farm.png", 0, 0);
      foodClickerCowBrownTexture    = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker/cow_brown.png", 256, 0, 2, 1);
      foodClickerChickenTexture     = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker/chicken.png", 0, 169, 2, 1);
      foodClickerSheepTexture       = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker/sheep.png", 248, 169, 2, 1);
      
      woodClickerBgndTextureRegion  = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/wood_clicker.png", 513, 0);
      
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
      
      shopBitmapTextureAtlas                 = new BitmapTextureAtlas(engine.getTextureManager(), 2048, 2048);
      shopBackgroundTextureRegion            = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_background.png", 0, 0);                     /*1024 1820*/
      shopItemBackgroundTextureRegion        = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_item_background.png", 1024, 0);             /*1024 193*/
      shopResPanelBackgroundTextureRegion    = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/shop_res_panel_background.png", 1024, 200);      /*1024 171*/
      closeBtnTextureRegion                  = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(shopBitmapTextureAtlas, context, "gfx/buttons/close_dialog_btn.png", 1024, 400, 2, 1);  /*256 128*/
      buyGoldPanelBackgroundTextureRegion    = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/buy_gold_panel_background.png", 1024, 600);      /*960 120*/
      billingResultBackgroundTextureRegion   = BitmapTextureAtlasTextureRegionFactory.createFromAsset(shopBitmapTextureAtlas, context, "gfx/shops/billing_result_dialog_background.png", 1024, 800);      /*1024 668*/
      
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
      
      loadBackground(context);
      
      
      
      bonusesResourcesManager.load(context, engine);            
      dialogsResourceManager.load(context, engine);
   }
   
   
   private void loadBackground(Context context) {
      cloudsTextureAtlas      = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      rocksTextureAtlas       = new BitmapTextureAtlas(engine.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
      
      cloudsTexture     = BitmapTextureAtlasTextureRegionFactory.createFromAsset(cloudsTextureAtlas, context, "gfx/environment/clouds.png", 1, 0);
      rocksTexture      = BitmapTextureAtlasTextureRegionFactory.createFromAsset(rocksTextureAtlas, context, "gfx/environment/rocks.png", 0, 0);
      
      cloudsTextureAtlas.load();
      rocksTextureAtlas.load();
   }
   
   public Engine getEngine() {
      return engine;
   }
   
   public SoundsManager getSoundsManager() {
      return soundsManager;
   }
   
   public ITextureRegion getFoodClickerFarmTextureRegion() {
      return foodClickerFarmTexture;
   }
   
   public ITiledTextureRegion getFoodClickerCowBrownTexture() {
      return foodClickerCowBrownTexture;
   }
   
   public ITiledTextureRegion getFoodClickerChickenTexture() {
      return foodClickerChickenTexture;
   }
   
   public ITiledTextureRegion getFoodCliclerSheepTexture() {
      return foodClickerSheepTexture;
   }      
   
   public ITextureRegion getWoodClickerBgndTextureRegion() {
      return woodClickerBgndTextureRegion;
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

   public ITextureRegion getExpIconTextureRegion() {
      return expIconTextureRegion;
   }

   public ITiledTextureRegion getBuyBtnTextureRegion() {
      return buyBtnTextureRegion;
   }

   public ITextureRegion getSwordsIconTextureRegion() {
      return swordsIconTextureRegion;
   }

   public ITextureRegion getCloudsTexture() {
      return cloudsTexture;
   }

   public ITextureRegion getRocksTexture() {
      return rocksTexture;
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

   public ITextureRegion getMarketShopItemBackgroundTextureRegion() {
      return marketShopItemBackgroundTextureRegion;
   }

   public ITextureRegion getBuyGoldPanelBackgroundTextureRegion() {
      return buyGoldPanelBackgroundTextureRegion;
   }

   public ITextureRegion getBillingResultBackgroundTextureRegion() {
      return billingResultBackgroundTextureRegion;
   }

   
   //MANAGERS
   public IBonusesResourcesManager getBonusesResourcesManager() {
      return bonusesResourcesManager;
   }

   public IDialogsResourceManager getDialogsResourceManager() {
      return dialogsResourceManager;
   }        
   
}
