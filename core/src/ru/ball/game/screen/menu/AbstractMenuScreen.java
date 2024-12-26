package ru.ball.game.screen.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FillViewport;
import ru.ball.game.screen.AbstractScreen;

public abstract class AbstractMenuScreen extends AbstractScreen {

    private final Texture texture = new Texture("morgen.png");
    private final Image image = new Image(texture);
    private final Stage frontStage = new Stage(new FillViewport(1280, 720));
    private final Stage backgroundStage = new Stage(new FillViewport(1920, 1080));

    public AbstractMenuScreen() {
        image.setSize(1920, 1080);
    }

    public Image getImage() {
        return image;
    }

    public Stage getFrontStage() {
        return frontStage;
    }

    public Stage getBackgroundStage() {
        return backgroundStage;
    }
}
