package ru.majestic.thetown.resources.bonuses;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.Context;

public interface IBonusesResourcesManager {

   public void load     (Context context, Engine engine);
   public void unload   ();
   
   public ITextureRegion         getPlaneTextureRegion();
   public ITextureRegion         getCargoTextureRegion();
   
}
