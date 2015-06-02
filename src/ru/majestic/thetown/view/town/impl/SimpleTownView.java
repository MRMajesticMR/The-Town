package ru.majestic.thetown.view.town.impl;

import org.andengine.entity.text.Text;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.town.ITown;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.town.ATownView;

public class SimpleTownView extends ATownView {

   private static final int WIDTH   = 200;
   private static final int HEIGHT  = 75;   
   
   private Text lvlTxt;
   private Text expTxt;   
   
   public SimpleTownView(ITown town) {
      super((TheTownCamera.CAMERA_WIDTH - WIDTH) / 2, 50, WIDTH, HEIGHT, town);
      
      lvlTxt      = new Text(0, 0, ResourceManager.getInstance().getCountersFont(), "      ", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      expTxt      = new Text(0, 34, ResourceManager.getInstance().getShopTitleFont(), "                    ", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(lvlTxt);
      attachChild(expTxt);
      
      setAlpha(0.0f);
      
      update();
   }

   @Override
   public void update() {
      lvlTxt.setText("LVL: " + town.getLvl());
      expTxt.setText("EXP: " + town.getCurrentExp() + "/" + town.getExpToNextLvl());
      
      
      lvlTxt.setX((WIDTH - lvlTxt.getWidth()) / 2);
      expTxt.setX((WIDTH - expTxt.getWidth()) / 2);      
   }

}
