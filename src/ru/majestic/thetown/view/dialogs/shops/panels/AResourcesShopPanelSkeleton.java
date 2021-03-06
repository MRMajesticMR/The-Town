package ru.majestic.thetown.view.dialogs.shops.panels;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.shops.IShopDialog;

public abstract class AResourcesShopPanelSkeleton extends Sprite implements IResourcesShopPanel {

   private static final int PANEL_HEIGHT = 80;
   
   public AResourcesShopPanelSkeleton(IShopDialog shopDialog) {
      super(0, 0, shopDialog.getWidth(), PANEL_HEIGHT, ResourceManager.getInstance().getShopResPanelBackgroundTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

}
