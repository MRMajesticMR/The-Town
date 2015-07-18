package ru.majestic.thetown.view.counters;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class ACountWithMaxValueViewSkeleton extends Rectangle implements ICountWithMaxValueView {

   private static final int WIDTH = 140;
   private static final int HEIGHT = 40;

   private long value;
   private long maxValue;

   private Text countText;
   private Sprite counterImage;

   public ACountWithMaxValueViewSkeleton(float pX, float pY, ITextureRegion imageTexture) {
      super(pX, pY, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());

      setAlpha(0.0f);

      countText = new Text(34, 4, FontsManager.getInstance().getFont(16), "100.00AA/100.00AA", ResourceManager.getInstance().getEngine()
            .getVertexBufferObjectManager());
      counterImage = new Sprite(0, 0, 30, 30, imageTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());

      attachChild(countText);
      attachChild(counterImage);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void changeCount(long newValue) {
      value = newValue;
      updateView();

   }

   @Override
   public void onMaxValueChanged(long maxValue) {
      this.maxValue = maxValue;
      updateView();
   }

   private void updateView() {
      countText.setText(BigValueFormatter.format(value) + "/" + BigValueFormatter.format(maxValue));
   }

}
