package ru.majestic.thetown.ads;

import ru.majestic.thetown.ads.listeners.OnAdShowenListener;

public interface IAdsManager {

   public void show();
   public boolean isAdReady();
   public void setOnAdShowenListener(OnAdShowenListener onAdShowenListener);
   
}
