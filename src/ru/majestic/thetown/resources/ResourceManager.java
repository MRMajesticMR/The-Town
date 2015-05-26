package ru.majestic.thetown.resources;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.Context;

public class ResourceManager {

   private static ResourceManager instance;
   
   private Engine engine;
   
   private ITextureRegion  foodClickerBgndTextureRegion;
   private ITextureRegion  woodClickerBgndTextureRegion;
   
   private BitmapTextureAtlas clickersBitmapTextureAtlas;
   
   private ResourceManager() {
      
   }
   
   public static ResourceManager getInstance() {
      if(instance == null)
         instance = new ResourceManager();
      return instance;
   }
   
   public void loadResources(Context context, Engine engine) {
      this.engine = engine;
      
      clickersBitmapTextureAtlas = new BitmapTextureAtlas(engine.getTextureManager(), 256, 128);
      
      foodClickerBgndTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/food_clicker_bgnd.png", 0, 0);
      woodClickerBgndTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(clickersBitmapTextureAtlas, context, "gfx/clickers/wood_clicker_bgnd.png", 128, 0);
      
      clickersBitmapTextureAtlas.load();
   }
   
   public Engine getEngine() {
      return engine;
   }
   
   public ITextureRegion getFoodClickerBgndTextureRegion() {
      return foodClickerBgndTextureRegion;
   }
   
   public ITextureRegion getWoodClickerBgndTextureRegion() {
      return woodClickerBgndTextureRegion;
   }
   
}
