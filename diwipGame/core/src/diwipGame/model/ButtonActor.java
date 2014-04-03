package diwipGame.model;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/*
 * UI buttons
 */
public class ButtonActor extends TextButton {

	public ButtonActor(String text, String styleName, float x, float y) {
		super(text, Design.buttonSkin, styleName);
		setWidth(150f);
		setHeight(20f);
		setPosition(x, y);
	}

}
