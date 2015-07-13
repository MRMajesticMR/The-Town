package ru.majestic.thetown.resources.dialogs.bonus;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.IResourceManager;

public interface IBonusRewardDialogsResourceManager extends IResourceManager {
   
   public ITiledTextureRegion getImproveButtonTexture ();
   public ITextureRegion      getImproveNoteTexture   ();
   
   public Font                getBonusDialogTitleFont ();
   public Font                getImproveNoteFont      ();
   
   public Font                getBonusDialogMessageFont  ();

}
