package ru.majestic.thetown.view.menu.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.menu.IShopsMenu;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;
import ru.majestic.thetown.view.menu.buttons.impl.TextMenuButton;
import ru.majestic.thetown.view.menu.buttons.listeners.OnMenuButtonClickedListener;
import ru.majestic.thetown.view.menu.listeners.OnShopsMenuButtonClickedListener;

public class ShopsMenu extends Rectangle implements IShopsMenu, OnMenuButtonClickedListener {

   private static final int MENU_HEIGHT = 60;
   
   private static final int BUTTONS_PADDING = 5;
   
   private static final int BUTTONS_COUNT = 4;
   
   private static final int BUTTONS_INDEX_CLICKERS    = 0;
   private static final int BUTTONS_INDEX_BUILDINGS   = 1;
   private static final int BUTTONS_INDEX_WORKERS     = 2;   
   private static final int BUTTONS_INDEX_GOLD        = 3;
   
   private OnShopsMenuButtonClickedListener onShopsMenuButtonClickedListener;
   
   private IMenuButton[] buttons;
   
   public ShopsMenu() {
      super(0, TheTownCamera.CAMERA_HEIGHT - MENU_HEIGHT, TheTownCamera.CAMERA_WIDTH, MENU_HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      buttons = new IMenuButton[BUTTONS_COUNT];
      
      buttons[BUTTONS_INDEX_CLICKERS]    = new TextMenuButton("Clickers");
      buttons[BUTTONS_INDEX_BUILDINGS]   = new TextMenuButton("Buildings");
      buttons[BUTTONS_INDEX_WORKERS]     = new TextMenuButton("Workers");      
      buttons[BUTTONS_INDEX_GOLD]        = new TextMenuButton("Gold");
      
      for(IMenuButton button: buttons)
         button.setOnMenuButtonClickedListener(this);
   }

   @Override
   public void attachToParent(Entity parent) {
      for(int i = 0; i < buttons.length; i++) {
         final IMenuButton button = buttons[i];
         
         float buttonWidth = getButtonsWidth();
         
         button.setButtonHeight(getHeight() - BUTTONS_PADDING);
         button.setButtonWidth(buttonWidth);
         button.setButtonX(BUTTONS_PADDING + (buttonWidth + BUTTONS_PADDING) * i);
         
         button.attachToParent(this);
      }
      parent.attachChild(this);
   }
   
   private float getButtonsWidth() {
      return (getWidth() - BUTTONS_PADDING * (2 + buttons.length - 1)) / buttons.length;
   }
   
   @Override
   public void registerTouchArea(Scene scene) {
      for(IMenuButton button: buttons) 
         button.registerTouchArea(scene);
   }

   @Override
   public void unregisterTouchArea(Scene scene) {
      for(IMenuButton button: buttons) 
         button.unregisterTouchArea(scene);      
   }

   @Override
   public void onMenuButtonClicked(IMenuButton menuButton) {
      clearAllSelection();
      
      menuButton.setActive(true);
      for(int menuIndex = 0; menuIndex < buttons.length; menuIndex++) {
         if(menuButton == buttons[menuIndex]) {
            onShopsMenuButtonClickedListener.onNeedOpenShopDialog(menuIndex);
            return;
         }
      }             
   }

   @Override
   public void setOnShopsMenuButtonClickedListener(OnShopsMenuButtonClickedListener onShopsMenuButtonClickedListener) {
      this.onShopsMenuButtonClickedListener = onShopsMenuButtonClickedListener;
   }

   @Override
   public void clearAllSelection() {
      for(IMenuButton button: buttons)
         button.setActive(false);      
   }

   

}
