package ru.majestic.thetown.view.dialogs.billing;

import org.andengine.entity.scene.Scene;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.billing.listeners.OnBillingDialogClosedListener;

public interface IBillingResultDialog extends IClickableView {
   
   public enum State {      
      ERROR,
      SUCCESS_TEN_GOLD,
      SUCCESS_HUNDRED_GOLD,
      SUCCESS_THOUSAND_GOLD
   }
   
   public void setOnBillingDialogClosedListener(OnBillingDialogClosedListener onBillingDialogClosedListener);
   
   public boolean isVisible();
   public void show(Scene scene, State state);
   public void hide(Scene scene);

}
