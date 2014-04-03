package diwipGame.model;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

/*
 * the moving object 
 */
public class MainActor extends Image {

	private float dx, dy, speed;

	public MainActor() {
		super(Design.mainActorTexture);
		setX((float) (Math.random()*(800-Design.mainActorTexture.getWidth())));
		setY((float) (Math.random()*(480-Design.mainActorTexture.getHeight())));
		speed = dx = dy = 1;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

}
