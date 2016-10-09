package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.meowmachinery.game.GalacticConquestLite;

public class MainMenuScreen implements Screen, InputProcessor {

    /*
        This screen will display a vertical list of buttons, one for
        each screen/option:
            - New Game   (goes to NewGameScreen)
            - Continue Game   (no screen, just loads most recent save file)
            - Load Game  (LoadGameScreen)
            - Options  (OptionsScreen)
            - About    (AboutScreen)
            - Exit      (exits the game, be sure to look up best practices for this)

        Input required: up/down arrows, enter, escape?, mouse
        Goes to different screens depending on option selected.
     */

    private GalacticConquestLite game;
    private AssetManager assetManager;

    public MainMenuScreen (GalacticConquestLite game, AssetManager assetManager) {
        this.game = game;
        this.assetManager = assetManager;

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
