package ru.majestic.thetown.activity;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.majestic.thetown.ads.IAdsManager;
import ru.majestic.thetown.ads.impl.AppodealAdsManager;
import ru.majestic.thetown.ads.listeners.OnAdShowenListener;
import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.andengine.TheTownEngineOptions;
import ru.majestic.thetown.andengine.TheTownScene;
import ru.majestic.thetown.game.IBillingManager;
import ru.majestic.thetown.game.IClickersManager;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.game.bonuses.IGameBonus;
import ru.majestic.thetown.game.bonuses.IGameBonusFactory;
import ru.majestic.thetown.game.bonuses.factories.GameBonusFactory;
import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.game.cargo.ISizeLimitedCargo;
import ru.majestic.thetown.game.cargo.ISizeLimitedCargo.OnCargoFullListener;
import ru.majestic.thetown.game.cargo.impl.FoodCargo;
import ru.majestic.thetown.game.cargo.impl.WoodCargo;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.game.clickers.impl.FoodClicker;
import ru.majestic.thetown.game.clickers.impl.WoodClicker;
import ru.majestic.thetown.game.impl.BillingManager;
import ru.majestic.thetown.game.impl.GameManager;
import ru.majestic.thetown.game.listener.OnBillingOperationCompleteListener;
import ru.majestic.thetown.game.listener.OnTimeToAttackListener;
import ru.majestic.thetown.game.market.IMarketItem;
import ru.majestic.thetown.game.town.ITownLevelReward;
import ru.majestic.thetown.game.town.listeners.OnTownNewLevelObtainedListener;
import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.game.workers.IWorkersProductionHandler;
import ru.majestic.thetown.game.workers.impl.WorkersProductionHandler;
import ru.majestic.thetown.game.workers.listeners.OnWokersProductionCompleteListener;
import ru.majestic.thetown.notifications.TheTownNotificationManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.statistic.StatisticsEventsManager;
import ru.majestic.thetown.view.attack.IAttackTimeView;
import ru.majestic.thetown.view.attack.IAttackView;
import ru.majestic.thetown.view.attack.impl.SimpleAttackTimeView;
import ru.majestic.thetown.view.attack.impl.SimpleAttackView;
import ru.majestic.thetown.view.attack.listeners.OnAttackDialogClosedListener;
import ru.majestic.thetown.view.bonuses.IBonusesViewHandler;
import ru.majestic.thetown.view.bonuses.handler.BonusesViewHandler;
import ru.majestic.thetown.view.bonuses.handler.listeners.OnBonusViewLandedListener;
import ru.majestic.thetown.view.clickers.IClickerView;
import ru.majestic.thetown.view.clickers.adder.IAddersViewManager;
import ru.majestic.thetown.view.clickers.adder.IAddersViewManager.AdderType;
import ru.majestic.thetown.view.clickers.adder.impl.AddersViewManager;
import ru.majestic.thetown.view.clickers.impl.WoodClickerView;
import ru.majestic.thetown.view.clickers.impl.food.FoodClickerView;
import ru.majestic.thetown.view.counters.ICountView;
import ru.majestic.thetown.view.counters.ICountWithMaxValueView;
import ru.majestic.thetown.view.counters.IResourcesCounterPanel;
import ru.majestic.thetown.view.counters.impl.DefenceCounterView;
import ru.majestic.thetown.view.counters.impl.GameResourcesCounterPanel;
import ru.majestic.thetown.view.counters.impl.HomeCounterView;
import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.billing.BillingProductsDictionary;
import ru.majestic.thetown.view.dialogs.billing.IBillingResultDialog;
import ru.majestic.thetown.view.dialogs.billing.IBillingResultDialog.State;
import ru.majestic.thetown.view.dialogs.billing.impl.BillingResultDialog;
import ru.majestic.thetown.view.dialogs.billing.listeners.OnBillingDialogClosedListener;
import ru.majestic.thetown.view.dialogs.bonus.ABonusRewardDialog;
import ru.majestic.thetown.view.dialogs.bonus.factory.IBonusRewardDialogsFactory;
import ru.majestic.thetown.view.dialogs.bonus.factory.impl.BonusRewardDialogsFactory;
import ru.majestic.thetown.view.dialogs.bonus.listeners.OnImproveBtnClickedListener;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;
import ru.majestic.thetown.view.dialogs.shops.IShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.impl.BuildingsShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ClickersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.MarketShopDialog;
import ru.majestic.thetown.view.dialogs.shops.impl.ShopsDialogsManager;
import ru.majestic.thetown.view.dialogs.shops.impl.WorkersShopDialog;
import ru.majestic.thetown.view.dialogs.shops.listeners.BuildingsShopDialogActionListeners;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopDialogActionsListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.MarketShopDialogActionListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.OnShopsCloseButtonCLickedListener;
import ru.majestic.thetown.view.dialogs.shops.listeners.WorkersShopDialogActionListener;
import ru.majestic.thetown.view.dialogs.shops.panels.listeners.OnBuyGoldListener;
import ru.majestic.thetown.view.dialogs.townlevel.impl.TownLevelRewardDialog;
import ru.majestic.thetown.view.errors.impl.ErrorViewManager;
import ru.majestic.thetown.view.listeners.OnClickerClickedListener;
import ru.majestic.thetown.view.menu.IShopsMenu;
import ru.majestic.thetown.view.menu.impl.ShopsMenu;
import ru.majestic.thetown.view.menu.listeners.OnShopsMenuButtonClickedListener;
import ru.majestic.thetown.view.sound.ISoundStateView;
import ru.majestic.thetown.view.sound.impl.SoundStateView;
import ru.majestic.thetown.view.sound.listener.OnSoundStateChangedListener;
import ru.majestic.thetown.view.town.ITownView;
import ru.majestic.thetown.view.town.impl.SimpleTownView;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;

