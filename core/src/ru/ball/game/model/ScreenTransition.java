package ru.ball.game.model;

import com.badlogic.gdx.Screen;
import ru.ball.game.factory.ScreenFactory;

public enum ScreenTransition {

    MENU("menu") {
        @Override
        public Screen getScreenTransition() {
            return ScreenFactory.createMenuScreen();
        }
    },
    START("start") {
        @Override
        public Screen getScreenTransition() {
            return ScreenFactory.createGameProcessScreen();
        }
    },
    MAIN_SETTING_PAGE("settings") {
        @Override
        public Screen getScreenTransition() {
            return ScreenFactory.createSettingMenuScreen();
        }
    },
    RESOLUTION_SETTING_PAGE("resolution") {
        @Override
        public Screen getScreenTransition() {
            return ScreenFactory.createResolutionSettingMenuScreen();
        }
    },
    END_GAME("endGame") {
        @Override
        public Screen getScreenTransition() {
            return ScreenFactory.createEndGameScreen();
        }
    };

    private final String name;


    ScreenTransition(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract <T> T getScreenTransition();

}
