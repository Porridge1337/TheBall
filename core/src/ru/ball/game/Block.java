package ru.ball.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {

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

    public int getBlockX() {
        return blockX;
    }

    public int getBlockY() {
        return blockY;
    }

    public int getBlockWidth() {
        return blockWidth;
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
