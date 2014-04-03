package diwipGame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/*
 * The game source for design objects
 * you can change the mainActor design here.
 */
public final class Design {
	
	public static Texture mainActorTexture = new Texture("fm.jpg"); 
	//you can change to to any other image from the android.assets folder
	public static Skin buttonSkin = new Skin(Gdx.files.internal("uiskin.json"));
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	
	public static void dispose(){
		mainActorTexture.dispose();
		buttonSkin.dispose();
	}
}


