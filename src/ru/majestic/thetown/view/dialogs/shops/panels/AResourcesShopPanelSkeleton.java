package ru.majestic.thetown.view.dialogs.shops.panels;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;

public abstract class AResourcesShopPanelSkeleton extends Rectangle implements IResourcesShopPanel {

   private static final int PANEL_HEIGHT = 60;
   
   public AResourcesShopPanelSkeleton(IShopDialog shopDialog) {
      super(0, 44, shopDialog.getWidth(), PANEL_HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

}
