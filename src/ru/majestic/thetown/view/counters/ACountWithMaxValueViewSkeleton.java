package ru.majestic.thetown.view.counters;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;

public class ACountWithMaxValueViewSkeleton extends Rectangle implements ICountWithMaxValueView {

   private static final int WIDTH   = 140;
   private static final int HEIGHT  = 40;   
   
   private int value;
   private int maxValue;
   
   private Text   countText;
   private Sprite counterImage;
   
   public ACountWithMaxValueViewSkeleton(float pX, float pY, ITextureRegion imageTexture) {
      super(pX, pY, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      countText      = new Text(50, 2, ResourceManager.getInstance().getCountersFont(), "0000000/0000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      counterImage   = new Sprite(0, 0, getHeight(), getHeight(), imageTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(countText);
      attachChild(counterImage);
   }
   
   
   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);            
   }


   @Override
   public void changeCount(int newValue) {
      value = newValue;
      updateView();
      
   }

   @Override
   public void onMaxValueChanged(int maxValue) {
      this.maxValue = maxValue;
      updateView();
   }
   
   private void updateView() {
      countText.setText(value + "/" + maxValue);
   }

}
