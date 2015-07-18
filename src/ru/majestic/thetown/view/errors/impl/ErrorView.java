package ru.majestic.thetown.view.errors.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.util.modifier.IModifier;
import org.andengine.util.modifier.IModifier.IModifierListener;

import android.graphics.Color;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.errors.IErrorView;
import ru.majestic.thetown.view.errors.animation.ErrorShowAndHideAnimation;

public class ErrorView extends Rectangle implements IErrorView, IModifierListener<IEntity> {

   private ErrorShowAndHideAnimation errorShowAndHideAnimation;
   
   private Text errorText;
   
   public ErrorView() {
      super(0, 120, TheTownCamera.CAMERA_WIDTH, 40, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      errorText = new Text(0, 0, FontsManager.getInstance().getFont(32, Color.parseColor("#FF0000")), "", 50, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());                 
      
      errorShowAndHideAnimation = new ErrorShowAndHideAnimation();
      errorShowAndHideAnimation.addModifierListener(this);
      
      attachChild(errorText);            
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public void show(String message) {
      setVisible(true);
      errorText.setText(message);
      errorText.setX((getWidth() - errorText.getWidth()) / 2);
      errorText.setAlpha(1.0f);
      errorShowAndHideAnimation.reset();
      errorText.registerEntityModifier(errorShowAndHideAnimation);
   }

   @Override
   public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
      //.      
   }

   @Override
   public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
      setVisible(false);
   }

}
