package ru.majestic.thetown.view.dialogs.shops.panels.clickers;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.clickers.IClicker;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.listeners.ClickersShopPanelActionsListener;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public abstract class AClickersShopPanelSkeleton extends Rectangle implements IClickersShopPanel,
                                                                              OnClickListener {

   private static final int PANEL_PADDING = 4;
   
   private ClickersShopPanelActionsListener clickersShopPanelActionsListener;
   
   private IClicker clicker;
   
   private final Text         panelTitle;
   private final Text         currentLvlTxt;
   private final Text         perClickResourceTxt;
   private final Sprite       perClickResourceIcon;   
   private final ButtonSprite upgradeBtn;
   private final Text         upgradePriceTxt;
   private final Sprite       upgradePriceIcon;
   
   
   public AClickersShopPanelSkeleton(IClicker clicker, ITextureRegion perSecondResourceTexture, ITextureRegion upgradePriceIconTexture) {
      super(0, 0, 0, 0, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setColor(0, 1, 0);
      this.clicker = clicker;
      
      panelTitle              = new Text(0, 0, ResourceManager.getInstance().getShopTitleFont(), clicker.getTitle(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      currentLvlTxt           = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "LVL: 1000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      perClickResourceTxt    = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "10.00AA pC", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      perClickResourceIcon   = new Sprite(0, 0, 45, 45, perSecondResourceTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeBtn              = new ButtonSprite(0, 0, ResourceManager.getInstance().getPlusBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradePriceTxt         = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "10.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      upgradePriceIcon        = new Sprite(0, 0, 45, 45, upgradePriceIconTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeBtn.setWidth(45);
      upgradeBtn.setHeight(45);            
      
      upgradeBtn.setOnClickListener(this);
      
      attachChild(panelTitle);
      attachChild(currentLvlTxt);
      attachChild(perClickResourceTxt);
      attachChild(perClickResourceIcon);
      attachChild(upgradeBtn);
      attachChild(upgradePriceTxt);
      attachChild(upgradePriceIcon);
      
      update();
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
      
      upgradePriceTxt.setX(upgradePriceIcon.getX() - upgradePriceTxt.getWidth() - 6);
      upgradePriceTxt.setY(upgradePriceIcon.getY() + 8);            
      
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
   public void update() {
      currentLvlTxt.setText("LVL: " + clicker.getCurrentLvl());
      perClickResourceTxt.setText(BigValueFormatter.format(clicker.getResourcesPerClick()) + " pC");
      upgradePriceTxt.setText(BigValueFormatter.format(clicker.getUpgradePrice()));
      
      upgradePriceTxt.setX(upgradePriceIcon.getX() - upgradePriceTxt.getWidth() - 6);      
   }

}
