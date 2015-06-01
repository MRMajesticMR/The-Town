package ru.majestic.thetown.view.dialogs.shops.panels.buildings.impl;

import ru.majestic.thetown.game.homes.impl.Tent;
import ru.majestic.thetown.view.dialogs.shops.panels.buildings.ABuildingShopPanel;

public class TentBuildingsShopPanel extends ABuildingShopPanel {

   public TentBuildingsShopPanel(int x, int y, int width) {
      super(x, y, width, new Tent());
   }

}
