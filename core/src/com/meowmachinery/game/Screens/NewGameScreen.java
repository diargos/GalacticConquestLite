package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.meowmachinery.game.GalacticConquestLite;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;

public class NewGameScreen extends GameScreen  {

    Preferences prefs;

    public NewGameScreen (GalacticConquestLite game, AssetManager assetManager) {
        super (game, assetManager);
        Sprite backgroundSprite = new Sprite((Texture) assetManager.get("menu/scrMenuMainBackground.png"));
        backgroundSprite.setPosition(0,0);
        Image background = new Image(backgroundSprite);
        background.setSize(GalacticConquestLite.V_WIDTH, GalacticConquestLite.V_HEIGHT);
        stage.addActor(background);
        initNewGameScreen();

    }

    public void initNewGameScreen(){

        Table table = new Table();
        table.setFillParent(true);
        table.center();

        LabelStyle labelStyle = new LabelStyle(fontM, Color.WHITE);
        Label playerNameL = new Label("Player Name:", labelStyle);
        table.add(playerNameL);
        TextFieldStyle playerNameStyle = new TextFieldStyle(skin.get(TextFieldStyle.class));
        playerNameStyle.font = fontL;
        playerNameStyle.fontColor = Color.GREEN;
        TextField playerNameField = new TextField("", playerNameStyle);
        table.add(playerNameField).size(GalacticConquestLite.V_WIDTH/4, GalacticConquestLite.V_HEIGHT/28).pad(0,15,0,0).colspan(4);

        table.row();
        Label playerColorL = new Label("Player Color:", labelStyle);
        table.add(playerColorL).pad(15,0,0,0);
        ButtonStyle btnStyle = new ButtonStyle(skin.get(ButtonStyle.class));
        Button colorBtnRed = new Button(btnStyle);
        Button colorBtnBlue = new Button(btnStyle);
        ButtonGroup colorBtnGroup = new ButtonGroup(colorBtnRed, colorBtnBlue);
        colorBtnGroup.setMaxCheckCount(1);
        colorBtnGroup.setMinCheckCount(1);
        table.add(colorBtnRed).size(GalacticConquestLite.V_WIDTH/50, GalacticConquestLite.V_HEIGHT/40).pad(15,0,0,0);
        table.add(new Label("Red", labelStyle)).pad(15,0,0,0);
        table.add(colorBtnBlue).size(GalacticConquestLite.V_WIDTH/50, GalacticConquestLite.V_HEIGHT/40).pad(15,0,0,0);
        table.add(new Label("Blue", labelStyle)).pad(15,0,0,0);

        table.row();
        Label aiLevelL = new Label("AI Level:", labelStyle);
        table.add(aiLevelL).pad(15,0,0,0);
        Button aiLevelBtnZero = new Button(btnStyle);
        Button aiLevelBtnOne = new Button(btnStyle);
        ButtonGroup aiLevelBtnGroup = new ButtonGroup(aiLevelBtnZero, aiLevelBtnOne);
        aiLevelBtnGroup.setMaxCheckCount(1);
        aiLevelBtnGroup.setMinCheckCount(1);
        aiLevelBtnZero.right();
        table.add(aiLevelBtnZero).size(GalacticConquestLite.V_WIDTH/50, GalacticConquestLite.V_HEIGHT/40).pad(15,0,0,0);
        table.add(new Label("Zero", labelStyle)).pad(15,0,0,0);
        table.add(aiLevelBtnOne).size(GalacticConquestLite.V_WIDTH/50, GalacticConquestLite.V_HEIGHT/40).pad(15,0,0,0);
        table.add(new Label("One", labelStyle)).pad(15,0,0,0);

        Button backBtn = new Button(btnStyle);
        backBtn.setSize(150, 50);
        backBtn.setX(50);
        backBtn.setY(50);
        backBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenuScreen(game, assetManager));
                dispose();
            }
        });

        Button startBtn = new Button(btnStyle);
        startBtn.setSize(150, 50);
        startBtn.setX(GalacticConquestLite.V_WIDTH-200);
        startBtn.setY(50);
        addBtnListen(startBtn);


        stage.addActor(table);
        stage.addActor(backBtn);
        stage.addActor(startBtn);
    }

    public void addBtnListen(Button btn){
        btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("O");
            }
        });
    }

    public void saveNewGamePrefs(){

        //create new file increment name from existing files
        //write widget values to file
        //save file
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);

    }
}