import com.flurry.android.FlurryAgent;


public class GameActivity extends BaseGameActivity implements OnClickerClickedListener,
                                                              OnShopsCloseButtonCLickedListener,
                                                              ClickersShopDialogActionsListener,
                                                              OnShopsMenuButtonClickedListener,
                                                              BuildingsShopDialogActionListeners, 
                                                              WorkersShopDialogActionListener,
                                                              OnWokersProductionCompleteListener,
                                                              OnTimeToAttackListener,
                                                              OnAttackDialogClosedListener,
                                                              OnSoundStateChangedListener, 
                                                              OnBuyGoldListener,
                                                              OnBillingDialogClosedListener,
                                                              OnBillingOperationCompleteListener,
                                                              MarketShopDialogActionListener,
                                                              OnDialogClosedListener,
                                                              OnTownNewLevelObtainedListener,
                                                              OnBonusViewLandedListener,
                                                              OnImproveBtnClickedListener,
                                                              OnAdShowenListener,
                                                              OnCargoFullListener {
   
   private static final int LAUNCH_BILLING_ACTIVITY_REQUEST_CODE = 1001;   

	private Camera 	        camera;	
	private Scene             scene;
				
	private IGameManager      gameManager;
	private IBillingManager   billingManager;
	
	private IClickerView         foodClicker;
	private IClickerView         woodClicker;
	private IAddersViewManager   addersViewManager;

	private IResourcesCounterPanel  resourcesCounterPanel;
	private ICountWithMaxValueView  homeCountView;
	private ICountView              defenceCountView;	
	private ITownView               townView;
	private IAttackTimeView         attackTimeView;
	
	private ISoundStateView         soundStateView;
	
	private IAttackView             attackView;
	private IBillingResultDialog    billingResultDialog;
	
	private TownLevelRewardDialog   townLevelRewardDialog;
	
	private IShopsMenu shopsMenu;		
	private IShopsDialogsManager shopsDialogManager;
	
   private IWorkersProductionHandler workersProductionHandler;
   
   private IBonusesViewHandler         bonusesViewHandler;
   private IGameBonusFactory           gameBonusFactory;
   private IBonusRewardDialogsFactory  bonusRewardDialogsFactory;
   
   private ABonusRewardDialog          bonusRewardDialog;
   private IGameBonus                  currentGameBonus;
   private IAdsManager                 adsManager;   
   
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      
      adsManager = new AppodealAdsManager(this);
      adsManager.setOnAdShowenListener(this);
                              
      StatisticsEventsManager.getInstance().onApplicationLaunched(getIntent().getStringExtra(StatisticsEventsManager.LAUNCH_MODE_TAG));            
   }
   
   @Override
   public void onStart() {
      super.onStart();
      FlurryAgent.onStartSession(this);
   }
   
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		camera = new TheTownCamera();
				
		return new TheTownEngineOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
	   ResourceManager.getInstance().loadResources(this, getEngine());
	   FontsManager.getInstance().load(this, getEngine());
	   
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		scene = new TheTownScene();		
		
		gameManager = new GameManager();
      gameManager.load(this);         
      gameManager.getAttackManager().setOnTimeToAttackListener(this);
      
      billingManager = new BillingManager();
      billingManager.setOnBillingOperationCompleteListener(this);
      
      foodClicker          = new FoodClickerView();
      woodClicker          = new WoodClickerView();
      addersViewManager    = new AddersViewManager();
      
      resourcesCounterPanel   = new GameResourcesCounterPanel(gameManager);
      homeCountView           = new HomeCounterView      (10, 90);
      defenceCountView        = new DefenceCounterView   (10, 130);      
      townView                = new SimpleTownView(gameManager.getTown());
      attackTimeView          = new SimpleAttackTimeView(TheTownCamera.CAMERA_WIDTH - 90, 100, gameManager.getAttackManager());
      soundStateView          = new SoundStateView(TheTownCamera.CAMERA_WIDTH - 50, 40);      
      attackView              = new SimpleAttackView();
      billingResultDialog     = new BillingResultDialog();
      townLevelRewardDialog   = new TownLevelRewardDialog(scene);      
      
      townLevelRewardDialog.setOnDialogClosedListener(this);
      
      billingResultDialog.setOnBillingDialogClosedListener(this);            
      
      attackView.setOnAttackDialogClosedListener(this);
      
      soundStateView.setOnSoundStateChangedListener(this);
      soundStateView.setSoundEnaled(ResourceManager.getInstance().getSoundsManager().isSoundEnabled());
      
      shopsMenu = new ShopsMenu();        
      
      shopsDialogManager = new ShopsDialogsManager(gameManager, scene);
      
      foodClicker.setOnClickerClickedListener(this);
      woodClicker.setOnClickerClickedListener(this);  
      
      shopsMenu.setOnShopsMenuButtonClickedListener(this);
      
      shopsDialogManager.setOnShopsCloseButtonClickedListener(this);
      shopsDialogManager.setOnBuyGoldListener(this);
                       
      ClickersShopDialog clickersShopDialog = (ClickersShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS);
      clickersShopDialog.setClickersShopDialogActionsListener(this);
      
      BuildingsShopDialog buildingsShopDialog = (BuildingsShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_BUILDINGS);
      buildingsShopDialog.setBuildingsShopDialogActionListeners(this);     
      
      WorkersShopDialog workersShopDialog = (WorkersShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_WORKERS);
      workersShopDialog.setWorkersShopDialogActionListener(this);
      
      MarketShopDialog marketShopDialog = (MarketShopDialog) shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_MARKET);
      marketShopDialog.setMarketShopDialogActionListener(this);
      
      homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
      homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());	
      
      defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
      
      gameManager.getTown().addOnTownNewLevelObtainedListener(townLevelRewardDialog);
      gameManager.getTown().addOnTownNewLevelObtainedListener(this);
      
      gameManager.getCargoManager().getWoodCargo().setOnCargoFullListener(this);
      gameManager.getCargoManager().getFoodCargo().setOnCargoFullListener(this);
      
      bonusesViewHandler = new BonusesViewHandler(scene, scene);
      bonusesViewHandler.setOnBonusViewLandedListener(this);
      
      gameBonusFactory  = new GameBonusFactory(gameManager);
      
      bonusRewardDialogsFactory = new BonusRewardDialogsFactory(scene);
      
		pOnCreateSceneCallback.onCreateSceneFinished(scene);
	}

	@Override
	public void onPopulateScene(Scene scene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		foodClicker.attachToParent(scene);
	   woodClicker.attachToParent(scene);
	   addersViewManager.attachAdders(scene);
	   
	   resourcesCounterPanel.attachToParent(scene);
	   homeCountView.attachToParent(scene);
	   defenceCountView.attachToParent(scene);	   
	   townView.attachToParent(scene);
	   attackTimeView.attachToParent(scene);	   
	   soundStateView.attachToParent(scene);	   
	   attackView.attachToParent(scene);	   
	   
	   shopsMenu.attachToParent(scene);
	   
	   shopsDialogManager.attachToScene(scene);
	   
	   foodClicker.registerTouchArea(scene);
	   woodClicker.registerTouchArea(scene);
	   soundStateView.registerTouchArea(scene);
	   
	   shopsMenu.registerTouchArea(scene);
	   
	   billingResultDialog.attachToParent(scene);
	   townLevelRewardDialog.attachToParent(scene);
	   
	   resourcesCounterPanel.update();	   	   
	   
	   bonusesViewHandler.begin();
	   
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	@Override
	public void onResumeGame() {
	   if(getEngine() != null) {
	      super.onResumeGame();	   	   
	   
   	   gameManager.getAttackManager().startAttackTimeObserve();
   	   
   	   if(workersProductionHandler == null) {
      	   workersProductionHandler = new WorkersProductionHandler(gameManager.getWorkersManager());
            workersProductionHandler.setOnWokersProductionCompleteListener(this);
      	   workersProductionHandler.load(this);
            workersProductionHandler.start();
   	   }
         
         billingManager.init(this);         
	   }
	}

   @Override
   public void onClickerClicked(float x, float y, IClickerView clicker) {
      if(gameManager.getGoldFromClickerHandler().isGoldChance()) {
         gameManager.getCargoManager().getGoldCargo().add(1);
         addersViewManager.showAdder(clicker.getX() + x, clicker.getY() + y, 1, AdderType.GOLD);
      } else {
         if(clicker == foodClicker) {         
            gameManager.getCargoManager().getFoodCargo().add(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD).getResourcesPerClick());
            addersViewManager.showAdder(clicker.getX() + x, clicker.getY() + y, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_FOOD).getResourcesPerClick(), AdderType.FOOD);                                               
         } else if(clicker == woodClicker) {
            gameManager.getCargoManager().getWoodCargo().add(gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD).getResourcesPerClick());         
            addersViewManager.showAdder(clicker.getX() + x, clicker.getY() + y, gameManager.getClickersManager().getClicker(IClickersManager.CLICKER_TYPE_WOOD).getResourcesPerClick(), AdderType.WOOD);
         }
      }
      
      resourcesCounterPanel.update();
   }
   
   @Override
   public void onPause() {
      super.onPause();            
      if(gameManager != null) {
         gameManager.save(this);
         gameManager.getAttackManager().stopAttackTimeObserve();
      }
      
      if(workersProductionHandler != null) {
         workersProductionHandler.save(this);
         workersProductionHandler.stop();
         workersProductionHandler = null;
      }
      
      if(billingManager != null) {
         billingManager.deinit();
      }
   }
   
   @Override
   public void onStop() {
      super.onStop();
      FlurryAgent.onEndSession(this);
   }

   @Override
   public void onNeedOpenShopDialog(int shopType) {
      
      if(shopsDialogManager.getShop(shopType).isVisible()) {
         shopsDialogManager.closeShop(shopType, scene);
         
         shopsMenu.clearAllSelection();
         
         foodClicker.registerTouchArea(scene);
         woodClicker.registerTouchArea(scene);
         
         soundStateView.registerTouchArea(scene);
      } else {
         shopsDialogManager.openShop(shopType, scene);
         shopsDialogManager.getShop(shopsDialogManager.getOpenedShopIndex()).update();
         
         foodClicker.unregisterTouchArea(scene);
         woodClicker.unregisterTouchArea(scene);
         
         soundStateView.unregisterTouchArea(scene);
      }
      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }

   @Override
   public void onBuyBuildingAction(IBuilding building) {
      if(gameManager.getCargoManager().getWoodCargo().getCurrentCount() >= building.getWoodCost()) {
         gameManager.getCargoManager().getWoodCargo().remove(building.getWoodCost());
         gameManager.getTown().addExp(building.getExp());
         
         building.buy();
         
         townView.update();
         resourcesCounterPanel.update();         
         homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
         
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_BUILDINGS).update();
      } else {
         ErrorViewManager.showError(scene, "No enough wood");
      }
      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }

   @Override
   public void onShopsCloseButtonClicked(IDialog dialog) {
      dialog.hide();
      dialog.unregisterTouchArea(scene);      
      
      shopsMenu.clearAllSelection();
      
      foodClicker.registerTouchArea(scene);
      woodClicker.registerTouchArea(scene);
      
      soundStateView.registerTouchArea(scene);
      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }
    
   @Override
   public void onBackPressed() {
      if(billingResultDialog.isVisible()) {
         onBillingDialogClosed();
         
      } else if(attackView.isVisible()) {
         onAttackDialogClosed();
         
      } else if (townLevelRewardDialog.isVisible()) {
         townLevelRewardDialog.hide();
         
      } else if(shopsDialogManager.hasOpenedShop()) {
         shopsDialogManager.closeShop(shopsDialogManager.getOpenedShopIndex(), scene);
         
         shopsMenu.clearAllSelection();
         
         foodClicker.registerTouchArea(scene);
         woodClicker.registerTouchArea(scene);
         
         soundStateView.registerTouchArea(scene);
         
      } else if(bonusRewardDialog != null && bonusRewardDialog.isVisible()) {
         closeRewardDialogAndExecuteBonus();      
      } else {
         super.onBackPressed();
      }
   }

   @Override
   public void onUpgradeClickerButtonClicked(IClicker clicker) {
      if(clicker instanceof FoodClicker) {
         if(gameManager.getCargoManager().getWoodCargo().getCurrentCount() >= clicker.getUpgradePrice()) {
            gameManager.getCargoManager().getWoodCargo().remove(clicker.getUpgradePrice());
            clicker.upgrade();                        
         } else {
            ErrorViewManager.showError(scene, "No enough wood");
         }
      }
      
      if(clicker instanceof WoodClicker) {
         if(gameManager.getCargoManager().getFoodCargo().getCurrentCount() >= clicker.getUpgradePrice()) {
            gameManager.getCargoManager().getFoodCargo().remove(clicker.getUpgradePrice());
            clicker.upgrade();                        
         } else {
            ErrorViewManager.showError(scene, "No enough food");
         }
      }
      
      resourcesCounterPanel.update();
      shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS).update();      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }
   
   @Override
   public void onUpgradeCargoButtonClicker(ISizeLimitedCargo cargo) {      
      if(cargo == gameManager.getCargoManager().getFoodCargo()) {
         if(gameManager.getCargoManager().getWoodCargo().getCurrentCount() >= cargo.getUpgradePrice()) {
            gameManager.getCargoManager().getWoodCargo().remove(cargo.getUpgradePrice());
            cargo.upgrade();
         } else {
            ErrorViewManager.showError(scene, "No enough wood");
         }
      }
      
      if(cargo == gameManager.getCargoManager().getWoodCargo()) {      
         if(gameManager.getCargoManager().getFoodCargo().getCurrentCount() >= cargo.getUpgradePrice()) {
            gameManager.getCargoManager().getFoodCargo().remove(cargo.getUpgradePrice());
            cargo.upgrade();
         } else {
            ErrorViewManager.showError(scene, "No enough food");
         }
      }            
      
      resourcesCounterPanel.update();
      shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_CLICKERS).update();      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }

   @Override
   public void onBuyWorkerAction(IWorker worker) {
      if(gameManager.getCargoManager().getFoodCargo().getCurrentCount() < worker.getFoodCost()) {
         ErrorViewManager.showError(scene, "No enough food");
      } else if((gameManager.getBuildingsManager().getTotalHomePlacesCount() - gameManager.getWorkersManager().getTotalHomeForWorkers()) < worker.getHomePlaces()) {
         ErrorViewManager.showError(scene, "No enough homes");
      } else {      
         gameManager.getCargoManager().getFoodCargo().remove(worker.getFoodCost());
         gameManager.getTown().addExp(worker.getExp());
   
         worker.buy();
   
         townView.update();
         resourcesCounterPanel.update();
   
         homeCountView.onMaxValueChanged(gameManager.getBuildingsManager().getTotalHomePlacesCount());
         homeCountView.changeCount(gameManager.getWorkersManager().getTotalHomeForWorkers());
   
         defenceCountView.changeCount(gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE));
   
         shopsDialogManager.getShop(IShopsDialogsManager.SHOP_TYPE_WORKERS).update();
      }
      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }

   @Override
   public void onWorkersProductionComplete(int addFood, int addWood) {
      gameManager.getCargoManager().getFoodCargo().add(addFood);
      gameManager.getCargoManager().getWoodCargo().add(addWood);
      
      resourcesCounterPanel.update();
      
      if(shopsDialogManager.hasOpenedShop())
         shopsDialogManager.getShop(shopsDialogManager.getOpenedShopIndex()).update();
   }

   @Override
   public void onTimeToAttack() {
      foodClicker.unregisterTouchArea(scene);
      woodClicker.unregisterTouchArea(scene);
      soundStateView.unregisterTouchArea(scene);
      shopsMenu.unregisterTouchArea(scene);
      
      attackView.registerTouchArea(scene);
      
      if(gameManager.getAttackManager().getAttack().getAttackPower() > gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE)) {
         attackView.show(true, gameManager.getCargoManager().getWoodCargo().getCurrentCount(), gameManager.getCargoManager().getFoodCargo().getCurrentCount());
      } else {      
         attackView.show(false, gameManager.getAttackManager().getAttack().getWoodReward(), gameManager.getAttackManager().getAttack().getFoodReward());         
      }
   }

   @Override
   public void onAttackDialogClosed() {
      foodClicker.registerTouchArea(scene);
      woodClicker.registerTouchArea(scene);
      soundStateView.registerTouchArea(scene);      
      shopsMenu.registerTouchArea(scene);
      
      attackView.unregisterTouchArea(scene);
      attackView.close();

      if(gameManager.getAttackManager().getAttack().getAttackPower() > gameManager.getWorkersManager().getResourcesPerSecond(WorkerType.DEFENCE)) {
         gameManager.getCargoManager().getWoodCargo().clear();
         gameManager.getCargoManager().getFoodCargo().clear();                             
      } else {
         gameManager.getCargoManager().getWoodCargo().add(gameManager.getAttackManager().getAttack().getWoodReward());
         gameManager.getCargoManager().getFoodCargo().add(gameManager.getAttackManager().getAttack().getFoodReward());
      }
      
      resourcesCounterPanel.update();
      
      gameManager.getAttackManager().getAttack().update(gameManager.getTown());
      gameManager.save(this);
      
      TheTownNotificationManager.reset(this);     
      
      
   }

   @Override
   public void onSoundStateChanged() {
      ResourceManager.getInstance().getSoundsManager().enableSounds(!ResourceManager.getInstance().getSoundsManager().isSoundEnabled());
      soundStateView.setSoundEnaled(ResourceManager.getInstance().getSoundsManager().isSoundEnabled());           
   }

   @Override
   public void onBuyGold(BuyType buyType) {
      try {
         switch (buyType) {
         case TEN:
            startIntentSenderForResult(billingManager.getPendingIntentForPurchased(BillingProductsDictionary.ITEM_TOKEN_TEN_GOLD).getIntentSender(), LAUNCH_BILLING_ACTIVITY_REQUEST_CODE, new Intent(), 0, 0, 0);
            break;

         case HUNDRED:
            startIntentSenderForResult(billingManager.getPendingIntentForPurchased(BillingProductsDictionary.ITEM_TOKEN_HUNDRED_GOLD).getIntentSender(), LAUNCH_BILLING_ACTIVITY_REQUEST_CODE, new Intent(), 0, 0, 0);
            break;

         case THOUSAND:
            startIntentSenderForResult(billingManager.getPendingIntentForPurchased(BillingProductsDictionary.ITEM_TOKEN_THOUSAND_GOLD).getIntentSender(), LAUNCH_BILLING_ACTIVITY_REQUEST_CODE, new Intent(), 0, 0, 0);
            break;
         }         
      } catch (SendIntentException e) {
         billingResultDialog.show(scene, State.ERROR);
      }
   }
   
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      if (requestCode == LAUNCH_BILLING_ACTIVITY_REQUEST_CODE) {
         if (resultCode == Activity.RESULT_OK) {
            billingManager.onBillingResultReceived(data);
         }
      }
   }

   @Override
   public void onBillingDialogClosed() {
      billingResultDialog.hide(scene);      
   }

   @Override
   public void onBillingOperationComplete(String productId) {
      if(productId.equals(BillingProductsDictionary.ITEM_TOKEN_TEN_GOLD)) {
         billingResultDialog.show(scene, State.SUCCESS_100_GOLD);
         gameManager.getCargoManager().getGoldCargo().add(100);
      }
      if(productId.equals(BillingProductsDictionary.ITEM_TOKEN_HUNDRED_GOLD)) {
         billingResultDialog.show(scene, State.SUCCESS_1000_GOLD);
         gameManager.getCargoManager().getGoldCargo().add(1000);
      }
      if(productId.equals(BillingProductsDictionary.ITEM_TOKEN_THOUSAND_GOLD)) {
         billingResultDialog.show(scene, State.SUCCESS_10000_GOLD);
         gameManager.getCargoManager().getGoldCargo().add(10000);
      }

      gameManager.save(this);
      shopsDialogManager.getShop(shopsDialogManager.getOpenedShopIndex()).getResoucesShopPanel().update();
      resourcesCounterPanel.update();
   }

   @Override
   public void onBillingOperationError() {
      billingResultDialog.show(scene, State.ERROR);      
   }

   @Override
   public void onBuyItemFromMarket(IMarketItem marketItem) {
      if(marketItem.getGoldPrice() <= gameManager.getCargoManager().getGoldCargo().getCurrentCount()) {
         switch(marketItem.getItemType()) {
         case WOOD:
            gameManager.getCargoManager().getWoodCargo().add(marketItem.getProductCount());            
            break;
         case FOOD:
            gameManager.getCargoManager().getFoodCargo().add(marketItem.getProductCount());
            break;
         }
         
         gameManager.getCargoManager().getGoldCargo().remove(marketItem.getGoldPrice());
         
         gameManager.save(this);
         resourcesCounterPanel.update();
         shopsDialogManager.getShop(shopsDialogManager.getOpenedShopIndex()).update();         
         
      } else {
         ErrorViewManager.showError(scene, "No enough gold");
      }
      
      ResourceManager.getInstance().getSoundsManager().getMenuClickSound().play();
   }

   @Override
   public void onDialogClosed(final IDialog dialog) {
      if(dialog == bonusRewardDialog) {
         closeRewardDialogAndExecuteBonus();
      }
   }

   @Override
   public void onTownNewLevelObtained(ITownLevelReward townLevelReward) {
      gameManager.getCargoManager().getWoodCargo().add(townLevelReward.getWoodReward());
      gameManager.getCargoManager().getFoodCargo().add(townLevelReward.getFoodReward());
      gameManager.getCargoManager().getGoldCargo().add(townLevelReward.getGoldReward());
      
      resourcesCounterPanel.update();
      shopsDialogManager.getShop(shopsDialogManager.getOpenedShopIndex()).update();
   }

   @Override
   public void onBonusViewLandedListener() {      
      currentGameBonus = gameBonusFactory.createBonus();
      
      bonusRewardDialog = bonusRewardDialogsFactory.createBonusRewardDialog(currentGameBonus);
      bonusRewardDialog.setOnDialogClosedListener(this);
      bonusRewardDialog.attachToParent(scene);
      if(adsManager.isAdReady()) {
         bonusRewardDialog.setOnImproveBtnClickedListener(this);
         bonusRewardDialog.showImproveButton(true);
      } else
         bonusRewardDialog.showImproveButton(false);
      bonusRewardDialog.show();      
   }
   
   private void closeRewardDialogAndExecuteBonus() {
      bonusRewardDialog.hide();
      currentGameBonus.execute();
      resourcesCounterPanel.update();
      
      runOnUpdateThread(new Runnable() {
         
         @Override
         public void run() {
            bonusRewardDialog.detachSelf();               
         }
      });
   }

   @Override
   public void onImproveBtnClickedListener() {
      adsManager.show();
      bonusRewardDialog.showImproveButton(false);
   }

   @Override
   public void onAdShowen() {
      currentGameBonus.doubleBonus();        
      bonusRewardDialogsFactory.updateBonusRewardDialog(currentGameBonus, bonusRewardDialog);      
   }

   @Override
   public void onCargoFull(ISizeLimitedCargo cargo) {
      if(cargo instanceof FoodCargo) {
         ErrorViewManager.showError(scene, "Food warehouse is full");
      } else if(cargo instanceof WoodCargo) {
         ErrorViewManager.showError(scene, "Wood warehouse is full");
      }
      
   }   
}
