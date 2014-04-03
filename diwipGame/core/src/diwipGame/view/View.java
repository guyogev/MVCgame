package diwipGame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import diwipGame.model.Model;

/*
 * The View displays the Model.
 */
public class View {
	private Model model;
	private SpriteBatch batch;

	public View(Model model) {
		this.model = model;
		batch = new SpriteBatch();
	}

	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		model.getStage().draw();
		batch.end();
	}

	public void dispose() {
		batch.dispose();
	}
}
