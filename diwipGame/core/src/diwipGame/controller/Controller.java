package diwipGame.controller;

import java.util.Hashtable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import diwipGame.model.ButtonActor;
import diwipGame.model.Design;
import diwipGame.model.MainActor;
import diwipGame.model.Model;
import diwipGame.view.View;

/*
 * the Controller handles the game logic.
 */
public class Controller {

	private Model model;
	private int ticks;
	final private int REFRESH_RATE = 50;

	public Controller(Model model, View view) {

		this.model = model;
		Stage stage = model.getStage();

		//speedUp
		TextButton speedUp = new ButtonActor("speedUp", "default", Design.WIDTH - 180, 50);
		speedUp.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				incSpeed();
			}
		});
		//speedDown
		TextButton speedDown = new ButtonActor("speedDown", "default", Design.WIDTH - 180, 25);
		speedDown.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				decSpeed();
			}
		});
		//sizeDown
		TextButton sizeDown = new ButtonActor("sizeDown", "default", 30, 25);
		sizeDown.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				sizeDown();
			}
		});
		//sizeUp
		TextButton sizeUp = new ButtonActor("sizeUp", "default", 30, 50);
		sizeUp.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				sizeUp();
			}
		});

		//add buttons to model for later access, like changing the default positioning & size
		Hashtable<String, Button> buttons = model.getButtons();
		buttons.put("speedUp", speedUp);
		buttons.put("speedDown", speedDown);
		buttons.put("sizeDown", sizeDown);
		buttons.put("sizeUp", sizeUp);
		
		// add buttons to display
		stage.addActor(speedUp);
		stage.addActor(speedDown);
		stage.addActor(sizeUp);
		stage.addActor(sizeDown);
		// let stage accept input
		Gdx.input.setInputProcessor(stage);
	}
	

	/*
	 * Increases the size of mainActor.
	 */
	private void sizeUp() {
		MainActor a = model.getMainActor();
		float w = 2 * a.getWidth();
		float h = 2 * a.getHeight();
		if (w < Design.WIDTH/2 && h < Design.HEIGHT/2) {
			// reset position if new size is out of bound
			float x = Math.min(a.getX(), Design.WIDTH - w);
			float y = Math.min(a.getY(), Design.HEIGHT - h);
			a.setBounds(x, y, w, h);
		}
	}

	/*
	 * Decreases the size of mainActor.
	 */
	private void sizeDown() {
		MainActor a = model.getMainActor();
		float w = a.getWidth();
		float h = a.getHeight();
		if (w > 20 && h > 20)
			a.setBounds(a.getX() + w / 4, a.getY() + h / 4, w / 2, h / 2);
	}

	/*
	 * Decreases the speed of mainActor. if speed==1, reverse movement
	 * direction.
	 */
	private void decSpeed() {
		float s = model.getMainActor().getSpeed();
		if (s > 1)
			model.getMainActor().setSpeed(--s);
		else {
			// reverse direction
			model.getMainActor().setDx(-model.getMainActor().getDx());
			model.getMainActor().setDy(-model.getMainActor().getDy());
		}
	}

	/*
	 * Increases the speed of mainActor. if speed==1, reverse movement
	 * direction.
	 */
	private void incSpeed() {
		float s = model.getMainActor().getSpeed();
		if (s < 10)
			model.getMainActor().setSpeed(++s);
	}

	/*
	 * Update the model state.
	 * the movement direction is randomly changed every REFRESH_RATE ticks.
	 * reset movement direction if the mainActor is out of bound
	 */
	public void update() {
		ticks++;
		MainActor a = model.getMainActor();

		// change direction randomly
		if (ticks % REFRESH_RATE == 0) {
			if (Math.random() < .5)
				a.setDx(-a.getDx());
			if (Math.random() < .5)
				a.setDy(-a.getDy());
		}

		// reverse dx\dy if reached end of display
		if (a.getX() < 0)
			a.setDx(Math.abs(a.getDx()));
		else if (a.getRight() > Design.WIDTH)
			a.setDx(-Math.abs(a.getDx()));
		if (a.getY() < 0)
			a.setDy(Math.abs(a.getDy()));
		else if (a.getTop() > Design.HEIGHT)
			a.setDy(-Math.abs(a.getDy()));

		// reset position
		a.setX(a.getX() + a.getDx() * a.getSpeed());
		a.setY(a.getY() + a.getDy() * a.getSpeed());
	}

}
