package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;

import android.content.Context;

public interface IFontsManager {   
   
   public void load(Context context, Engine engine);
   
   public Font getFont(int fontSize);
   public Font getFont(int fontSize, int color);
   
}
