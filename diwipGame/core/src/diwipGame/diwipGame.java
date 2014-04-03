package diwipGame;

import com.badlogic.gdx.ApplicationAdapter;

import diwipGame.controller.Controller;
import diwipGame.model.Model;
import diwipGame.view.View;

/*
 * Mini MVC game.
 * Model is the game data structure.
 * View is responsible of displaying the Model.
 * Controller is the game logic. it handles input & change the Model.
 */
public class diwipGame extends ApplicationAdapter {

	Model model;
	View view;
	Controller controller;

	@Override
	public void create() {
		model = new Model(); //Model is unaware to the world
		view = new View(model); //view is aware of model
		controller = new Controller(model, view); //controller is aware of model & view
	}

	@Override
	public void render() {
		view.render();
		controller.update();
	}

	@Override
	public void dispose() {
		Model.dispose();
		view.dispose();
	}

}
