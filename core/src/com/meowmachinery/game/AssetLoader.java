package com.meowmachinery.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AssetLoader {
    public static void loadTextures(AssetManager assetManager) {
        ArrayList<String> textures = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("AssetList.txt"))) {
            String line = br.readLine();
            while (line != null) {
                assetManager.load(line, Texture.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
