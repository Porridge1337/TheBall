package ru.ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private float x;
    private final float width;
    private final float height;
    private final int widthOfRightCorner = Gdx.graphics.getWidth();

    public Paddle(float x, float width, float height) {
        this.x = x;
        this.width = width;
        this.height = height;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, 0, width, height);
    }

    public void update() {
        float inputCursorX = Gdx.input.getX();
        setCursorCoordinates(inputCursorX);
    }

    private void setCursorCoordinates(float inputCursorX) {
        if (!isOutOfBoundsX(inputCursorX)) {
            this.x = inputCursorX - (width / 2);
        }
    }

    private boolean isOutOfRightCorner(float inputCursorX) {
        return (inputCursorX + (width / 2)) > widthOfRightCorner;
    }

    private boolean isOutOfLeftCorner(float inputCursorX) {
        return (inputCursorX - (width / 2)) < 0;
    }

    private boolean isOutOfBoundsX(float inputCursorX) {
        return (isOutOfLeftCorner(inputCursorX) || isOutOfRightCorner(inputCursorX));
    }
}
