package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class BakeryMenu extends Dialog {

    public BakeryMenu(String title, Skin skin) {
        super(title, skin);
    }

    public BakeryMenu(String title, Skin skin, String windowStyleName) {
        super(title, skin, windowStyleName);
    }

    public BakeryMenu(String title, WindowStyle windowStyle) {
        super(title, windowStyle);
    }

    // this section of code is called whenever any of the constructors are called
    {
        // adds a button labeled "Cancel" to the dialog
        this.button("Cancel");

        this.getTitleLabel().setFontScale(3.0f);
    }

    @Override
    protected void result(Object object) {
        super.result(object);
    }

    public void addItem(BakeryUpgrade item) {
        Table group = new Table();

        Sprite sprite = new Sprite(new Texture(Gdx.files.internal(item.getTexturePath())));

        Image image = new Image(sprite);
        TextField name = new TextField(item.getName(), this.getSkin());

        group.add(image).width(300).height(300);
        group.add(name);

        final BakeryUpgrade finalItem = item;

        group.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                BakeryDemo.addItemToWorld(finalItem);
            }
        });

        this.getContentTable().add(group);
    }
}
