package ru.majestic.thetown.view.counters;

import java.math.BigInteger;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public abstract class ACountWithRpSViewSkeleton extends Rectangle implements ICountWithRpSView {

   private static final int WIDTH   = 140;
   private static final int HEIGHT  = 40;   
   
   protected Text   countText;
   private Text   resourcesPerSecText;
   private Sprite counterImage;
   
   public ACountWithRpSViewSkeleton(float pX, float pY, ITextureRegion imageTexture) {
      super(pX, pY, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      countText            = new Text(32, 0, FontsManager.getInstance().getFont(16), "100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      resourcesPerSecText  = new Text(32, countText.getY() + countText.getHeight() - 4, FontsManager.getInstance().getFont(12), "+100.00AA PS", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
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
   public void changeCount(BigInteger newValue) {
      countText.setText(BigValueFormatter.format(newValue));      
   }

   @Override
   public void updateResourcesPerSecondValue(BigInteger resourcesPerSceonds) {
      resourcesPerSecText.setText("+" + BigValueFormatter.format(resourcesPerSceonds) + " PS");
   }

}
