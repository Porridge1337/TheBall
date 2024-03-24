package ru.ball.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block implements CollidableShape {

    private final int blockX;
    private final int blockY;
    private final int blockWidth;
    private final int blockHeight;
    private boolean destroyed = false;

    public Block(int blockX, int blockY, int blockWidth, int blockHeight) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(blockX, blockY, blockWidth, blockHeight);
    }

    @Override
    public float getX() {
        return blockX;
    }

    @Override
    public float getY() {
        return blockY;
    }

    @Override
    public float getWidth() {
        return blockWidth;
    }

    @Override
    public float getHeight() {
        return blockHeight;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
