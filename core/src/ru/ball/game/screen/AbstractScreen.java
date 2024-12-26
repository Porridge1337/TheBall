package ru.ball.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class AbstractScreen implements Screen {

    private final Skin skin = new Skin(Gdx.files.internal("skin/craftcular/craftacular-ui.json"));

    public Skin getSkin() {
        return skin;
    }
}
