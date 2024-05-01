package ru.ball.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import ru.ball.game.orchestrator.TheBallGame;

public class MenuScreen implements Screen {

    private final TheBallGame orchestrator;
    private final Stage stage;
    private final Table table;
    private final TextButton newGame;
    private final TextButton exit;

    public MenuScreen(TheBallGame orchestrator) {
        this.orchestrator = orchestrator;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        newGame = new TextButton("Start game", orchestrator.getSkin());
        exit = new TextButton("Exit", orchestrator.getSkin());
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(exit).fillX().uniformX();
        table.row();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(delta, 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
    }
}
