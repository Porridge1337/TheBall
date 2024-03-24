package ru.ball.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;


public class TheBallGame extends ApplicationAdapter {

    private ShapeRenderer shape;
    private Ball ball;
    private Paddle paddle;
    private List<Block> blocks;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(0, 0, 10, 5, 5);
        paddle = new Paddle(50, 150, 20);
        blocks = generateBlock(Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        ball.update(paddle);

        paddle.draw(shape);
        blocks.forEach(block -> {
            block.draw(shape);
            ball.update(block);
        });
        paddle.update();
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
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

}
