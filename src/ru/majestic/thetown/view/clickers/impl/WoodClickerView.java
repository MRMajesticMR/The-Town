package ru.majestic.thetown.view.clickers.impl;

import org.andengine.entity.sprite.Sprite;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.AClickerViewSkeleton;

public class WoodClickerView extends AClickerViewSkeleton {

   static final int X = 235;
   static final int Y = 550;
   
   static final float WIDTH    = 255.0f;
   static final float HEIGHT   = WIDTH * 0.85f;
   
   Sprite woodPic;
   
   public WoodClickerView() {
      super(X, Y, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      woodPic = new Sprite(0, 0, getWidth(), getHeight(), ResourceManager.getInstance().getWoodClickerBgndTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(woodPic);
   }

}
