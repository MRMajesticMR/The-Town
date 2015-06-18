package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import org.andengine.entity.Entity;
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
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class WorkerShopPanel extends Sprite implements IWorkerShopPanel, OnClickListener {

   private  static final int PADDING  = 8;    
   
   private WorkerShopPanelActionListener workerShopPanelActionListener;
   
   private IWorker worker;    
   
   private Sprite workerImage;
   private Text   workerTitle;
   
   private Text   expText;
   private Sprite expImage;
   
   private Text   resourcePerSecondText;
   private Sprite resourcePerSecondImage;
   
   private Text   priceTitleText;
   private Text   priceText;
   private Sprite priceImage;
   
   private Text   homePriceText;
   private Sprite homePriceImage;
   
   private Text            workersCount;   
   private ButtonSprite    buyButton;         
   
   
   public WorkerShopPanel(int x, int y, int width, int height, IWorker worker) {
      super(x, y, width, height, ResourceManager.getInstance().getShopItemBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      this.worker = worker;       
      
      workerImage  = new Sprite(PADDING, PADDING, getHeight() - (PADDING * 2), getHeight() - (PADDING * 2), worker.getWorkerImage(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager()); 
      workerTitle  = new Text(workerImage.getX() + workerImage.getHeight() + 8, PADDING - 4, ResourceManager.getInstance().getShopBuildingsTitleFont(), worker.getTitle(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());

      expImage       = new Sprite(workerImage.getX() + workerImage.getWidth() + 8, workerTitle.getY() + workerTitle.getHeight(), 21, 16, ResourceManager.getInstance().getExpIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());       
      expText        = new Text(expImage.getX() + expImage.getWidth() + 8, expImage.getY(), ResourceManager.getInstance().getShopTextFont(), "+" + BigValueFormatter.format(worker.getExp()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      resourcePerSecondImage      = new Sprite(workerImage.getX() + workerImage.getWidth() + 8, expImage.getY() + expImage.getHeight() + 4, 16, 16, getTextureForResourcePerClick(worker.getType()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      resourcePerSecondText       = new Text(resourcePerSecondImage.getX() + resourcePerSecondImage.getWidth() + 8, resourcePerSecondImage.getY(), ResourceManager.getInstance().getShopTextFont(), "+" + BigValueFormatter.format(worker.getResourcesPerSec()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());        
      
      priceTitleText = new Text(230, PADDING -4, ResourceManager.getInstance().getShopBuildingsTitleFont(), "price:", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      
      priceImage     = new Sprite(230, expImage.getY(), 16, 16, ResourceManager.getInstance().getFoodIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      priceText      = new Text(priceImage.getX() + priceImage.getWidth() + 4, priceImage.getY() + 2, ResourceManager.getInstance().getShopTextFont(), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                  
      
      homePriceImage = new Sprite(230, priceImage.getY() + priceImage.getHeight() + 2, 16, 16, ResourceManager.getInstance().getHomeIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      homePriceText  = new Text(homePriceImage.getX() + homePriceImage.getWidth() + 4, homePriceImage.getY() + 2, ResourceManager.getInstance().getShopTextFont(), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                        
      
      buyButton      = new ButtonSprite(0, 0, ResourceManager.getInstance().getBuyBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      buyButton.setHeight((getHeight() - (PADDING * 2)) / 2);
      buyButton.setWidth(100);
      buyButton.setX(getWidth() - PADDING - buyButton.getWidth() - 4);
      buyButton.setY(getHeight() - PADDING - buyButton.getHeight() - 4);
      
      workersCount = new Text(0, PADDING - 2, ResourceManager.getInstance().getShopTitleFont(), "99999", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      workersCount.setX(buyButton.getX() + (buyButton.getWidth() / 2) - (workersCount.getWidth() / 2));            
      
      
      attachChild(workerImage);
      attachChild(workerTitle);
      
      attachChild(expImage);
      attachChild(expText);
      
      attachChild(resourcePerSecondImage);
      attachChild(resourcePerSecondText);  
      
      attachChild(priceTitleText);
      
      attachChild(priceText);
      attachChild(priceImage);
      
      attachChild(homePriceText);
      attachChild(homePriceImage);
      
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
         workerShopPanelActionListener.onBuyButtonClicked(worker);
         return;
      }
   }

   @Override
   public void update() {
      priceText.setText(BigValueFormatter.format(worker.getFoodCost()));
      homePriceText.setText(BigValueFormatter.format(worker.getHomePlaces()));
      
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
         return ResourceManager.getInstance().getSwordsIconTextureRegion();
      }
      
      return null;
   }
}
