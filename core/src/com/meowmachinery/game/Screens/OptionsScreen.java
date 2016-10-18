package com.meowmachinery.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.meowmachinery.game.GalacticConquestLite;

public class OptionsScreen extends GameScreen  {

    Button button;

    public OptionsScreen (GalacticConquestLite game, AssetManager assetManager) {
        super (game, assetManager);

        ButtonStyle style = new ButtonStyle(skin.get(ButtonStyle.class));


        style.up = new TextureRegionDrawable(
                new TextureRegion((Texture) assetManager.get("menu/button_test1.png")));

        style.down = style.over = style.checked =
                new TextureRegionDrawable(
                    new TextureRegion((Texture)assetManager.get("menu/button_test2.png")));

        button = new Button(style);
        button.setX(Gdx.graphics.getWidth() / 2 + (button.getWidth() / 2));
        button.setY(Gdx.graphics.getHeight() / 2 + (button.getHeight()));

        stage.addActor(button);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.batch.begin();
        font.draw(game.batch,
                 "Is over: " + button.isOver(),
                (int)(stage.getWidth() * 0.1),
                stage.getHeight() - (int)(stage.getHeight() * 0.1) + 100);
        game.batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);

    }
}
