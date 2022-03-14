package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class BakeryUpgrade {
    private String texturePath;
    private String name;
    private float moneyMultiplier;

    public BakeryUpgrade(String texturePath, String name, float moneyMultiplier) {
        this.texturePath = texturePath;
        this.name = name;
        this.moneyMultiplier = moneyMultiplier;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoneyMultiplier() {
        return moneyMultiplier;
    }

    public void setMoneyMultiplier(float moneyMultiplier) {
        this.moneyMultiplier = moneyMultiplier;
    }

}
