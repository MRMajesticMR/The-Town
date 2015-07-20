package ru.majestic.thetown.view.dialogs.shops.panels.cargo;

import java.util.HashSet;
import java.util.Set;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.dialogs.utils.IAvailableShadow;
import ru.majestic.thetown.view.dialogs.utils.impl.AvailableShadow;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class ACargoUpgradePanel extends Sprite implements ICargoUpgradePanel {

   public  static final float HEIGHT   = 110;
   
   private static final float PADDING  = 10;
   
   private Sprite          panelTitleImg;
   private Text            panelTitleTxt;   
   
   private Text            priceValueTxt;
   private Sprite          priceImg;
   
   private Text            sizeValueTxt;
   
   private Text            cargoLevelTxt;
   
   private ButtonSprite    upgradeButton;
   
   private IAvailableShadow availableShadow;
   
   private Set<OnCargoUpgradeButtonClickListener> onCargoUpgradeButtonClickListeners;
   
   public ACargoUpgradePanel(float x, float y, float width, ITextureRegion priceTexture, ITextureRegion sizeTexture) {
      super(x, y, width, HEIGHT, ResourceManager.getInstance().getClickersUpgraderBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                  
      
      panelTitleImg     = new Sprite(PADDING, PADDING + 4, 25, 25, sizeTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      panelTitleTxt     = new Text(panelTitleImg.getX() + panelTitleImg.getWidth() + 4, PADDING + 4, FontsManager.getInstance().getFont(18), "CARGO SIZE", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      
      sizeValueTxt      = new Text(PADDING + 21, 42, FontsManager.getInstance().getFont(16), "+100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      priceImg          = new Sprite(PADDING + 4, 68, 22, 22, priceTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      priceValueTxt     = new Text(40, 68, FontsManager.getInstance().getFont(16), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      

      cargoLevelTxt     = new Text(40, 68, FontsManager.getInstance().getFont(20), "100", 10, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeButton     = new ButtonSprite(0, 0, ResourceManager.getInstance().getUpgBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      upgradeButton.setWidth(70);
      upgradeButton.setHeight(35);            
      upgradeButton.setX(getWidth() - upgradeButton.getWidth() - PADDING); 
      upgradeButton.setY(getHeight() - upgradeButton.getHeight() - PADDING);  
      
      cargoLevelTxt.setY(35);
      cargoLevelTxt.setX(upgradeButton.getX() + (upgradeButton.getWidth() / 2) - (cargoLevelTxt.getWidth() / 2));
      
      availableShadow   = new AvailableShadow(0, 0, getWidth(), getHeight());            
            
      attachChild(panelTitleImg);
      attachChild(panelTitleTxt);
      
      attachChild(priceImg);
      attachChild(priceValueTxt);      
      
      attachChild(sizeValueTxt);
      
      attachChild(cargoLevelTxt);
      attachChild(upgradeButton);
      
      availableShadow.attachToParent(this);
      
      onCargoUpgradeButtonClickListeners = new HashSet<ICargoUpgradePanel.OnCargoUpgradeButtonClickListener>();
      
      setAvailable(true);
   }

   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(upgradeButton);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      scene.unregisterTouchArea(upgradeButton);      
   }

   @Override
   public void attachToParent(Entity parent) {      
      parent.attachChild(this);
   }

   @Override
   public void addOnCargoUpgradeButtonClickListener(OnCargoUpgradeButtonClickListener onCargoUpgradeButtonClickListener) {      
      onCargoUpgradeButtonClickListeners.add(onCargoUpgradeButtonClickListener);
   }

   @Override
   public void removeOnCargoUpgradeButtonClickListener(OnCargoUpgradeButtonClickListener onCargoUpgradeButtonClickListener) {      
      onCargoUpgradeButtonClickListeners.remove(onCargoUpgradeButtonClickListener);
   }

   @Override
   public void setAvailable(boolean available) {
      if(available) 
         availableShadow.hide();         
      else 
         availableShadow.show();
   }

   @Override
   public void updateView(long sizeCargoDifference, long nextCargoSizePrice, int currentCargoLevel) {
      sizeValueTxt.setText("+" + BigValueFormatter.format(sizeCargoDifference));
      priceValueTxt.setText(BigValueFormatter.format(nextCargoSizePrice));
      cargoLevelTxt.setText(String.valueOf(currentCargoLevel));
      
      cargoLevelTxt.setX(upgradeButton.getX() + (upgradeButton.getWidth() / 2) - (cargoLevelTxt.getWidth() / 2));
   }

}
