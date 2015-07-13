package ru.majestic.thetown.view.dialogs.bonus;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.text.Text;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.ADialog;
import ru.majestic.thetown.view.dialogs.bonus.listeners.OnImproveBtnClickedListener;

public abstract class ABonusRewardDialog extends ADialog implements OnClickListener {

   private static final float X              = 30;
   private static final float Y              = 230;
   
   private static final float WIDTH          = 420;
   private static final float HEIGHT         = 200; 
   private static final float PADDING        = 20;
   
   private static final float DEFAULT_CLOSE_BTN_WIDTH    = 100;
   private static final float DEFAULT_CLOSE_BTN_HEIGHT   = 40;   
   
   private static final float DEFAULT_IMPROVE_BTN_WIDTH    = 110;
   private static final float DEFAULT_IMPROVE_BTN_HEIGHT   = 27;
   
   private final Scene           scene;
   
   private final Text            title;
   private final Text            improveNoteTxt;
   
   private final ButtonSprite    closeBtn;
   private final ButtonSprite    improveBtn;
   
   private OnImproveBtnClickedListener onImproveBtnClickedListener;
   
   public ABonusRewardDialog(Scene scene) {
      super(X, Y, WIDTH, HEIGHT, ResourceManager.getInstance().getAttackDialogBgndTextureRegion());
      setVisible(false);
      
      this.scene = scene;
      
      title          = new Text(0, 0, ResourceManager.getInstance().getDialogsResourceManager().getBonusRewardDialogsResourceManager().getBonusDialogTitleFont(), "You've got bonus!", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      improveNoteTxt = new Text(0, 0, ResourceManager.getInstance().getDialogsResourceManager().getBonusRewardDialogsResourceManager().getImproveNoteFont(), "Improve your bonus!", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      closeBtn       = new ButtonSprite(0, 0, ResourceManager.getInstance().getDialogsResourceManager().getCloseButtonTexture(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
      improveBtn     = new ButtonSprite(0, 0, ResourceManager.getInstance().getDialogsResourceManager().getBonusRewardDialogsResourceManager().getImproveButtonTexture(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
            
      title.setX(getTitleXPosition());
      title.setY(getTitleYPosition());
      
      closeBtn.setWidth(DEFAULT_CLOSE_BTN_WIDTH);
      closeBtn.setHeight(DEFAULT_CLOSE_BTN_HEIGHT);
      closeBtn.setX(getCloseBtnXPosition());
      closeBtn.setY(getCloseBtnYPosition());
      
      improveBtn.setWidth(DEFAULT_IMPROVE_BTN_WIDTH);
      improveBtn.setHeight(DEFAULT_IMPROVE_BTN_HEIGHT);
      improveBtn.setX(getImproveBtnXPosition());
      improveBtn.setY(getImproveBtnYPosition());
      
      improveNoteTxt.setX(getImproveNoteXPosition());
      improveNoteTxt.setY(getImproveNoteYPosition());
      
      closeBtn.setOnClickListener(this);
      improveBtn.setOnClickListener(this);
      
      attachChild(title);
      attachChild(closeBtn);
      attachChild(improveBtn);
      attachChild(improveNoteTxt);
   }
   
   private float getTitleXPosition() {
      return (getWidth() - title.getWidth()) / 2;
   }
   
   private float getTitleYPosition() {
      return PADDING;
   }
   
   private float getCloseBtnXPosition() {
      return 60;
   }
   
   private float getCloseBtnYPosition() {
      return 140;
   }
   
   private float getImproveBtnXPosition() {
      return 240;
   }
   
   private float getImproveBtnYPosition() {
      return 147;
   }      
   
   private float getImproveNoteXPosition() {
      return 190;
   }
   
   private float getImproveNoteYPosition() {
      return 120;
   }
   
   @Override
   public void show() {
      scene.registerTouchArea(closeBtn);
      
      if(improveBtn.isVisible())
         scene.registerTouchArea(improveBtn);
      setVisible(true);
   }

   @Override
   public void hide() {
      scene.unregisterTouchArea(closeBtn);
      
      if(improveBtn.isVisible())
         scene.unregisterTouchArea(improveBtn);
      setVisible(false);
   }
   
   public void setOnImproveBtnClickedListener(OnImproveBtnClickedListener onImproveBtnClickedListener) {
      this.onImproveBtnClickedListener = onImproveBtnClickedListener;
   }
   
   @Override
   public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
      if(pButtonSprite == closeBtn) {      
         notifyOnDialogClosedListener();
         return;
      }
      
      if(pButtonSprite == improveBtn) {
         if(onImproveBtnClickedListener != null)
            onImproveBtnClickedListener.onImproveBtnClickedListener();
         return;
      }
   }
   
   public void showImproveButton(boolean show) {
      if(show) {
         closeBtn.setX(getCloseBtnXPosition());         
         improveBtn.setX(getImproveBtnXPosition());
      } else {
         closeBtn.setX((getWidth() - closeBtn.getWidth()) / 2);                  
      }
      
      improveNoteTxt.setVisible(show);
      improveBtn.setVisible(show);
   }

}
