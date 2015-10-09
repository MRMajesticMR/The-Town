package ru.majestic.thetown.resources.impl;

import java.util.HashSet;
import java.util.Set;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;

import ru.majestic.thetown.resources.IFontsManager;
import ru.majestic.thetown.resources.data.FontWithInfo;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;

public class FontsManager implements IFontsManager {

   private static FontsManager instance;
   
   private static final String   FONT_TITLE_MAIN   = "fonts/main.ttf";
   public  static final int      DEFAULT_COLOR     = Color.parseColor("#000000");
   
   private Context   context;
   private Engine    engine;
   
   private Set<FontWithInfo> availableFonts;   
   
   private FontsManager() {
      
   }
   
   public static FontsManager getInstance() {
      if(instance == null)
         instance = new FontsManager();
      
      return instance;
   }
   
   @Override
   public void load(Context context, Engine engine) {
      this.context   = context;
      this.engine    = engine;
      
      availableFonts    = new HashSet<FontWithInfo>();
      
      availableFonts.add(createNewFont(12, DEFAULT_COLOR));
      availableFonts.add(createNewFont(16, DEFAULT_COLOR));
      availableFonts.add(createNewFont(18, DEFAULT_COLOR));
      availableFonts.add(createNewFont(20, DEFAULT_COLOR));
      availableFonts.add(createNewFont(22, DEFAULT_COLOR));
      availableFonts.add(createNewFont(28, DEFAULT_COLOR)); 
      availableFonts.add(createNewFont(32, Color.parseColor("#FF0000")));       
   }
   
   @Override
   public Font getFont(int fontSize) {
      return getFont(fontSize, DEFAULT_COLOR);
   }
   
   @Override
   public Font getFont(int fontSize, int color) {
      FontWithInfo font = getAvailableFont(fontSize, color);
      if(font == null) {
         font = createNewFont(fontSize, color);
         availableFonts.add(font);
      }
      
      Log.d("FONTS_MANAGER", "Founts count: " + availableFonts.size());
      
      return font;
   }
   
   private FontWithInfo getAvailableFont(int fontSize, int color) {
      for(FontWithInfo font: availableFonts) {
         if(font.getSize() == fontSize && font.getColor() == color) {
            return font;
         }
      }
      
      return null;
   }
   
   private FontWithInfo createNewFont(int fontSize, int color) {
      BitmapTextureAtlas textureAtlas = createTextureAtlas(engine);
      FontWithInfo font = new FontWithInfo(engine.getFontManager(), textureAtlas, Typeface.createFromAsset(context.getAssets(), FONT_TITLE_MAIN), fontSize, true, color);

      engine.getTextureManager().loadTexture(textureAtlas);            
      engine.getFontManager().loadFont(font);
      
      return font;
   }
   
   private BitmapTextureAtlas createTextureAtlas(Engine engine) {
      return new BitmapTextureAtlas(engine.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
   }   

}
