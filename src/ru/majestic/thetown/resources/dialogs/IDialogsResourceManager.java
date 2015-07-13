package ru.majestic.thetown.resources.dialogs;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import ru.majestic.thetown.resources.IResourceManager;
import ru.majestic.thetown.resources.dialogs.bonus.IBonusRewardDialogsResourceManager;

public interface IDialogsResourceManager extends IResourceManager {   
   
   public ITextureRegion      getDialogBackground     ();
   public ITiledTextureRegion getCloseButtonTexture   ();
   
   public IBonusRewardDialogsResourceManager getBonusRewardDialogsResourceManager();
}
