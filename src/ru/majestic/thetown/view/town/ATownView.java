package ru.majestic.thetown.view.town;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.game.town.ITown;
import ru.majestic.thetown.resources.ResourceManager;

public abstract class ATownView extends Rectangle implements ITownView {

   protected ITown town;
   
   public ATownView(float pX, float pY, float pWidth, float pHeight, ITown town) {
      super(pX, pY, pWidth, pHeight, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      this.town = town;
   }   
   
   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

}
