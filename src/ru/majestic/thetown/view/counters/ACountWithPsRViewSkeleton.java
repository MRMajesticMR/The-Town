package ru.majestic.thetown.view.counters;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;

public abstract class ACountWithPsRViewSkeleton extends Rectangle implements ICountWithPsRView {

   private static final int WIDTH   = 140;
   private static final int HEIGHT  = 40;   
   
   private Text   countText;
   private Text   resourcesPerSecText;
   private Sprite counterImage;
   
   public ACountWithPsRViewSkeleton(float pX, float pY, ITextureRegion imageTexture) {
      super(pX, pY, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      countText            = new Text(50, 2, ResourceManager.getInstance().getCountersFont(), "         ", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      resourcesPerSecText  = new Text(50, countText.getY() + countText.getHeight() + 2, ResourceManager.getInstance().getCountersPerSecondsFont(), "         ", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      counterImage         = new Sprite(0, 0, getHeight(), getHeight(), imageTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(countText);
      attachChild(counterImage);
      attachChild(resourcesPerSecText);
   }
   
   
   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);            
   }


   @Override
   public void changeCount(int newValue) {
      countText.setText(String.valueOf(newValue));
      
   }


   @Override
   public void updateResourcesPerSecondValue(int resourcesPerSceonds) {
      resourcesPerSecText.setText("+" + resourcesPerSceonds + " pS");
   }

}
