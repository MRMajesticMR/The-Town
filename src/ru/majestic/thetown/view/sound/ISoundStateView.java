package ru.majestic.thetown.view.sound;

import ru.majestic.thetown.view.IClickableView;
import ru.majestic.thetown.view.sound.listener.OnSoundStateChangedListener;

public interface ISoundStateView extends IClickableView {
   
   public void setOnSoundStateChangedListener(OnSoundStateChangedListener onSoundStateChangedListener);
   public void setSoundEnaled(boolean enabled);   
   
}
