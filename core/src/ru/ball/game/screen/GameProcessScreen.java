package ru.ball.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import ru.ball.game.Ball;
import ru.ball.game.Block;
import ru.ball.game.Paddle;
import ru.ball.game.State;
import ru.ball.game.orchestrator.TheBallGame;

import java.util.ArrayList;
import java.util.List;

public class GameProcessScreen implements Screen {

    private final TheBallGame orchestrator;
    private final Ball ball;
    private final Paddle paddle;
    private final List<Block> blocks;
    private State state = State.RUN;
    private final int xBallSpeed = 5;
    private final int yBallSpeed = 5;


    public GameProcessScreen(TheBallGame orchestrator) {
        this.orchestrator = orchestrator;
        ball = new Ball(0, 0, 10, xBallSpeed, yBallSpeed);
        paddle = new Paddle(50, 150, 20);
        blocks = generateBlock(Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orchestrator.getShape().begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(orchestrator.getShape());
        ball.update(paddle);
        paddle.draw(orchestrator.getShape());
        paddle.update();
        blocks.forEach(block -> {
            block.draw(orchestrator.getShape());
            ball.checkBlockCollision(block);
        });
        blocks.removeIf(Block::isDestroyed);
        orchestrator.getShape().end();
        gameStateHandler(state);
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

    private List<Block> generateBlock(int clientAreaHeight, int clientAreaWidth) {
        List<Block> blocks = new ArrayList<>();
        int blockWidth = 63;
        int blockHeight = 20;

        for (int y = clientAreaHeight / 2; y < clientAreaHeight; y += blockHeight + 10) {
            for (int x = 0; x < clientAreaWidth; x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
        return blocks;
    }

    private void gameStateHandler(State state) {
        switch (state) {
            case RUN -> this.state = ball.checkDroppedOnTheGround(state);
            case PAUSE -> orchestrator.changeScreen(TheBallGame.END_GAME);
        }
    }

}
