package ru.majestic.thetown.view.dialogs.shops.panels.workers;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;

public abstract class AWorkersShopPanel extends Rectangle implements IWorkersShopPanel {

   public AWorkersShopPanel(IShopDialog shop) {
      super(0, shop.getResoucesShopPanel().getY() + shop.getResoucesShopPanel().getHeight() + 2, shop.getWidth(), shop.getHeight() - shop.getResoucesShopPanel().getY() - shop.getResoucesShopPanel().getHeight() - 64, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      setColor(0, 1, 0);
      setVisible(false);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void show() {
      setVisible(true);      
   }

   @Override
   public void hide() {
      setVisible(false);      
   }

}
