package ru.majestic.thetown.resources.bonuses;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.IResourceManager;

public interface IBonusesResourcesManager extends IResourceManager{
   
   public ITextureRegion         getPlaneTextureRegion();
   public ITiledTextureRegion    getCargoTextureRegion();
   
}
