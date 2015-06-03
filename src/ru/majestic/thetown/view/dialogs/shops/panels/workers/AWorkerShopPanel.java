package ru.majestic.thetown.view.dialogs.shops.panels.workers;

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
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public abstract class AWorkerShopPanel extends Rectangle implements IWorkerShopPanel, OnClickListener {

   public   static final int HEIGHT   = 80;   
   private  static final int PADDING  = 4;    
   
   protected WorkerShopPanelActionListener workerShopPanelActionListener;
   
   private Sprite workerImage;
   private Text   workerTitle;
   
   private Text   expText;
   private Sprite expImage;
   
   private Text   resourcePerSecondText;
   private Sprite resourcePerSecondImage;
   
   private Text   priceText;
   private Sprite priceImage;
   
   private Text            buildingsCount;   
   private ButtonSprite    buyButton;         
   
   
   public AWorkerShopPanel(int x, int y, int width, IBuilding building) {
      super(x, y, width, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setColor(1, 0, 0);
      
      workerImage  = new Sprite(PADDING, PADDING, getHeight() - (PADDING * 2), getHeight() - (PADDING * 2), building.getBuildingImage(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager()); 
      workerTitle  = new Text(workerImage.getX() + workerImage.getHeight() + 4, PADDING, ResourceManager.getInstance().getShopBuildingsTitleFont(), building.getTitle(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   
      expImage       = new Sprite(workerImage.getX() + workerImage.getWidth() + 4, workerTitle.getY() + workerTitle.getHeight() + 15, 30, 25, ResourceManager.getInstance().getExpIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());       
      expText        = new Text(expImage.getX() + expImage.getWidth() + 4, workerTitle.getY() + workerTitle.getHeight() + 18, ResourceManager.getInstance().getShopTextFont(), "+" + building.getExp(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      resourcePerSecondImage      = new Sprite(expImage.getX() + expImage.getWidth() + 85, expImage.getY(), 30, 30, ResourceManager.getInstance().getHomeIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      resourcePerSecondText       = new Text(resourcePerSecondImage.getX() + expImage.getWidth() + 4, workerTitle.getY() + workerTitle.getHeight() + 18, ResourceManager.getInstance().getShopTextFont(), "+" + building.getHomePlaces(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      priceImage     = new Sprite(resourcePerSecondImage.getX(), PADDING + 5, 30, 30, ResourceManager.getInstance().getWoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      priceText      = new Text(priceImage.getX() + priceImage.getWidth() + 4, PADDING + 8, ResourceManager.getInstance().getShopTextFont(), String.valueOf(building.getWoodCost()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                  
      
      buyButton      = new ButtonSprite(0, 0, ResourceManager.getInstance().getBuyBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      buyButton.setHeight((getHeight() - (PADDING * 2)) / 2);
      buyButton.setWidth(130);
      buyButton.setX(getWidth() - PADDING - buyButton.getWidth());
      buyButton.setY(getHeight() - PADDING - buyButton.getHeight());
      
      buildingsCount = new Text(0, PADDING, ResourceManager.getInstance().getShopTitleFont(), "99999", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      buildingsCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (buildingsCount.getWidth() / 2));
            
      attachChild(workerImage);
      attachChild(workerTitle);
      
      attachChild(expImage);
      attachChild(expText);
      
      attachChild(resourcePerSecondImage);
      attachChild(resourcePerSecondText);  
      
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
//         buildingShopPanelActionListener.onBuyButtonClicked(building);
         return;
      }
   }

   @Override
   public void update() {
//      buildingsCount.setText(String.valueOf(building.getCurrentCount()));
//      buildingsCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (buildingsCount.getWidth() / 2));
   }

   @Override
   public void setWorkerShopPanelActionListener(WorkerShopPanelActionListener workerShopPanelActionListener) {
      this.workerShopPanelActionListener = workerShopPanelActionListener;
   }

}
