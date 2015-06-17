package ru.majestic.thetown.view.attack.impl;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.game.IAttackManager;
import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.attack.IAttackTimeView;

public class SimpleAttackTimeView extends Rectangle implements IAttackTimeView {

   private static final float WIDTH  = 80;
   private static final float HEIGHT = 60;
   
   private static final int   DEFAULT_TIME_UPDATE = 1;
   
   private Sprite    attackImage;
   private Text      timeText;   
   private Text      attackPowerText;
   
   private IAttackManager attackManager;
   
   private float timeToUpdate;
   
   public SimpleAttackTimeView(float x, float y, IAttackManager attackManager) {
      super(x, y, WIDTH, HEIGHT, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      setAlpha(0.0f);
      
      attackImage    = new Sprite((getWidth() - 40) / 2, 0, 40, 40, ResourceManager.getInstance().getSwordsIconTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());            
      attackPowerText   = new Text(0, attackImage.getY() + attackImage.getHeight() + 4, ResourceManager.getInstance().getCountersFont(), "00000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());      
      timeText       = new Text(0, attackPowerText.getY() + attackPowerText.getHeight() + 2, ResourceManager.getInstance().getCountersFont(), "00:00:00", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      
      attachChild(attackImage);
      attachChild(attackPowerText);
      attachChild(timeText);
      
      this.attackManager   = attackManager;
      this.timeToUpdate    = 0;
   }

   @Override
   public void update() {
      timeText.setText(convertLongToTimeString(attackManager.getAttack().getTimeToNextAttack() - System.currentTimeMillis()));
      attackPowerText.setText(String.valueOf(attackManager.getAttack().getAttackPower()));
      
      timeText.setX((getWidth() - timeText.getWidth()) / 2);
      attackPowerText.setX((getWidth() - attackPowerText.getWidth()) / 2);
   }

   @Override
   public void attachToParent(Entity parent) {
      parent.attachChild(this);
   }
   
   private String convertLongToTimeString(long time) {
      if(time > 0) {
         final int SECOND  = 1000;
         final int MINUTE  = SECOND * 60;
         final int HOUR    = MINUTE * 60;
         
         int hours      = (int) (time / HOUR);
         time -= HOUR * hours;
         
         int minutes    = (int) (time / MINUTE);
         time -= MINUTE * minutes;
         
         int seconds    = (int) (time / SECOND);
         
         StringBuilder builder = new StringBuilder();
         builder.append((hours < 10) ? "0" + hours : hours);
         builder.append(":");
         builder.append((minutes < 10) ? "0" + minutes : minutes);
         builder.append(":");
         builder.append((seconds < 10) ? "0" + seconds: seconds);
         
         return builder.toString();
      } else {
         return "00:00:00";
      }            
   }
   
   @Override
   protected void onManagedUpdate(final float pSecondsElapsed) {
      timeToUpdate -= pSecondsElapsed;
      
      if(timeToUpdate < 0) {
         timeToUpdate = DEFAULT_TIME_UPDATE;
         update();
      }      
   }

}
