package ru.majestic.thetown.view.dialogs.shops.panels.workers.market;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.game.market.IMarketItem;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.market.listeners.OnMarketItemBuyBtnClickedListener;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public abstract class AMarketItemPanel extends Sprite implements IMarketItemPanel,
                                                                    OnClickListener {

   private static final int MARGIN = 4;
   private static final int PADDING = 8;
   private static final int HIEGHT  = 80;
   
   private OnMarketItemBuyBtnClickedListener onMarketItemBuyBtnClickedListener;

   private IMarketItem     marketItem;
   
   private Sprite          priceImage;   
   private Text            priceCountText;
   
   private Sprite          goodImage;   
   private Text            goodCountText;
      
   private ButtonSprite    buyButton;
   
   public AMarketItemPanel(float x, float y, IShopDialog shopDialog, ITextureRegion goodTextureRegion, IMarketItem marketItem) {
      super(x, y, (shopDialog.getWidth() - MARGIN) / 2, HIEGHT, ResourceManager.getInstance().getShopItemBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      this.marketItem   = marketItem;
      
      priceImage        = new Sprite(PADDING + 4, PADDING + 4, 26, 26, ResourceManager.getInstance().getGoldIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      priceCountText    = new Text(priceImage.getX() + priceImage.getWidth() + 4, priceImage.getY() + 4, ResourceManager.getInstance().getShopTextFont(), BigValueFormatter.format(marketItem.getGoldPrice()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      goodImage         = new Sprite(priceImage.getX(), priceImage.getY() + priceImage.getHeight() + 4, 26, 26, goodTextureRegion, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      goodCountText     = new Text(goodImage.getX() + goodImage.getWidth() + 4, goodImage.getY() + 4, ResourceManager.getInstance().getShopTextFont(), BigValueFormatter.format(marketItem.getProductCount()), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      buyButton         = new ButtonSprite(0, 0, ResourceManager.getInstance().getBuyBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      buyButton.setHeight((getHeight() - (PADDING * 2)) / 2);
      buyButton.setWidth(100);
      buyButton.setX(getWidth() - PADDING - buyButton.getWidth());
      buyButton.setY(getHeight() - PADDING - buyButton.getHeight());
      
      attachChild(priceImage);
      attachChild(priceCountText);
      
      attachChild(goodImage);
      attachChild(goodCountText);
      
      attachChild(buyButton);
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
   public void setOnMarketItemBuyBtnClickedListener(OnMarketItemBuyBtnClickedListener onMarketItemBuyBtnClickedListener) {
      this.onMarketItemBuyBtnClickedListener = onMarketItemBuyBtnClickedListener;
   }

   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      onMarketItemBuyBtnClickedListener.onMarketItemBuyBtnClicked(marketItem);
   }

}
