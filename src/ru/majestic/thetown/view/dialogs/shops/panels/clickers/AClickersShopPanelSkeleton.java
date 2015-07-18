package ru.majestic.thetown.view.dialogs.shops.panels.clickers;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.ICargoManager;
import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.dialogs.utils.IAvailableShadow;
import ru.majestic.thetown.view.dialogs.utils.impl.AvailableShadow;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public abstract class AClickersShopPanelSkeleton extends Sprite implements IClickersShopPanel,
                                                                              OnClickListener {

   private static final int PANEL_PADDING = 12;
   
   private ClickersShopPanelActionsListener clickersShopPanelActionsListener;
   
   protected IClicker clicker;
   
   private IAvailableShadow availableShadow;
   
   private final Text         currentLvlTxt;
   private final Text         perClickResourceTxt;
   private final Sprite       perClickResourceIcon;   
   private final ButtonSprite upgradeBtn;
   private final Text         upgradePriceTxt;
   private final Sprite       upgradePriceIcon;
   
   
   public AClickersShopPanelSkeleton(float x, float y, float width, float height, IClicker clicker, ITextureRegion perSecondResourceTexture, ITextureRegion upgradePriceIconTexture) {
      super(x, y, width, height, ResourceManager.getInstance().getClickersUpgraderBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      this.clicker = clicker;
      
      availableShadow = new AvailableShadow(0, 0, getWidth(), getHeight());
                  
      currentLvlTxt           = new Text(0, PANEL_PADDING + 6, FontsManager.getInstance().getFont(20), "1000000", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
            
      perClickResourceIcon   = new Sprite(PANEL_PADDING, PANEL_PADDING, 30, 30, perSecondResourceTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      perClickResourceTxt    = new Text(perClickResourceIcon.getX() + perClickResourceIcon.getWidth() + 8, perClickResourceIcon.getY() + 10, FontsManager.getInstance().getFont(12), "100.00AA PC", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      
      upgradePriceIcon        = new Sprite(PANEL_PADDING, perClickResourceIcon.getY() + perClickResourceIcon.getHeight() + 8, 30, 30, upgradePriceIconTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      upgradePriceTxt         = new Text(upgradePriceIcon.getX() + upgradePriceIcon.getWidth() + 4, upgradePriceIcon.getY() + 8, FontsManager.getInstance().getFont(12), "100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      
      upgradeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getUpgBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeBtn.setWidth(70);
      upgradeBtn.setHeight(35);            
      upgradeBtn.setX(215 - upgradeBtn.getWidth() - PANEL_PADDING); 
      upgradeBtn.setY(upgradePriceIcon.getY());
      
      upgradeBtn.setOnClickListener(this);
      
      attachChild(currentLvlTxt);
      attachChild(perClickResourceIcon);
      attachChild(perClickResourceTxt);      
      attachChild(upgradePriceIcon);
      attachChild(upgradePriceTxt); 
      attachChild(upgradeBtn);      
      
      availableShadow.attachToParent(this);
   }
   
   protected abstract boolean isUpgradeAvailable(ICargoManager cargoManager);
   
   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(upgradeBtn);      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {      
      scene.unregisterTouchArea(upgradeBtn);
   }

   @Override
   public void attachToParent(Entity parent) {                          
      parent.attachChild(this);
   }   

   @Override
   public void setClickersShopPanelActionsListener(ClickersShopPanelActionsListener clickersShopPanelActionsListener) {
      this.clickersShopPanelActionsListener = clickersShopPanelActionsListener;
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == upgradeBtn) {
         clickersShopPanelActionsListener.onUpdateButtonClicked(clicker);
         return;
      }
   }
   
   @Override
   public void update(ICargoManager cargoManager) {
      currentLvlTxt.setText(String.valueOf(clicker.getCurrentLvl()));
      perClickResourceTxt.setText(BigValueFormatter.format(clicker.getResourcesPerClick()) + " PC");
      upgradePriceTxt.setText(BigValueFormatter.format(clicker.getUpgradePrice()));
      
      currentLvlTxt.setX(getWidth() - 100 - PANEL_PADDING + (100 - currentLvlTxt.getWidth()) / 2);
      
      if(isUpgradeAvailable(cargoManager))
         availableShadow.hide();
      else
         availableShadow.show();
   }        

}
