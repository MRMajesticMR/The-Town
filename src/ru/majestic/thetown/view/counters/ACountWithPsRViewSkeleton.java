package ru.majestic.thetown.view.counters;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public abstract class ACountWithPsRViewSkeleton extends Rectangle implements ICountWithPsRView {

   private static final int WIDTH   = 140;
   private static final int HEIGHT  = 40;   
   
   private Text   countText;
   private Text   resourcesPerSecText;
   private Sprite counterImage;
   
   public ACountWithPsRViewSkeleton(float pX, float pY, ITextureRegion imageTexture) {
      super(pX, pY, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      countText            = new Text(32, 2, ResourceManager.getInstance().getCountersFont(), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      resourcesPerSecText  = new Text(32, countText.getY() + countText.getHeight() + 2, ResourceManager.getInstance().getCountersPerSecondsFont(), "+100.00AA PS", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      counterImage         = new Sprite(0, 4, 30, 30, imageTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(countText);
      attachChild(counterImage);
      attachChild(resourcesPerSecText);
   }
   
   
   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);            
   }


   @Override
   public void changeCount(long newValue) {
      countText.setText(BigValueFormatter.format(newValue));
      
   }


   @Override
   public void updateResourcesPerSecondValue(int resourcesPerSceonds) {
      resourcesPerSecText.setText("+" + BigValueFormatter.format(resourcesPerSceonds) + " PS");
   }

}
