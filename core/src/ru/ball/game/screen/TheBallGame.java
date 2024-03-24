package ru.ball.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class TheBallGame extends Game {

    private ShapeRenderer shape;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new GameProcessScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
        shape.dispose();
        batch.dispose();
        font.dispose();
    }

    protected ShapeRenderer getShape() {
        return shape;
    }

    protected BitmapFont getFont() {
        return font;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
