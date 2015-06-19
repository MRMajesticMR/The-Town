package ru.majestic.thetown.resources;

import java.io.IOException;
import java.util.Random;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.audio.sound.SoundManager;

import ru.majestic.thetown.game.impl.GameManager;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class SoundsManager {
   
   private static final String SAVE_TAG_SOUND_STATE = "SAVE_TAG_SOUND_STATE";
   
   private Context   context;
   
   private Sound     menuClickSound;   
   private Sound[]   woodClickerClickSound;
   
   public SoundsManager(SoundManager soundManager, Context context) {
      this.context = context;
      
      woodClickerClickSound = new Sound[3];
      
      try {
         menuClickSound = SoundFactory.createSoundFromAsset(soundManager, context, "mfx/menu_click.wav");
         
         for(int i = 0; i < woodClickerClickSound.length; i++)
            woodClickerClickSound[i] = SoundFactory.createSoundFromAsset(soundManager, context, "mfx/clickers/wood/wood_clicker_" + (i+1) + ".wav");
         
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      enableSounds(context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE).getBoolean(SAVE_TAG_SOUND_STATE, true));
   }
   
   public boolean isSoundEnabled() {
      return ResourceManager.getInstance().getEngine().getSoundManager().getMasterVolume() == 1;
   }
   
   public void enableSounds(boolean enable) {
      if(enable)
         ResourceManager.getInstance().getEngine().getSoundManager().setMasterVolume(1.0f);
      else
         ResourceManager.getInstance().getEngine().getSoundManager().setMasterVolume(0.0f);
      
      Editor editor = context.getSharedPreferences(GameManager.PREFFS_NAME, Context.MODE_PRIVATE).edit();      
      editor.putBoolean(SAVE_TAG_SOUND_STATE, enable);
      editor.commit();
   }
   
   public Sound getMenuClickSound() {
      return menuClickSound;
   }

   public Sound getRandomWoodClickerClickSound() {
      Random r = new Random(System.currentTimeMillis());
      return woodClickerClickSound[r.nextInt(3)];
   }

}
