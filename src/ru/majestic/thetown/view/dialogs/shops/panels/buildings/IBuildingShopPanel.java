package ru.majestic.thetown.view.dialogs.shops.panels.buildings;

import ru.majestic.thetown.game.buildings.IBuilding;
import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.listeners.BuildingShopPanelActionListener;

public interface IBuildingShopPanel extends IClickableView {

   public void setBuildingShopPanelActionListener  (BuildingShopPanelActionListener buildingShopPanelActionListener);
   public void update                              ();
   public void setAvailable                        (boolean available);
   public IBuilding getBuilding                    ();
   
}
