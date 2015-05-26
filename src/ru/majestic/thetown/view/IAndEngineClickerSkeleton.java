package ru.majestic.thetown.view;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public class IAndEngineClickerSkeleton extends Sprite implements IClicker {

   public IAndEngineClickerSkeleton(float x, float y, float width, float height, ITextureRegion pTextureRegion, VertexBufferObjectManager pVertexBufferObjectManager) {
      super(x, y, width, height, pTextureRegion, pVertexBufferObjectManager);
   }

   protected OnClickerClickedListener onClickerClickedListener;
   
	@Override
	public void setOnClickerClickedListener(OnClickerClickedListener onClickerClickedListener) {
		this.onClickerClickedListener = onClickerClickedListener;
	}

   @Override
   public void attachToScene(Scene scene) {
      scene.attachChild(this);
   }

}
