package ru.majestic.thetown.view.clickers;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public abstract class AClickerViewSkeleton extends Rectangle implements IClickerView {

   protected OnClickerClickedListener onClickerClickedListener;
   
   public AClickerViewSkeleton(float x, float y, float width, float height, VertexBufferObjectManager pVertexBufferObjectManager) {
      super(x, y, width, height, pVertexBufferObjectManager);
      
      setAlpha(0.0f);
   }   
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float x, float y) 
   {
       if (pSceneTouchEvent.isActionUp())
       {                   
          onClickerClickedListener.onClickerClicked(x, y, this);
       }
       return true;
   };
   
	@Override
	public void setOnClickerClickedListener(OnClickerClickedListener onClickerClickedListener) {
		this.onClickerClickedListener = onClickerClickedListener;
	}

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
      
   }

   @Override
   public void registerTouchArea(Scene scene) {
      scene.registerTouchArea(this);      
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      scene.unregisterTouchArea(this);
   }      

}
