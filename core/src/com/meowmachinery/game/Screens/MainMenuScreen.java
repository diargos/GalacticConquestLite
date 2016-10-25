package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.meowmachinery.game.GalacticConquestLite;

public class MainMenuScreen  extends GameScreen {

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

    Texture backgroundTexture;
    Sprite backgroundSprite;

    Button button;
    private String[][] buttonNames;
    private Button[][] buttonList;
    private Integer menuButtonToggleState;
    private Integer firstRender;
    static final Integer buttonScreenRowCount = 8;
    static final Integer buttonCount = 6; // 6
    static final Integer buttonStyleCount = 3;

    public MainMenuScreen (GalacticConquestLite game, AssetManager assetManager) {
        super (game, assetManager);

        /*
        ButtonStyle style = new ButtonStyle(skin.get(ButtonStyle.class));


        style.up =
                new TextureRegionDrawable(
                    new TextureRegion((Texture) assetManager.get("menu/btnNewGameUp.png")));

        style.over =
                new TextureRegionDrawable(
                    new TextureRegion((Texture)assetManager.get("menu/btnNewGameOver.png")));

        style.down = style.checked =
                new TextureRegionDrawable(
                    new TextureRegion((Texture)assetManager.get("menu/btnNewGameDown.png")));

        button = new Button(style);
        button.setX(Gdx.graphics.getWidth() / 2 + (button.getWidth() / 2));
        button.setY( ( ( Gdx.graphics.getHeight() / buttonScreenRowCount ) * 1 ) + (button.getHeight()));

        stage.addActor(button);
        */
        backgroundTexture = assetManager.get("menu/scrMenuMainBackground.png");
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setPosition(0,0);
        //backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundSprite.setSize(100,100);
        /*
        camera = new OrthographicCamera(); // flat; no perspective
        viewport = new StretchViewport(100,100,camera); // image will match the viewport (which happens to be the window) 100% x 100%
        viewport.apply();
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
        */

        String[] buttonTypes = new String[6];
        buttonTypes[0] = "New";
        buttonTypes[1] = "Continue";
        buttonTypes[2] = "Load";
        buttonTypes[3] = "Option";
        buttonTypes[4] = "About";
        buttonTypes[5] = "Exit";

        String[] buttonStyles = new String[3];
        buttonStyles[0] = "Up";
        buttonStyles[1] = "Over";
        buttonStyles[2] = "Down";

        buttonNames = new String[buttonCount][3];
        buttonList = new Button[buttonCount][3];
        int i, j;

        //Gdx.app.log("Menu Build","Sprite Background width " + spriteBackground.getWidth() + ", height " + spriteBackground.getHeight() );
        for ( i = 0; i < buttonCount; i++) {
            for ( j = 0; j < buttonStyleCount; j++) {
                buttonNames[i][j] = "menu/btn" + buttonTypes[i] + "Game" + buttonStyles[j] + ".png";
            }

                ButtonStyle style = new ButtonStyle(skin.get(ButtonStyle.class));

                style.up =
                        new TextureRegionDrawable(
                                new TextureRegion((Texture) assetManager.get(buttonNames[i][0])));

                style.over =
                        new TextureRegionDrawable(
                                new TextureRegion((Texture) assetManager.get(buttonNames[i][1])));

                style.down = style.checked =
                        new TextureRegionDrawable(
                                new TextureRegion((Texture) assetManager.get(buttonNames[i][2])));

                button = new Button(style);
                //button.setSize(button.getWidth(),button.getHeight());
                //button.setSize(406, 86);
                //button.setX( ( Gdx.graphics.getWidth() / 2 ) + ( button.getWidth() / 2 ) );
                //button.setY( ( ( Gdx.graphics.getHeight() / buttonScreenRowCount ) * ( i + 2 ) ) + ( button.getHeight() ) );
                button.setSize(100/3,100/10);
                button.setX( (100/2) - (100/3/2) );
                button.setY( 100 - ( (100/8)*(i+2.5f) ) );

                stage.addActor(button);

                //textureButton = assetManager.get(buttonNames[i][j], Texture.class);
                buttonList[i][0] = button;
                /*
                Gdx.app.log("Menu Build","Button " + i + ", " + j + " " + buttonNames[i][0]
                        + " Button pos getX/Y " + buttonList[i][0].getX() + ", " + buttonList[i][0].getY() + " x " + ( buttonList[i][0].getX() + buttonList[i][0].getWidth() ) + ", " + ( buttonList[i][0].getY() + buttonList[i][0].getHeight() )
                        + " ( Sprite pos " + ( (button.getWidth() / 2) - (button.getWidth() / 2) ) + ", " + ( (Gdx.graphics.getHeight()/buttonScreenRowCount) * ( i + 2 ) ) + " )");
                */
        }

    }


    @Override
    public void render(float delta) {
        super.render(delta);
        int i;
        /*
        camera.update();
        Gdx.gl.glClearColor(1, 0, (float) 0.99, 1); // set the color values to use for the Clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // this executes all stacked Clears (in this case it is just the color buffer being cleared)
        game.batch.setProjectionMatrix(camera.combined);
        */
        game.batch.begin();
        backgroundSprite.draw(game.batch);
        boolean isOver = false;
        for ( i = 0; i < buttonCount; i++) {
            if ( buttonList[i][0].isOver() ) {
                isOver = true;
                break;
            }
        }
        font.draw(game.batch,
                "Is over: " + isOver,
                (int) (100/16),
                100 - (100/16) + (100/32));
                //(int) (100 * 0.1),
                //100 - (int) (100 * 0.1) );
                //(int) (stage.getWidth() * 0.1),
                //stage.getHeight() - (int) (stage.getHeight() * 0.1) + 100);
        font.draw(game.batch,
                "Pointer position: " + (Gdx.input.getX()) + ", " + (Gdx.input.getY()),
                (int)(100/16),
                100 - ((100/16)*2) + (100/32));
        font.draw(game.batch,
                "Position %: " + ((float)Gdx.input.getX()/(float)(Gdx.graphics.getWidth()-1))*100 + ", " + ((float)Gdx.input.getY()/(float)(Gdx.graphics.getHeight()-1))*100,
                (int)(100/16),
                100 - ((100/16)*3) + (100/32));
        font.draw(game.batch,
                "Screen size: " + (Gdx.graphics.getWidth()) + ", " + (Gdx.graphics.getHeight()),
                (int)(100/16),
                (100/16));
        game.batch.end();
        /*
        for ( i = 0; i < buttonCount; i++) {
            //for ( j = 0; j < 3; j++) {
            buttonList[i][0].draw(game.batch);
            //}
        }
        */
        stage.act();
        stage.draw();

    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);

    }
    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);

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
        backgroundSprite.getTexture().dispose();

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
