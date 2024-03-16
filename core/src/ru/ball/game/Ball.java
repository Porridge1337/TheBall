package ru.ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {

    private int x;
    private int y;
    private final int size;
    private int xSpeed;
    private int ySpeed;
    private Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        correctIfInInvalidPosition();
    }

    private void correctIfInInvalidPosition() {
        if (isOutOfLeftCorner())
            this.x += (size - x);
        if (isOutOfRightCorner())
            this.x -= (size - x);
        if (isOutOfBottomCorner())
            this.y += (size - y);
        if (isOutOfTopCorner())
            this.y -= (size - y);
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (isOutOfBoundsX())
            xSpeed = -xSpeed;
        if (isOutOfBoundsY())
            ySpeed = -ySpeed;
    }

    private boolean isOutOfBoundsX() {
        return (isOutOfLeftCorner() || isOutOfRightCorner());
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            color = Color.GREEN;
        } else {
            color = Color.WHITE;
        }
    }

    //мы вычисляем расстояние между центром круга и ближайшей точкой прямоугольника, и если это расстояние меньше радиуса круга, то они пересекаются.
    private boolean collidesWith(Paddle paddle) {
        //deltaX и deltaY показывают изменение позиции объекта в пространстве
        float deltaX = this.x - Math.max(paddle.getPaddleX(), Math.min(this.x, paddle.getPaddleX() + paddle.getWidthRec()));
        float deltaY = this.y - Math.max(paddle.getPaddleY(), Math.min(this.y, paddle.getPaddleY() + paddle.getHeightRec()));
        return (Math.pow(deltaX, 2) + Math.pow(deltaY, 2)) < Math.pow(this.size, 2);
    }

    private boolean isOutOfBoundsY() {
        return (isOutOfBottomCorner() || isOutOfTopCorner());
    }

    private boolean isOutOfLeftCorner() {
        return (x - size) < 0;
    }

    private boolean isOutOfRightCorner() {
        return (x + size) > Gdx.graphics.getWidth();
    }

    private boolean isOutOfTopCorner() {
        return (y + size) > Gdx.graphics.getHeight();
    }

    private boolean isOutOfBottomCorner() {
        return (y - size) < 0;
    }
}
