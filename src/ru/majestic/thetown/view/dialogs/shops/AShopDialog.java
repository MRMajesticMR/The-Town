package ru.majestic.thetown.view.dialogs.shops;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.IGameManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.buttons.ICloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.impl.SimpleCloseDialogButton;
import ru.majestic.thetown.view.dialogs.buttons.listeners.OnCloseDialogButtonClickedListener;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;
import ru.majestic.thetown.view.dialogs.shops.panels.IBuyGoldShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.IResourcesShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.impl.BuyGoldShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.impl.ResourcesShopPanel;

public abstract class AShopDialog extends Sprite implements IShopDialog, OnCloseDialogButtonClickedListener {

   protected static final int MARGIN_BOTTOM           = 45;
   protected static final int PADDING_TOP             = 44;
   protected static final int PADDINGS_LEFT_RIGHT     = 4;
   
   private OnDialogClosedListener onDialogClosedListener;    
   
   private ICloseDialogButton    closeDialogButton;
   private IResourcesShopPanel   resourcesShopPanel;
   private IBuyGoldShopPanel     buyGoldShopPanel;
   
   protected IGameManager        gameManager;
   
   public AShopDialog(IGameManager gameManager) {
      super(0, 0, TheTownCamera.CAMERA_WIDTH, TheTownCamera.CAMERA_HEIGHT - MARGIN_BOTTOM, ResourceManager.getInstance().getShopBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      this.gameManager = gameManager;
      
      setVisible(false);
      
      resourcesShopPanel = new ResourcesShopPanel(this, gameManager);
      resourcesShopPanel.attachToParent(this);
      
      closeDialogButton = new SimpleCloseDialogButton(this);     
      closeDialogButton.setOnCloseDialogButtonClickedListener(this);      
      closeDialogButton.attachToParent(this);
      
      buyGoldShopPanel = new BuyGoldShopPanel(this);
      buyGoldShopPanel.attachToParent(this);
   }
   
   @Override
   public void registerTouchArea(Scene scene) {
      closeDialogButton.registerTouchArea(scene);
      buyGoldShopPanel.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      closeDialogButton.unregisterTouchArea(scene);
      buyGoldShopPanel.unregisterTouchArea(scene);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
      this.onDialogClosedListener = onDialogClosedListener;
   }

   @Override
   public void show() {
      setVisible(true);
   }

   @Override
   public void hide() {
      setVisible(false);      
   }

   @Override
   public void onCloseDialogButtonClicked() {
      onDialogClosedListener.onDialogClosed(this);      
   }
   
   @Override
   public void update() {
      resourcesShopPanel.update();
   }
   
   @Override
   public IResourcesShopPanel getResoucesShopPanel() {
      return resourcesShopPanel;
   }

   @Override
   public IBuyGoldShopPanel getBuyGoldShopPanel() {
      return buyGoldShopPanel;
   }

}
