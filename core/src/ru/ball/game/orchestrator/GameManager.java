package ru.ball.game.orchestrator;

import com.badlogic.gdx.Screen;
import ru.ball.game.model.ScreenTransition;

public class GameManager {

    private TheBallGame ballGame;

    private GameManager() {
        super();
    }

    public static GameManager getInstance() {
        return GameManagerHolder.INSTANCE;
    }

    public void initialize(TheBallGame game) {
        this.ballGame = game;
    }

    public TheBallGame getBallGame() {
        return ballGame;
    }

    public void showScreen(ScreenTransition screenTransition) {
        Screen currentScreen = ballGame.getScreen();
        ballGame.setScreen(screenTransition.getScreenTransition());
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

    public static class GameManagerHolder {
        private final static GameManager INSTANCE = new GameManager();
    }
}
