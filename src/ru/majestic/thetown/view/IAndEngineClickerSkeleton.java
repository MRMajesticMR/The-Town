package ru.majestic.thetown.view;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public class IAndEngineClickerSkeleton extends Sprite implements IClicker {

   protected OnClickerClickedListener onClickerClickedListener;
   
   public IAndEngineClickerSkeleton(float x, float y, float width, float height, ITextureRegion pTextureRegion, VertexBufferObjectManager pVertexBufferObjectManager) {
      super(x, y, width, height, pTextureRegion, pVertexBufferObjectManager);
   }   
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {
          onClickerClickedListener.onClickerClicked(this);
       }
       return true;
   };
   
	@Override
	public void setOnClickerClickedListener(OnClickerClickedListener onClickerClickedListener) {
		this.onClickerClickedListener = onClickerClickedListener;
	}

   @Override
   public void attachToScene(Scene scene) {
      scene.attachChild(this);
      scene.registerTouchArea(this);
   }

}
