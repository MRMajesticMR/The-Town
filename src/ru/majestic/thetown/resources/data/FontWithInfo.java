package ru.majestic.thetown.resources.data;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.texture.ITexture;

import android.graphics.Typeface;

public class FontWithInfo extends Font {

   private final float  size;
   private final int    color;
   
   public FontWithInfo(FontManager pFontManager, ITexture pTexture, Typeface pTypeface, float pSize, boolean pAntiAlias, int pColor) {
      super(pFontManager, pTexture, pTypeface, pSize, pAntiAlias, pColor);
      
      this.size   = pSize;
      this.color  = pColor;
   }

   public float getSize() {
      return size;
   }

   public int getColor() {
      return color;
   }

}
