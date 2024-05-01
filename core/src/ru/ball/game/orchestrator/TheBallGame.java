package ru.ball.game.orchestrator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import ru.ball.game.screen.EndGameScreen;
import ru.ball.game.screen.GameProcessScreen;
import ru.ball.game.screen.MenuScreen;


public class TheBallGame extends Game {

    public final static int MENU = 0;
    public final static int START = 1;
    public final static int END_GAME = 2;

    private ShapeRenderer shape;
    private SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;

    private MenuScreen menuScreen;
    private GameProcessScreen gameProcessScreen;
    private EndGameScreen endGameScreen;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal("skin/craftacular-ui.json"));
        changeScreen(MENU);
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
        skin.dispose();
    }

    public ShapeRenderer getShape() {
        return shape;
    }

    public BitmapFont getFont() {
        return font;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Skin getSkin() {
        return skin;
    }

    public void changeScreen(int screen) {
        switch (screen) {
            case MENU -> {
                if (menuScreen == null) {
                    menuScreen = new MenuScreen(this);
                }
                this.setScreen(menuScreen);
            }
            case START -> {
                if (gameProcessScreen == null) {
                    gameProcessScreen = new GameProcessScreen(this);
                }
                this.setScreen(gameProcessScreen);
            }
            case END_GAME -> {
                if (endGameScreen == null) {
                    endGameScreen = new EndGameScreen(this);
                }
                this.setScreen(endGameScreen);
            }
        }
    }
}
