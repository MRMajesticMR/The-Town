package ru.majestic.thetown.view.dialogs.shops;

import ru.majestic.thetown.view.dialogs.IDialog;
import ru.majestic.thetown.view.dialogs.shops.panels.IBuyGoldShopPanel;
import ru.majestic.thetown.view.dialogs.shops.panels.IResourcesShopPanel;

public interface IShopDialog extends IDialog {

   public void                update                  ();
   public IResourcesShopPanel getResoucesShopPanel    ();
   public IBuyGoldShopPanel   getBuyGoldShopPanel     ();
   
}
