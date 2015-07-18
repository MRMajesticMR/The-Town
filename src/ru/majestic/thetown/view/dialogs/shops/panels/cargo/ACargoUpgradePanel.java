package ru.majestic.thetown.view.dialogs.shops.panels.cargo;

import java.util.HashSet;
import java.util.Set;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.utils.IAvailableShadow;
import ru.majestic.thetown.view.dialogs.utils.impl.AvailableShadow;

public class ACargoUpgradePanel extends Sprite implements ICargoUpgradePanel {

   private static final float HEIGHT   = 100;
   private static final float PADDING  = 20;
   
   private Text            panelTitle;
   
   private Text            priceTitile;
   private Text            priceValue;
   private Sprite          priceImg;
   
   private Text            sizeTitle;
   private Text            sizeValue;
   
   private ButtonSprite    upgradeButton;
   
   private IAvailableShadow availableShadow;
   
   private Set<OnCargoUpgradeButtonClickListener> onCargoUpgradeButtonClickListeners;
   
   public ACargoUpgradePanel(float x, float y, float width, String panelTitle) {
      super(x, y, width, HEIGHT, ResourceManager.getInstance().getClickersUpgraderBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                  
      
//      panelTitle = new Text(0, 0, ResourceManager.getInstance().get, panelTitle, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      availableShadow = new AvailableShadow(0, 0, getWidth(), getHeight());
      
      
      availableShadow.attachToParent(this);
      
      onCargoUpgradeButtonClickListeners = new HashSet<ICargoUpgradePanel.OnCargoUpgradeButtonClickListener>();
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
         availableShadow.show(); 
      else 
         availableShadow.hide();
   }

   @Override
   public void updateView(long nextCargoSize, long nextCargoSizePrice) {
      // TODO Auto-generated method stub
      
   }

}
