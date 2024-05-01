package ru.ball.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import ru.ball.game.orchestrator.TheBallGame;

public class EndGameScreen implements Screen {

    private final TheBallGame orchestrator;


    public EndGameScreen(TheBallGame orchestrator) {
        this.orchestrator = orchestrator;

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.orchestrator.getBatch().begin();
        this.orchestrator.getFont().draw(orchestrator.getBatch(), "End game ", 100, 150);
        this.orchestrator.getBatch().end();
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
