package ru.ball.game.screen.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import ru.ball.game.model.ScreenTransition;
import ru.ball.game.orchestrator.GameManager;

public class SettingMenuScreen extends AbstractMenuScreen {

    private Table table;
    private TextButton resolution;
    private TextButton back;

    public SettingMenuScreen() {
        Gdx.input.setInputProcessor(getFrontStage());
    }


    @Override
    public void show() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        getFrontStage().addActor(table);
        getBackgroundStage().addActor(getImage());
        resolution = new TextButton("Resolution", getSkin());
        resolution.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().showScreen(ScreenTransition.RESOLUTION_SETTING_PAGE);
            }
        });
        back = new TextButton("Back", getSkin());
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().showScreen(ScreenTransition.MENU);
            }
        });
        table.add(resolution).fillX().uniformX();
        table.row().pad(20, 0, 10, 0);
        table.add(back).fillX().uniformX();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);

        getBackgroundStage().act();
        getBackgroundStage().draw();

        getFrontStage().act(Math.min(delta, 1 / 30f));
        getFrontStage().draw();

    }

    @Override
    public void resize(int width, int height) {
        getFrontStage().getViewport().update(width, height, true);
        getBackgroundStage().getViewport().update(width, height, true);
        System.out.println(width + " x " + height);
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
        getFrontStage().dispose();
        getBackgroundStage().dispose();
        getSkin().dispose();
    }


}
