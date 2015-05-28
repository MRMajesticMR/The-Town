package ru.majestic.thetown.view.dialogs.clickers;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.listeners.ClickersShopPanelActionsListener;

public abstract class AClickersShopPanelSkeleton extends Rectangle implements IClickersShopPanel {

   private static final int PANEL_PADDING = 10;
   
   private ClickersShopPanelActionsListener clickersShopPanelActionsListener;
   
   private final Text      panelTitle;
   private final Text      currentLvlTxt;
   private final Sprite    perSecondResourceIcon;
//   private final Rectangle upgradeBtn;
//   private final Text      upgradePriceTxt;
//   private final Sprite    upgradePriceIcon;
   
   
   public AClickersShopPanelSkeleton(String title, ITextureRegion perSecondResourceTexture) {
      super(0, 0, 0, 0, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      panelTitle     = new Text(0, 0, ResourceManager.getInstance().getShopTitleFont(), title, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      currentLvlTxt  = new Text(0, 0, ResourceManager.getInstance().getShopTextFont(), "Lvl: 1000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      perSecondResourceIcon = new Sprite(0, 0, 40, 40, perSecondResourceTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(panelTitle);
      attachChild(currentLvlTxt);
      attachChild(perSecondResourceIcon);
      
      setColor(0, 1, 0);
   }
   
   @Override
   public void registerTouchArea(Scene scene) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void attachToParent(Entity parent) {
      panelTitle.setX((getWidth() - panelTitle.getWidth()) / 2);
      panelTitle.setY(PANEL_PADDING);
      
      currentLvlTxt.setX(PANEL_PADDING);
      currentLvlTxt.setY(panelTitle.getY() + panelTitle.getHeight() + 14);
      
      perSecondResourceIcon.setX(getWidth() - PANEL_PADDING - perSecondResourceIcon.getWidth());
      perSecondResourceIcon.setY(panelTitle.getY() + panelTitle.getHeight() + 8);
                  
      
      parent.attachChild(this);
   }   

   @Override
   public void setClickersShopPanelActionsListener(ClickersShopPanelActionsListener clickersShopPanelActionsListener) {
      this.clickersShopPanelActionsListener = clickersShopPanelActionsListener;
   }

}
