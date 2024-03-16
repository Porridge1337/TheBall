package ru.ball.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TheBallGame extends ApplicationAdapter {

    private ShapeRenderer shape;
    private Ball ball;
    private Paddle paddle;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(320, 240, 50, 5, 5);
        paddle = new Paddle(50, 0, 150, 20);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        //ball.update();
        paddle.draw(shape);
        paddle.update();
        ball.checkCollision(paddle);
        shape.end();
    }

    @Override
    public void dispose() {
        shape.dispose();
    }
}
