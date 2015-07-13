package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;

import android.content.Context;

public interface IResourceManager {

   public void load     (Context context, Engine engine);
   public void unload   ();
   
}
