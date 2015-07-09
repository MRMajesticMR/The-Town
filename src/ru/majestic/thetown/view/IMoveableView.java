package ru.majestic.thetown.view;

public interface IMoveableView extends IView {
   
   public void       step              (float secondsElapsed);
   public boolean    outOfCameraView   ();

}
