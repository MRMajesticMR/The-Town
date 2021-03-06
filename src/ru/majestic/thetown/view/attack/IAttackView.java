package ru.majestic.thetown.view.attack;

import java.math.BigInteger;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.attack.listeners.OnAttackDialogClosedListener;

public interface IAttackView extends IClickableView {

   public void setOnAttackDialogClosedListener(OnAttackDialogClosedListener onAttackDialogClosedListener);
   
   public void show           (boolean attackResult, BigInteger wood, BigInteger food);
   public void close          ();
   public boolean isVisible   ();
   
}
