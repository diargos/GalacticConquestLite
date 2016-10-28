package com.meowmachinery.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.meowmachinery.game.Screens.LoadingScreen;

public class GalacticConquestLite extends Game {

	public static final int V_WIDTH = 1000;
	public static final int V_HEIGHT = 800;

	public SpriteBatch batch;
	private AssetManager assetManager;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		setScreen(new LoadingScreen(this, assetManager));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		assetManager.dispose();
	}
}
