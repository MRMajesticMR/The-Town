package ru.majestic.thetown.view;

import org.andengine.entity.Entity;

public interface IView {

   public void attachToParent(Entity parent);

   public float getWidth();
   
}
