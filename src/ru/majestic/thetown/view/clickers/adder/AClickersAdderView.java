package ru.majestic.thetown.view.clickers.adder;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.clickers.animation.AdderHideAnimation;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class AClickersAdderView extends Rectangle implements IClickersAdderView {

   private static final int WIDTH   = 100;
   private static final int HEIGHT  = 40;   
   
   private Text   countText;
   private Sprite counterImage;
   
   public AClickersAdderView(ITextureRegion imageTexture) {
      super(0, 0, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());

      setAlpha(0.0f);
      setVisible(false);
      
      countText      = new Text(44, 6, ResourceManager.getInstance().getAddersFont(), "100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      counterImage   = new Sprite(0, 0, 40, 40, imageTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(countText);
      attachChild(counterImage);            
   }
   
   

   @Override
   public void setValue(long value) {
      countText.setText("+" + BigValueFormatter.format(value));
   }

   @Override
   public void show(float x, float y) {
      setX(x);
      setY(y);
      
      setVisible(true);
      
      countText.setAlpha(1.0f);
      counterImage.setAlpha(1.0f);
      
      countText.setY(y);
      counterImage.setY(y - 6);
      
      AdderHideAnimation adderHideAnimation = new AdderHideAnimation();
    
      countText.registerEntityModifier(adderHideAnimation);
      counterImage.registerEntityModifier(adderHideAnimation);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   

}
