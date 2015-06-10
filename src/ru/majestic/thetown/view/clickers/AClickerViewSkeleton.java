package ru.majestic.thetown.view.clickers;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import ru.majestic.thetown.view.listeners.OnClickerClickedListener;

public abstract class AClickerViewSkeleton extends Sprite implements IClickerView {

   protected OnClickerClickedListener onClickerClickedListener;
   
   private List<IClickersAdderView> addersViews;
   
   public AClickerViewSkeleton(float x, float y, float width, float height, ITextureRegion pTextureRegion, VertexBufferObjectManager pVertexBufferObjectManager) {
      super(x, y, width, height, pTextureRegion, pVertexBufferObjectManager);
      
      addersViews = new ArrayList<IClickersAdderView>();
   }   
   
   protected abstract IClickersAdderView getClickersAdderView();
   
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

   @Override
   public void showAdder(float x, float y, long value) {
      IClickersAdderView adderView = getAdderFromInvisible();
      if(adderView == null) {
         adderView = getClickersAdderView();
         adderView.attachToParent(this);
         
         addersViews.add(adderView);             
      }
      
      adderView.setValue(value);
      adderView.show(x, y);
   }
   
   private IClickersAdderView getAdderFromInvisible() {
      for(IClickersAdderView adder: addersViews) {
         if(!adder.isVisible())
            return adder; 
      }
      
      return null;
   }

}
