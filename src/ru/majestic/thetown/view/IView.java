package ru.majestic.thetown.view;

import org.andengine.entity.Entity;

public interface IView {

   public void attachToParent(Entity parent);
   
   public float   getHeight  ();
   public float   getWidth   ();
   public void    setHeight  (float height);
   public void    setWidth   (float width);
   
   public float   getX  ();
   public float   getY   ();
   public void    setX  (float x);
   public void    setY   (float y);
   
   
}
