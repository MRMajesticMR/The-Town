package ru.majestic.thetown.view.dialogs.clickers;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopPanelActionsListener;

public abstract class AClickersShopPanelSkeleton extends Rectangle implements IClickersShopPanel,
                                                                              OnClickListener {

   private static final int PANEL_PADDING = 10;
   
   private ClickersShopPanelActionsListener clickersShopPanelActionsListener;
   
   private final Text         panelTitle;
   private final Text         currentLvlTxt;
   private final Text         perClickResourceTxt;
   private final Sprite       perClickResourceIcon;   
   private final ButtonSprite upgradeBtn;
   private final Text         upgradePriceTxt;
   private final Sprite       upgradePriceIcon;
   
   
   public AClickersShopPanelSkeleton(String title, ITextureRegion perSecondResourceTexture, ITextureRegion upgradePriceIconTexture) {
      super(0, 0, 0, 0, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      panelTitle              = new Text(0, 0, ResourceManager.getInstance().getShopTitleFont(), title, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      currentLvlTxt           = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "LVL: 1000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      perClickResourceTxt    = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "100000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      perClickResourceIcon   = new Sprite(0, 0, 40, 40, perSecondResourceTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getPlusBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradePriceTxt         = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "100000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      upgradePriceIcon        = new Sprite(0, 0, 40, 40, upgradePriceIconTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeBtn.setWidth(40);
      upgradeBtn.setHeight(40);            
      
      upgradeBtn.setOnClickListener(this);
      
      attachChild(panelTitle);
      attachChild(currentLvlTxt);
      attachChild(perClickResourceTxt);
      attachChild(perClickResourceIcon);
      attachChild(upgradeBtn);
      attachChild(upgradePriceTxt);
      attachChild(upgradePriceIcon);
      
      setColor(0, 1, 0);
   }
   
   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(upgradeBtn);      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {      
      scene.registerTouchArea(upgradeBtn);
   }

   @Override
   public void attachToParent(Entity parent) {
      panelTitle.setX((getWidth() - panelTitle.getWidth()) / 2);
      panelTitle.setY(PANEL_PADDING);
      
      currentLvlTxt.setX(PANEL_PADDING);
      currentLvlTxt.setY(panelTitle.getY() + panelTitle.getHeight() + 14);
      
      perClickResourceIcon.setX(PANEL_PADDING);
      perClickResourceIcon.setY(currentLvlTxt.getY() + currentLvlTxt.getHeight() + 8);
                  
      perClickResourceTxt.setX(perClickResourceIcon.getX() + perClickResourceIcon.getWidth() + 8);
      perClickResourceTxt.setY(perClickResourceIcon.getY() + 8);
      
      upgradeBtn.setX(PANEL_PADDING);
      upgradeBtn.setY(perClickResourceIcon.getY() + perClickResourceIcon.getHeight() + 8);
      
      upgradePriceIcon.setX(getWidth() - upgradePriceIcon.getWidth() - PANEL_PADDING);
      upgradePriceIcon.setY(upgradeBtn.getY());
      
      upgradePriceTxt.setX(upgradePriceIcon.getX() - upgradePriceTxt.getWidth() - 10);
      upgradePriceTxt.setY(upgradeBtn.getY() + 10);            
      
      parent.attachChild(this);
   }   

   @Override
   public void setClickersShopPanelActionsListener(ClickersShopPanelActionsListener clickersShopPanelActionsListener) {
      this.clickersShopPanelActionsListener = clickersShopPanelActionsListener;
   }

   @Override
   public void showCurrentClickerLvl(int newLvl) {
      currentLvlTxt.setText("LVL: " + newLvl);
   }

   @Override
   public void showCurrentClickerResourcesPerClick(int resourcesPerClick) {
      perClickResourceTxt.setText(resourcesPerClick + " pC");
   }

   @Override
   public void showUpgradePrice(int upgradePrice) {
      upgradePriceTxt.setText(String.valueOf(upgradePrice));
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == upgradeBtn) {
         clickersShopPanelActionsListener.onUpdateButtonClicked(this);
         return;
      }
   }

}
