package ru.majestic.thetown.view.menu.buttons.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;
import ru.majestic.thetown.view.menu.buttons.listeners.OnMenuButtonClickedListener;

public class TextMenuButton extends Sprite implements IMenuButton {

   private Text   menuText;
   
   private OnMenuButtonClickedListener onMenuButtonClickedListener;
   
   public TextMenuButton(String text) {
      super(0, 0, 0, 0, ResourceManager.getInstance().getMenuButtonTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      menuText = new Text(0, 0, FontsManager.getInstance().getFont(18), text, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      
      attachChild(menuText);      
      
      setNewTextPosition();
   }
   
   @Override
   public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
   {
       if (pSceneTouchEvent.isActionDown())
       {
          onMenuButtonClickedListener.onMenuButtonClicked(this);
       }
       return true;
   };
   
   @Override
   public void setOnMenuButtonClickedListener(OnMenuButtonClickedListener onMenuButtonClickedListener) {
      this.onMenuButtonClickedListener = onMenuButtonClickedListener;
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
   public void attachToParent(Entity parent) {      
      parent.attachChild(this);
   }

   @Override
   public void setButtonWidth(float width) {
      setWidth(width);
      
      setNewTextPosition();
   }

   @Override
   public void setButtonHeight(float height) {
      setHeight(height);
      
      setNewTextPosition();
   }

   @Override
   public void setButtonX(float x) {
      setX(x);      
   }   
   
   private void setNewTextPosition() {
      menuText.setX((this.getWidth() - menuText.getWidth()) / 2);
      menuText.setY((getHeight() - menuText.getHeight()) / 2);
   }

   @Override
   public void setActive(boolean active) {
      if(active) {
         setColor(0.3f, 1f, 0.3f);
      } else {
         setColor(1, 1, 1);
      }
   }   

}
