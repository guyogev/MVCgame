package diwipGame.model;

import java.util.Hashtable;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

/*
 * The Model is the game data structure.
 */
public class Model {
	private MainActor mainActor;
	private Hashtable<String, Button> buttons;
	private static Stage stage;

	public Model() {
		stage = new Stage();
		buttons = new Hashtable<String, Button>();
		mainActor = new MainActor();
		stage.addActor(mainActor);		
	}

	public MainActor getMainActor() {
		return mainActor;
	}

	public Stage getStage() {
		return stage;
	}
	
	public Hashtable<String, Button> getButtons() {
		return buttons;
	}

	public static void dispose() {
		stage.dispose();
		Design.dispose();
	}
}
