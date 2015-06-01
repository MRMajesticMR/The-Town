package ru.majestic.thetown.view.dialogs.shops.panels.buildings.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.IBuildingShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.listeners.BuildingShopPanelActionListener;

public class BuildingShopPanel extends Rectangle implements IBuildingShopPanel, OnClickListener {

   protected static final int HEIGHT   = 80;   
   protected static final int PADDING  = 4;    
   
   private IBuilding                         building;
   private BuildingShopPanelActionListener   buildingShopPanelActionListener;
   
   private Sprite buildingImage;
   private Text   buildingTitle;
   
   private Text   expText;
   private Sprite expImage;
   
   private Text   homeText;
   private Sprite homeImage;
   
   private Text   priceText;
   private Sprite priceImage;
   
   private Text            buildingsCount;   
   private ButtonSprite    buyButton;         
   
   
   public BuildingShopPanel(int x, int y, int width, IBuilding building) {
      super(x, y, width, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setColor(1, 0, 0);
      
      this.building = building;
      
      buildingImage  = new Sprite(PADDING, PADDING, getHeight() - (PADDING * 2), getHeight() - (PADDING * 2), building.getBuildingImage(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager()); 
      buildingTitle  = new Text(buildingImage.getX() + buildingImage.getHeight() + 4, PADDING, ResourceManager.getInstance().getShopBuildingsTitleFont(), building.getTitle(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   
      expImage       = new Sprite(buildingImage.getX() + buildingImage.getWidth() + 4, buildingTitle.getY() + buildingTitle.getHeight() + 15, 30, 25, ResourceManager.getInstance().getExpIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());       
      expText        = new Text(expImage.getX() + expImage.getWidth() + 4, buildingTitle.getY() + buildingTitle.getHeight() + 18, ResourceManager.getInstance().getShopTextFont(), "+" + building.getExp(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      homeImage      = new Sprite(expImage.getX() + expImage.getWidth() + 85, expImage.getY(), 30, 30, ResourceManager.getInstance().getHomeIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      homeText       = new Text(homeImage.getX() + expImage.getWidth() + 4, buildingTitle.getY() + buildingTitle.getHeight() + 18, ResourceManager.getInstance().getShopTextFont(), "+" + building.getHomePlaces(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      priceImage     = new Sprite(homeImage.getX(), PADDING + 5, 30, 30, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      priceText      = new Text(priceImage.getX() + priceImage.getWidth() + 4, PADDING + 8, ResourceManager.getInstance().getShopTextFont(), String.valueOf(building.getWoodCost()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                  
      
      buyButton      = new ButtonSprite(0, 0, ResourceManager.getInstance().getBuyBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      buyButton.setHeight((getHeight() - (PADDING * 2)) / 2);
      buyButton.setWidth(130);
      buyButton.setX(getWidth() - PADDING - buyButton.getWidth());
      buyButton.setY(getHeight() - PADDING - buyButton.getHeight());
      
      buildingsCount = new Text(0, PADDING, ResourceManager.getInstance().getShopTitleFont(), "99999", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      buildingsCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (buildingsCount.getWidth() / 2));
            
      attachChild(buildingImage);
      attachChild(buildingTitle);
      
      attachChild(expImage);
      attachChild(expText);
      
      attachChild(homeImage);
      attachChild(homeText);  
      
      attachChild(priceText);
      attachChild(priceImage);
      
      attachChild(buyButton);
      attachChild(buildingsCount);
      
      buyButton.setOnClickListener(this);
   }

   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(buyButton);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      scene.unregisterTouchArea(buyButton);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == buyButton) {
         buildingShopPanelActionListener.onBuyButtonClicked(building);
         return;
      }
   }

   @Override
   public void setBuildingShopPanelActionListener(BuildingShopPanelActionListener buildingShopPanelActionListener) {
      this.buildingShopPanelActionListener = buildingShopPanelActionListener;
   }

   @Override
   public void update() {
      buildingsCount.setText(String.valueOf(building.getCurrentCount()));
      buildingsCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (buildingsCount.getWidth() / 2));
   }

}
