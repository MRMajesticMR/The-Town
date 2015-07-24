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

   public static final int HEIGHT = 110;
   
   private static final int PADDING = 10;
   
   private ClickersShopPanelActionsListener clickersShopPanelActionsListener;
   
   protected IClicker clicker;
   
   private IAvailableShadow availableShadow;
   
   private final Sprite       panelTitleImg;
   private final Text         panelTitleTxt;
      
   private final Text         perClickResourceTxt;
   
   private final Text         priceValueTxt;
   private final Sprite       priceImg;
   
   private final Text         currentLvlTxt;
   private final ButtonSprite upgradeBtn;   
   
   
   public AClickersShopPanelSkeleton(float x, float y, float width, IClicker clicker, ITextureRegion perSecondResourceTexture, ITextureRegion upgradePriceIconTexture) {
      super(x, y, width, HEIGHT, ResourceManager.getInstance().getClickersUpgraderBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      this.clicker = clicker;                                  
         
      panelTitleImg           = new Sprite(PADDING, PADDING + 4, 25, 25, perSecondResourceTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      panelTitleTxt           = new Text(panelTitleImg.getX() + panelTitleImg.getWidth() + 4, PADDING + 4, FontsManager.getInstance().getFont(18), "CLICKER", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
               
      perClickResourceTxt     = new Text(PADDING + 30, 42, FontsManager.getInstance().getFont(16), "100.00AA PC", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      
      priceImg                = new Sprite(PADDING + 4, 68, 22, 22, upgradePriceIconTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      priceValueTxt           = new Text(40, 68, FontsManager.getInstance().getFont(16), "100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      
      currentLvlTxt           = new Text(0, 0, FontsManager.getInstance().getFont(16), "100", 10, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      upgradeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getUpgBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      availableShadow = new AvailableShadow(0, 0, getWidth(), getHeight());
      
      upgradeBtn.setWidth(70);
      upgradeBtn.setHeight(39);            
      upgradeBtn.setX(getWidth() - upgradeBtn.getWidth() - PADDING); 
      upgradeBtn.setY(getHeight() - upgradeBtn.getHeight() - PADDING);
      
      upgradeBtn.setOnClickListener(this);
      
      currentLvlTxt.setY(40);
      currentLvlTxt.setX(upgradeBtn.getX() + (upgradeBtn.getWidth() / 2) - (currentLvlTxt.getWidth() / 2));
      
      attachChild(panelTitleImg);
      attachChild(panelTitleTxt);
      
      attachChild(perClickResourceTxt);
      
      attachChild(priceImg);
      attachChild(priceValueTxt);
      
      attachChild(currentLvlTxt);
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
      priceValueTxt.setText(BigValueFormatter.format(clicker.getUpgradePrice()));
      
      currentLvlTxt.setX(upgradeBtn.getX() + (upgradeBtn.getWidth() / 2) - (currentLvlTxt.getWidth() / 2));
      
      if(isUpgradeAvailable(cargoManager))
         availableShadow.hide();
      else
         availableShadow.show();
   }        

}
