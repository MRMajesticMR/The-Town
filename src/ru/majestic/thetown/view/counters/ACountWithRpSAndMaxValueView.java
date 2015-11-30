package ru.majestic.thetown.view.counters;

import java.math.BigInteger;

import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class ACountWithRpSAndMaxValueView extends ACountWithRpSViewSkeleton implements ICountWithRpSAndMaxValueView {

   private Text maxValueText;
   
   public ACountWithRpSAndMaxValueView(float pX, float pY, ITextureRegion imageTexture) {
      super(pX, pY, imageTexture);
      
      maxValueText = new Text(0, 0, FontsManager.getInstance().getFont(16), "100.00AA", 25, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(maxValueText);
   }

   @Override
   public void onMaxValueChanged(BigInteger maxValue) {
      maxValueText.setText("/" + BigValueFormatter.format(maxValue));
      
      maxValueText.setX(countText.getX() + countText.getWidth() + 2);
   }

}
