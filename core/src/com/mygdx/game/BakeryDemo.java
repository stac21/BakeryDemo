package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class BakeryDemo extends ApplicationAdapter {
	private SpriteBatch batch;
	private Sprite sprite;
	private Stage stage;
	private Skin skin;
	private static Table table;
	// the upgrades that the user has purchased and that are active in the game world
	private static ArrayList<BakeryUpgrade> upgrades = new ArrayList<>();
	private Label moneyLabel;
	private int money;
	private static float moneyMultiplier;
	private float time;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		this.sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.skin = new Skin(Gdx.files.internal("uiskin.json"));
		this.stage = new Stage(new ScreenViewport());

		table = new Table();
		table.setWidth(this.stage.getWidth());
		table.align(Align.center | Align.top);
		table.padTop(30);
		table.setBackground(new SpriteDrawable(new Sprite(
				new Texture(Gdx.files.internal("muffin.png")))));

		table.setFillParent(true);

		final TextButton textButton = new TextButton("Upgrade Shop", skin, "default");
		textButton.getLabel().setFontScale(3.0f);

		this.time = 0;
		money = 0;
		moneyMultiplier = 1;
		this.moneyLabel = new Label("$" + this.money, skin, "default"	);
		this.moneyLabel.setFontScale(2.5f);

		final BakeryMenu bakeryMenu = new BakeryMenu("Bakery Menu", this.skin);
		bakeryMenu.addItem(new BakeryUpgrade("oven.png", "Oven", 2));
		bakeryMenu.addItem(new BakeryUpgrade("chef.jpg", "Employee", 3));

		textButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				bakeryMenu.show(stage);
			}
		});

		table.add(textButton).width(300).height(100);
		table.add(moneyLabel).top().right();

		this.stage.addActor(table);

		Gdx.input.setInputProcessor(this.stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float delta = Gdx.graphics.getDeltaTime();

		this.stage.act(delta);
		this.time += delta;

		if (this.time >= 1) {
			System.out.println("Inside the condition");

			this.time -= 1;

			this.money += this.moneyMultiplier;

			this.moneyLabel.setText("$" + this.money);
		}

		this.stage.draw();
	}
	
	@Override
	public void dispose () {
		this.stage.dispose();
		this.skin.dispose();
	}

	public static void addItemToWorld(BakeryUpgrade upgrade) {
		upgrades.add(upgrade);
		moneyMultiplier *= upgrade.getMoneyMultiplier();

		Sprite sprite = new Sprite(new Texture(Gdx.files.internal(upgrade.getTexturePath())));
		Image image = new Image(sprite);

		table.row();
		table.add(image).width(300).height(300);
	}
}
