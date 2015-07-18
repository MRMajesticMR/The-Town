package ru.majestic.thetown.view.town.impl;

import org.andengine.entity.text.Text;

import ru.majestic.thetown.andengine.TheTownCamera;
import ru.majestic.thetown.game.town.ITown;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.resources.impl.FontsManager;
import ru.majestic.thetown.view.town.ATownView;
import ru.majestic.thetown.view.utils.BigValueFormatter;

public class SimpleTownView extends ATownView {

   private static final int WIDTH   = 200;
   private static final int HEIGHT  = 16;   
   
   private Text lvlTxt;
   private Text expTxt;   
   
   public SimpleTownView(ITown town) {
      super((TheTownCamera.CAMERA_WIDTH - WIDTH) / 2, 60, WIDTH, HEIGHT, town);
      
      lvlTxt      = new Text(0, 0, FontsManager.getInstance().getFont(12), "LVL: 1000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      expTxt      = new Text(0, 0, FontsManager.getInstance().getFont(12), "100.00AA/100.00AA", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(lvlTxt);
      attachChild(expTxt);
      
      setAlpha(1.0f);
      
      update();
   }

   @Override
   public void update() {
      lvlTxt.setText("LVL: " + town.getLvl());
      expTxt.setText(BigValueFormatter.format(town.getCurrentExp()) + "/" + BigValueFormatter.format(town.getExpToNextLvl()));
      
      
      lvlTxt.setX(2);
      expTxt.setX(WIDTH - expTxt.getWidth() - 2);      
   }

}
