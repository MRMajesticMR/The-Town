package ru.majestic.thetown.view.dialogs.shops.panels.buttons;

import java.math.BigInteger;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.dialogs.shops.panels.buttons.listeners.OnBuyGoldButtonClickedListener;

public interface IBuyGoldButton extends IClickableView {

   public void    setOnBuyGoldButtonClickedListener      (OnBuyGoldButtonClickedListener onBuyGoldButtonClickedListener);
   public int     getIndex                               ();
   public void    setGoldCount                           (BigInteger goldCount);
   public void    setDollarsCount                        (float dollarsCount);
}
