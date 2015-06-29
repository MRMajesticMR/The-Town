package ru.majestic.thetown.view.dialogs;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.ResourceManager;
import ru.majestic.thetown.view.dialogs.listeners.OnDialogClosedListener;

public abstract class ADialog extends Sprite implements IDialog {

   private OnDialogClosedListener onDialogClosedListener;
   
   public ADialog(float x, float y, float width, float height, ITextureRegion backgroundTexture) {
      super(x, y, width, height, backgroundTexture, ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
   }
   
   protected final void notifyOnDialogClosedListener() {
      if(onDialogClosedListener != null)
         onDialogClosedListener.onDialogClosed(this);
   }

   @Override
   public final void attachToParent(Entity parent) {
      parent.attachChild(this);
   }

   @Override
   public final void setOnDialogClosedListener(OnDialogClosedListener onDialogClosedListener) {
      this.onDialogClosedListener = onDialogClosedListener;
   }

   @Override
   public void show() {
      setVisible(true);
   }

   @Override
   public void hide() {
      setVisible(false);
   }

}
