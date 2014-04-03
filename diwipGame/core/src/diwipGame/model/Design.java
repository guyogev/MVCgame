package diwipGame.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/*
 * The game source for design objects
 */
public final class Design {
	public static Texture mainActorTexture = new Texture("fm.jpg");
	public static Skin buttonSkin = new Skin(Gdx.files.internal("uiskin.json"));
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	
	public static void dispose(){
		mainActorTexture.dispose();
		buttonSkin.dispose();
	}
}


