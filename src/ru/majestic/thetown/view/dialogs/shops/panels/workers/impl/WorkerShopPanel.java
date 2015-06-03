package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.workers.IWorker;
import ru.majestic.thetown.game.workers.IWorker.WorkerType;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.IWorkerShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.WorkerShopPanelActionListener;

public class WorkerShopPanel extends Rectangle implements IWorkerShopPanel, OnClickListener {

   private  static final int PADDING  = 4;    
   
   private WorkerShopPanelActionListener workerShopPanelActionListener;
   
   private IWorker worker;    
   
   private Sprite workerImage;
   private Text   workerTitle;
   
   private Text   expText;
   private Sprite expImage;
   
   private Text   resourcePerSecondText;
   private Sprite resourcePerSecondImage;
   
   private Text   priceText;
   private Sprite priceImage;
   
   private Text            workersCount;   
   private ButtonSprite    buyButton;         
   
   
   public WorkerShopPanel(int x, int y, int width, int height, IWorker worker) {
      super(x, y, width, height, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      this.worker = worker;
      
      setColor(1, 0, 0);            
      
      workerImage  = new Sprite(PADDING, PADDING, getHeight() - (PADDING * 2), getHeight() - (PADDING * 2), worker.getWorkerImage(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager()); 
      workerTitle  = new Text(workerImage.getX() + workerImage.getHeight() + 4, PADDING, ResourceManager.getInstance().getShopBuildingsTitleFont(), worker.getTitle(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   
      expImage       = new Sprite(workerImage.getX() + workerImage.getWidth() + 4, workerTitle.getY() + workerTitle.getHeight() + 15, 30, 25, ResourceManager.getInstance().getExpIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());       
      expText        = new Text(expImage.getX() + expImage.getWidth() + 4, workerTitle.getY() + workerTitle.getHeight() + 18, ResourceManager.getInstance().getShopTextFont(), "+" + worker.getExp(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      resourcePerSecondImage      = new Sprite(expImage.getX() + expImage.getWidth() + 85, expImage.getY(), 30, 30, getTextureForResourcePerClick(worker.getType()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      resourcePerSecondText       = new Text(resourcePerSecondImage.getX() + expImage.getWidth() + 4, workerTitle.getY() + workerTitle.getHeight() + 18, ResourceManager.getInstance().getShopTextFont(), "+" + worker.getHomePlaces(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      priceImage     = new Sprite(resourcePerSecondImage.getX(), PADDING + 5, 30, 30, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      priceText      = new Text(priceImage.getX() + priceImage.getWidth() + 4, PADDING + 8, ResourceManager.getInstance().getShopTextFont(), String.valueOf(worker.getFoodCost()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                  
      
      buyButton      = new ButtonSprite(0, 0, ResourceManager.getInstance().getBuyBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      buyButton.setHeight((getHeight() - (PADDING * 2)) / 2);
      buyButton.setWidth(130);
      buyButton.setX(getWidth() - PADDING - buyButton.getWidth());
      buyButton.setY(getHeight() - PADDING - buyButton.getHeight());
      
      workersCount = new Text(0, PADDING, ResourceManager.getInstance().getShopTitleFont(), "99999", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      workersCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (workersCount.getWidth() / 2));
            
      attachChild(workerImage);
      attachChild(workerTitle);
      
      attachChild(expImage);
      attachChild(expText);
      
      attachChild(resourcePerSecondImage);
      attachChild(resourcePerSecondText);  
      
      attachChild(priceText);
      attachChild(priceImage);
      
      attachChild(buyButton);
      attachChild(workersCount);
      
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
      workersCount.setText(String.valueOf(worker.getCurrentCount()));
      workersCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (workersCount.getWidth() / 2));
   }

   @Override
   public void setWorkerShopPanelActionListener(WorkerShopPanelActionListener workerShopPanelActionListener) {
      this.workerShopPanelActionListener = workerShopPanelActionListener;
   }

   
   private ITextureRegion getTextureForResourcePerClick(WorkerType workerType) {
      switch(workerType) {
      case WOOD:
         return ResourceManager.getInstance().getWoodIconTextureRegion();
      case FOOD:
         return ResourceManager.getInstance().getFoodIconTextureRegion();
      case DEFENCE:
         return ResourceManager.getInstance().getHomeIconTextureRegion();
      }
      
      return null;
   }
}
