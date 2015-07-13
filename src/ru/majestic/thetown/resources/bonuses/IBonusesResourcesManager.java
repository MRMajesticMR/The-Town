package ru.majestic.thetown.resources.bonuses;

import org.andengine.opengl.texture.region.ITextureRegion;

import ru.majestic.thetown.resources.IResourceManager;

public interface IBonusesResourcesManager extends IResourceManager{
   
   public ITextureRegion         getPlaneTextureRegion();
   public ITextureRegion         getCargoTextureRegion();
   
}
