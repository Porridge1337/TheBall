package ru.ball.game.factory;

import com.badlogic.gdx.Screen;
import ru.ball.game.screen.game.EndGameScreen;
import ru.ball.game.screen.game.GameProcessScreen;
import ru.ball.game.screen.menu.MainMenuScreen;
import ru.ball.game.screen.menu.ResolutionSettingMenuScreen;
import ru.ball.game.screen.menu.SettingMenuScreen;

public class ScreenFactory {

    public static Screen createMenuScreen() {
        return new MainMenuScreen();
    }

    public static Screen createSettingMenuScreen() {
        return new SettingMenuScreen();
    }

    public static Screen createResolutionSettingMenuScreen() {
        return new ResolutionSettingMenuScreen();
    }

    public static Screen createGameProcessScreen() {
        return new GameProcessScreen();
    }

    public static Screen createEndGameScreen() {
        return new EndGameScreen();
    }

}
