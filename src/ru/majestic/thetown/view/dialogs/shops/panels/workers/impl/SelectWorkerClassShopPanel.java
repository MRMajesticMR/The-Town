package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ASelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ISelectWorkerClassShopPanelButton;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopButtonClickedListener;

public class SelectWorkerClassShopPanel extends ASelectWorkerClassShopPanel implements OnWorkerClassShopButtonClickedListener {

   private static final int HEIGHT           = 60;
   private static final int BUTTONS_SPACE    = 2;
   
   private static final int TOTAL_BUTTONS_COUNT = 3;
   
   private static final int BUTTON_INDEX_WOOD         = 0;
   private static final int BUTTON_INDEX_FOOD         = 1;   
   private static final int BUTTON_INDEX_DEFENECE     = 2;
   
   
   public SelectWorkerClassShopPanel(IShopDialog dialog) {
      super(0, dialog.getHeight() - HEIGHT, dialog.getWidth(), HEIGHT);
      
      menuButtons = new ISelectWorkerClassShopPanelButton[TOTAL_BUTTONS_COUNT];
      
      menuButtons[BUTTON_INDEX_WOOD]      = new SelectWorkerClassShopPanelButton("WOOD");
      menuButtons[BUTTON_INDEX_FOOD]      = new SelectWorkerClassShopPanelButton("FOOD");      
      menuButtons[BUTTON_INDEX_DEFENECE]  = new SelectWorkerClassShopPanelButton("DEFENCE");      
      
      for(int i = 0; i < menuButtons.length; i++) {         
         menuButtons[i].setOnWorkerClassShopButtonClickedListener(this);
         menuButtons[i].setHeight(HEIGHT);
         menuButtons[i].setWidth((getWidth() - (BUTTONS_SPACE * (menuButtons.length + 1))) / menuButtons.length);
         menuButtons[i].setY(0);
         menuButtons[i].setX(BUTTONS_SPACE + i * (menuButtons[i].getWidth() + BUTTONS_SPACE));
         menuButtons[i].attachToParent(this);         
      }
   }

   @Override
   public void onWorkerClassShopButtonClicked(ISelectWorkerClassShopPanelButton button) {
      for(int i = 0; i < menuButtons.length; i++)
         menuButtons[i].setActive(false);
      
      button.setActive(true);
   }

}
