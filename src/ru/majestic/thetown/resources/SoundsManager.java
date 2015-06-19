package ru.majestic.thetown.resources;

import java.io.IOException;
import java.util.Random;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.audio.sound.SoundManager;

import android.content.Context;

public class SoundsManager {
   
   private Sound     menuClickSound;
   
   private Sound[]   woodClickerClickSound;
   
   public SoundsManager(SoundManager soundManager, Context context) {
      woodClickerClickSound = new Sound[3];
      
      try {
         menuClickSound = SoundFactory.createSoundFromAsset(soundManager, context, "mfx/menu_click.wav");
         
         for(int i = 0; i < woodClickerClickSound.length; i++)
            woodClickerClickSound[i] = SoundFactory.createSoundFromAsset(soundManager, context, "mfx/clickers/wood/wood_clicker_" + (i+1) + ".wav");
         
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public Sound getMenuClickSound() {
      return menuClickSound;
   }

   public Sound getRandomWoodClickerClickSound() {
      Random r = new Random(System.currentTimeMillis());
      return woodClickerClickSound[r.nextInt(3)];
   }

}
