package ru.ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private float x;
    private final float widthRec;
    private final float heightRec;
    private final int widthOfScreen = Gdx.graphics.getWidth();

    public Paddle(float x, float widthRec, float heightRec) {
        this.x = x;
        this.widthRec = widthRec;
        this.heightRec = heightRec;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, 0, widthRec, heightRec);
    }

    public void update() {
        float inputCursorX = Gdx.input.getX();
        setCursorCoordinates(inputCursorX);
    }

    private void setCursorCoordinates(float inputCursorX) {
        if (!isOutOfBoundsX(inputCursorX)) {
            this.x = inputCursorX - (widthRec / 2);
        }
    }

    private boolean isOutOfRightCorner(float inputCursorX) {
        return (inputCursorX + (widthRec / 2)) > widthOfScreen;
    }

    private boolean isOutOfLeftCorner(float inputCursorX) {
        return (inputCursorX - (widthRec / 2)) < 0;
    }


    private boolean isOutOfBoundsX(float inputCursorX) {
        return (isOutOfLeftCorner(inputCursorX) || isOutOfRightCorner(inputCursorX));
    }

    public float getPaddleX() {
        return x;
    }

    public float getPaddleY() {
        return 0;
    }

    public float getWidthRec() {
        return widthRec;
    }

    public float getHeightRec() {
        return heightRec;
    }
}
