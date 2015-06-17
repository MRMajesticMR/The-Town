package ru.majestic.thetown.view.attack;

import ru.majestic.thetown.game.attack.IAttack;
import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.attack.listeners.OnAttackDialogClosedListener;

public interface IAttackView extends IClickableView {

   public void setOnAttackDialogClosedListener(OnAttackDialogClosedListener onAttackDialogClosedListener);
   
   public void show           (IAttack attack);
   public void close          ();
   public boolean isVisible   ();
   
}
