package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.meowmachinery.game.GalacticConquestLite;

public class GameScreen implements Screen, InputProcessor {

    protected GalacticConquestLite game;
    protected AssetManager assetManager;

    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected Stage stage;
    protected Skin skin;
    protected BitmapFont font;

    protected int debugType = 0;

    public GameScreen (GalacticConquestLite game, AssetManager assetManager) {
        this.game = game;
        this.assetManager = assetManager;

        camera = new OrthographicCamera();
        //viewport = new FitViewport(GalacticConquestLite.V_WIDTH, GalacticConquestLite.V_HEIGHT, camera);
        viewport = new StretchViewport(GalacticConquestLite.V_WIDTH, GalacticConquestLite.V_HEIGHT, camera);
        viewport.apply();
        //camera.position.set(viewport.getWorldWidth()/2, viewport.getWorldHeight()/2, 0);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0); // aim the focal axis of the camera at the center of the window

        stage = new Stage(viewport, game.batch);
        //game.batch.setProjectionMatrix(camera.combined);

        skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/kenvector_future_thin.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100/25;
        //parameter.color = Color.BLACK;
        parameter.color = Color.WHITE;

        font = generator.generateFont(parameter);
        generator.dispose();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    private String getCoordinates() {

        Vector3 pos = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
        //camera.unproject(pos);

        /*
        switch (debugType) {
            case 0:
                return "Gdx Input: " + Gdx.input.getX() + ", " + Gdx.input.getY();
            case 1:
                return "Unprojected: " + pos.X + ", " + pos.Y;
            case 2:
                return "Virtual: " + viewport.getScreenX()+ ", " + viewport.getScreenY();
            default:
                return "error";
        }
        */
        //return "Virtual: " + viewport.getScreenX()+ ", " + viewport.getScreenY();
        return "Virtual: "; //+ (50) + ", " + (50);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        camera.update();

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        font.draw(game.batch,
                getCoordinates(),
                (int)(20),
                (80));
                //(int)(stage.getWidth() * 0.1),
                //stage.getHeight() - (int)(stage.getHeight() * 0.1));
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update( width,  height, true);
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
        stage.dispose();
        skin.dispose();
        font.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.M) {
            debugType++;
            if (debugType > 2)
                debugType = 0;
        }
        return true;
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
