package com.meowmachinery.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.meowmachinery.game.GalacticConquestLite;

public class NewGameScreen implements Screen, InputProcessor {

    /*
        New game lets the user set up game configuration.

        Game options:
            - map size
            - density of objects (asteroids, planets, resources)
            - number of players (number of human vs number of AI)
            - multiplayer over network
            - difficulty level
            - player name
            - player faction
            - player color
            - starting locations
            - starting settings (number of units, resources, planets...)
            - enable/disable types of special terrain objects (eg blackholes)
            - mine asteroids, configure asteroids, other object types
            - fog of war options
            - map type
            - victory conditions

        Iteration 0: (these are actually in this screen)
            - player name
            - player color
            - ai difficulty
            - back/main menu button

        Interaction: mouse, four arrow keys, enter, escape (back)
        Next screen: loading/map generation, then into PlayScreen
     */

    private GalacticConquestLite game;
    private AssetManager assetManager;

    public NewGameScreen (GalacticConquestLite game, AssetManager assetManager) {
        this.game = game;
        this.assetManager = assetManager;

        Gdx.input.setInputProcessor(this);
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
}
