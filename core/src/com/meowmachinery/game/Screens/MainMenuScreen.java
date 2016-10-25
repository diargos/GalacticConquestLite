package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.meowmachinery.game.GalacticConquestLite;

public class MainMenuScreen extends GameScreen {

    private String[][] buttonNames;
    private Button[] buttonList;
    static final Integer buttonCount = 6;
    static final Integer buttonStyleCount = 3;
    private int selectedButton = -1;

    public MainMenuScreen (GalacticConquestLite game, AssetManager assetManager) {
        super (game, assetManager);

        Sprite backgroundSprite = new Sprite((Texture) assetManager.get("menu/scrMenuMainBackground.png"));
        backgroundSprite.setPosition(0,0);
        Image background = new Image(backgroundSprite);
        background.setSize(GalacticConquestLite.V_WIDTH, GalacticConquestLite.V_HEIGHT);
        stage.addActor(background);

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

        Button button;
        buttonNames = new String[buttonCount][3];
        buttonList = new Button[buttonCount];
        int i, j;

        for ( i = 0; i < buttonCount; i++) {
            for ( j = 0; j < buttonStyleCount; j++) {
                buttonNames[i][j] = "menu/btn" + buttonTypes[i] + "Game" + buttonStyles[j] + ".png";
            }

            ButtonStyle style = new ButtonStyle(skin.get(ButtonStyle.class));

            style.up =
                    new TextureRegionDrawable(
                            new TextureRegion((Texture) assetManager.get(buttonNames[i][0])));

            style.over = style.checked =
                    new TextureRegionDrawable(
                            new TextureRegion((Texture) assetManager.get(buttonNames[i][1])));

            style.down =
                    new TextureRegionDrawable(
                            new TextureRegion((Texture) assetManager.get(buttonNames[i][2])));

            button = new Button(style);
            button.setSize(GalacticConquestLite.V_WIDTH/3, GalacticConquestLite.V_HEIGHT/10);
            button.setX( (GalacticConquestLite.V_WIDTH/2) - (GalacticConquestLite.V_WIDTH/3/2));
            button.setY( GalacticConquestLite.V_HEIGHT - ( (GalacticConquestLite.V_HEIGHT/8)*(i+2.5f) ) );

            buttonList[i] = button;
            stage.addActor(button);
        }

        setButtonListeners();
    }

    private void setButtonListeners() {
        // New Game button
        buttonList[0].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuNewGame();
            }
        });

        buttonList[1].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuContinueGame();
            }
        });

        buttonList[2].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuLoadGame();
            }
        });

        buttonList[3].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuOptionGame();
            }
        });

        buttonList[4].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuAboutGame();
            }
        });

        buttonList[5].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuExitGame();
            }
        });
    }

    private void menuNewGame() {
        game.setScreen(new NewGameScreen(game, assetManager));
    }

    private void menuContinueGame() {
        System.out.println("Continue most recent saved game");
    }

    private void menuLoadGame() {
        game.setScreen(new LoadGameScreen(game, assetManager));
    }

    private void menuOptionGame() {
        game.setScreen(new OptionsScreen(game, assetManager));
    }

    private void menuAboutGame() {
        game.setScreen(new AboutScreen(game, assetManager));
    }

    private void menuExitGame() {
        Gdx.app.exit();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Keys.UP:
                changeSelection(true);
                break;
            case Keys.DOWN:
                changeSelection(false);
                break;
            case Keys.ENTER:
                handleSelection();
                break;
            default:
        }
        return true;
    }

    private void changeSelection(boolean up) {
        if (selectedButton == -1) {
            selectedButton = 0;
            Button button = buttonList[selectedButton];
            button.setChecked(true);
        } else {
            int previous = selectedButton;

            if (up) {
                selectedButton--;
            } else {
                selectedButton++;
            }

            if (selectedButton > buttonCount - 1) {
                selectedButton = 0;
            }

            if (selectedButton < 0) {
                selectedButton = buttonCount - 1;
            }

            Button button = buttonList[previous];
            button.setChecked(false);
            button = buttonList[selectedButton];
            button.setChecked(true);
        }
    }

    private void handleSelection() {
        switch(selectedButton) {
            case 0:
                menuNewGame();
                break;
            case 1:
                menuContinueGame();
                break;
            case 2:
                menuLoadGame();
                break;
            case 3:
                menuOptionGame();
                break;
            case 4:
                menuAboutGame();
                break;
            case 5:
                menuExitGame();
                break;
            default:
        }
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // Todo: mouse over a button and then using arrows can cause two buttons to be highlighted.
        // Todo: make mouse over change the selectedButton value.
        boolean overAButton = false;
        for (int i = 0; i < buttonList.length; i++) {
            Button button = buttonList[i];

            Vector3 coordinates = new Vector3(screenX, screenY, 0);
            Vector3 newCoord = camera.unproject(coordinates);

            if (newCoord.x >= button.getX() && newCoord.x < button.getX() + button.getWidth()
                   && newCoord.y >= button.getY() && newCoord.y < button.getY() + button.getHeight()) {
                overAButton = true;
            }
        }
        if (overAButton && selectedButton != -1) {
            Button button = buttonList[selectedButton];
            button.setChecked(false);
        }

        return true;
    }
}
