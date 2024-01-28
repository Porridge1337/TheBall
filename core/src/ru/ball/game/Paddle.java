package ru.ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private float x;
    private float y;
    private final float widthRec;
    private final float heightRec;
    private final int widthOfScreen = Gdx.graphics.getWidth();
    private final int heightOfScreen = Gdx.graphics.getHeight();

    public Paddle(float x, float y, float widthRec, float heightRec) {
        this.x = x;
        this.y = y;
        this.widthRec = widthRec;
        this.heightRec = heightRec;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, widthRec, heightRec);
    }

    public void update() {
        float inputCursorX = Gdx.input.getX();
        float inputCursorY = Gdx.input.getY();
        setCursorCoordinates(inputCursorX, inputCursorY);
    }

    private void setCursorCoordinates(float inputCursorX, float inputCursorY) {
        if (!isOutOfBoundsX(inputCursorX) && !isOutOfBoundsY(inputCursorY)) {
            this.x = inputCursorX - (widthRec / 2);
            this.y = heightOfScreen - inputCursorY - (heightRec / 2);
        }
    }

    private boolean isOutOfRightCorner(float inputCursorX) {
        return (inputCursorX + (widthRec / 2)) > widthOfScreen;
    }

    private boolean isOutOfLeftCorner(float inputCursorX) {
        return (inputCursorX - (widthRec / 2)) < 0;
    }

    private boolean isOutOfTopCorner(float inputCursorY) {
        return (inputCursorY + (heightRec / 2)) > heightOfScreen;
    }

    private boolean isOutOfBottomCorner(float inputCursorY) {
        return (inputCursorY - (heightRec / 2)) < 0;
    }

    private boolean isOutOfBoundsX(float inputCursorX) {
        return (isOutOfLeftCorner(inputCursorX) || isOutOfRightCorner(inputCursorX));
    }

    private boolean isOutOfBoundsY(float inputCursorY) {
        return (isOutOfBottomCorner(inputCursorY) || isOutOfTopCorner(inputCursorY));
    }
}
