package ru.majestic.thetown.view.dialogs.shops.panels.workers.impl;

import ru.majestic.thetown.view.dialogs.shops.IShopDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ASelectWorkerClassShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.ISelectWorkerClassShopPanelButton;
import ru.majestic.thetown.view.dialogs.shops.panels.workers.listeners.OnWorkerClassShopButtonClickedListener;

public class SelectWorkerClassShopPanel extends ASelectWorkerClassShopPanel implements OnWorkerClassShopButtonClickedListener {

   private static final int HEIGHT           = 40;
   private static final int BUTTONS_SPACE    = 2;
   
   private static final int TOTAL_SHOPS_PANEL_COUNT = 3;
   
   private static final int SHOP_INDEX_WOOD         = 0;
   private static final int SHOP_INDEX_FOOD         = 1;   
   private static final int SHOP_INDEX_DEFENECE     = 2;
   
   
   public SelectWorkerClassShopPanel(IShopDialog dialog) {
      super(0, dialog.getHeight() - HEIGHT - 22, dialog.getWidth(), HEIGHT);          
      
      menuButtons = new ISelectWorkerClassShopPanelButton[TOTAL_SHOPS_PANEL_COUNT];
      
      menuButtons[SHOP_INDEX_WOOD]      = new SelectWorkerClassShopPanelButton("WOOD");
      menuButtons[SHOP_INDEX_FOOD]      = new SelectWorkerClassShopPanelButton("FOOD");      
      menuButtons[SHOP_INDEX_DEFENECE]  = new SelectWorkerClassShopPanelButton("DEFENCE");      
      
      for(int i = 0; i < TOTAL_SHOPS_PANEL_COUNT; i++) {         
         menuButtons[i].setOnWorkerClassShopButtonClickedListener(this);
         menuButtons[i].setHeight(HEIGHT);
         menuButtons[i].setWidth((getWidth() - (BUTTONS_SPACE * (menuButtons.length + 1))) / menuButtons.length);
         menuButtons[i].setY(0);
         menuButtons[i].setX(BUTTONS_SPACE + i * (menuButtons[i].getWidth() + BUTTONS_SPACE));
         menuButtons[i].attachToParent(this);   
         
         
      }
            
      menuButtons[SHOP_INDEX_WOOD].setActive(true);      
   }

   @Override
   public void onWorkerClassShopButtonClicked(ISelectWorkerClassShopPanelButton button) {
      for(int i = 0; i < menuButtons.length; i++)
         menuButtons[i].setActive(false);
      
      button.setActive(true);
      for(int i = 0; i < menuButtons.length; i++) {
         if(menuButtons[i] == button)
            onWorkerClassShopSelectedListener.onWorkerClassShopSelectedListener(i);
      }      
   }

}
