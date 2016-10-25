package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.meowmachinery.game.AssetLoader;
import com.meowmachinery.game.GalacticConquestLite;

public class LoadingScreen implements Screen {

    private GalacticConquestLite game;
    private AssetManager assetManager;
    private Texture textureBackground;
    private Sprite spriteBackground;
    private BitmapFont font;

    public LoadingScreen(GalacticConquestLite game, AssetManager assetManager) {
        this.game = game;
        this.assetManager = assetManager;

        textureBackground = new Texture(Gdx.files.internal("menu_background.jpg"));
        spriteBackground = new Sprite(textureBackground);
        spriteBackground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/kenvector_future.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = 12;

        font = generator.generateFont(parameter);
        generator.dispose();

        AssetLoader.loadTextures(assetManager);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (assetManager.update()) {
            //game.setScreen(new OptionsScreen(game, assetManager));
            game.setScreen(new MainMenuScreen(game, assetManager));
            dispose();
        }

        float progress = assetManager.getProgress();

        game.batch.begin();
        spriteBackground.draw(game.batch);
        font.draw(game.batch, "Loading Assets: " + (int)(progress * 100) + "%", spriteBackground.getWidth() / 2 - spriteBackground.getWidth() / 7 , spriteBackground.getHeight() / 12);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        textureBackground.dispose();
        font.dispose();
    }
}
