package com.meowmachinery.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
    public static void loadTextures(AssetManager assetManager) {
        assetManager.load("map/darkPurple.png", Texture.class);
        assetManager.load("map/meteorBrown_big1.png", Texture.class);
        assetManager.load("map/meteorBrown_big2.png", Texture.class);
        assetManager.load("map/meteorBrown_big3.png", Texture.class);
        assetManager.load("map/meteorBrown_big4.png", Texture.class);
        assetManager.load("map/meteorBrown_med1.png", Texture.class);
        assetManager.load("map/meteorBrown_med3.png", Texture.class);
        assetManager.load("map/meteorBrown_small1.png", Texture.class);
        assetManager.load("map/meteorBrown_small2.png", Texture.class);
        assetManager.load("map/meteorBrown_tiny1.png", Texture.class);
        assetManager.load("map/meteorBrown_tiny2.png", Texture.class);
        assetManager.load("map/meteorGrey_big1.png", Texture.class);
        assetManager.load("map/meteorGrey_big2.png", Texture.class);
        assetManager.load("map/meteorGrey_big3.png", Texture.class);
        assetManager.load("map/meteorGrey_big4.png", Texture.class);
        assetManager.load("map/meteorGrey_med1.png", Texture.class);
        assetManager.load("map/meteorGrey_med2.png", Texture.class);
        assetManager.load("map/meteorGrey_small1.png", Texture.class);
        assetManager.load("map/meteorGrey_small2.png", Texture.class);
        assetManager.load("map/meteorGrey_tiny1.png", Texture.class);
        assetManager.load("map/meteorGrey_tiny2.png", Texture.class);
        assetManager.load("map/playerShip1_blue.png", Texture.class);
        assetManager.load("map/playerShip1_damage1.png", Texture.class);
        assetManager.load("map/playerShip1_damage2.png", Texture.class);
        assetManager.load("map/playerShip1_damage3.png", Texture.class);
        assetManager.load("map/playerShip1_green.png", Texture.class);
        assetManager.load("map/playerShip1_orange.png", Texture.class);
        assetManager.load("map/playerShip1_red.png", Texture.class);
    }
}
