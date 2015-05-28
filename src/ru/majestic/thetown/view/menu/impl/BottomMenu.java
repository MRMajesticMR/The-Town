package ru.majestic.thetown.view.menu.impl;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.menu.IBottomMenu;
import ru.majestic.thetown.view.menu.buttons.IMenuButton;

public class BottomMenu extends Rectangle implements IBottomMenu {

   private static final int MENU_HEIGHT = 80;
   
   private static final int BUTTONS_PADDING = 5;
   
   private List<IMenuButton> buttons;
   
   public BottomMenu() {
      super(0, TheTownCamera.CAMERA_HEIGHT - MENU_HEIGHT, TheTownCamera.CAMERA_WIDTH, MENU_HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      buttons = new ArrayList<IMenuButton>();
   }

   @Override
   public void attachToParent(Entity parent) {
      for(int i = 0; i < buttons.size(); i++) {
         final IMenuButton button = buttons.get(i);
         
         float buttonWidth = getButtonsWidth();
         
         button.setButtonHeight(getHeight());
         button.setButtonWidth(buttonWidth);
         button.setButtonX(BUTTONS_PADDING + (buttonWidth + BUTTONS_PADDING) * i);
         
         button.attachToParent(this);
      }
      parent.attachChild(this);
   }

   @Override
   public void addIMenuButton(IMenuButton menuButton) {
      buttons.add(menuButton);           
   }
   
   private float getButtonsWidth() {
      return (getWidth() - BUTTONS_PADDING * (2 + buttons.size() - 1)) / buttons.size();
   }

}
