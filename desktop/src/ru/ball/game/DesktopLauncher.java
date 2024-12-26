package ru.ball.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import ru.ball.game.orchestrator.GameManager;
import ru.ball.game.orchestrator.TheBallGame;


public class DesktopLauncher {
    public static void main(String[] arg) {
        GameManager.getInstance().initialize(new TheBallGame());
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("The ball");
        config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        config.setResizable(false);
        config.setOpenGLEmulation(Lwjgl3ApplicationConfiguration.GLEmulation.GL32, 3, 2);
        new Lwjgl3Application(GameManager.getInstance().getBallGame(), config);
    }
}
