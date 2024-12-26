package ru.ball.game.screen.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import ru.ball.game.model.ScreenTransition;
import ru.ball.game.orchestrator.GameManager;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResolutionSettingMenuScreen extends AbstractMenuScreen {

    private Table table;
    private TextButton screenMode;
    private TextButton back;
    private ScrollPane resolutionPane;

    public ResolutionSettingMenuScreen() {
        Gdx.input.setInputProcessor(getFrontStage());
    }


    @Override
    public void show() {
        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        getFrontStage().addActor(table);
        getBackgroundStage().addActor(getImage());

        screenMode = new CheckBox("Windowed", getSkin());
        screenMode.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (screenMode.isChecked()) {
                    screenMode.setText("FullScreen");
                    Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                } else {
                    screenMode.setText("Windowed");
                    Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
                }

            }
        });
        resolutionPane = createResolutionList(getSkin());


        back = new TextButton("Back", getSkin());
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().showScreen(ScreenTransition.MAIN_SETTING_PAGE);
            }
        });
        table.add(resolutionPane).fillX().uniformX();
        table.row().pad(20, 0, 10, 0);
        table.add(screenMode).fillX().uniformX();
        table.row().pad(20, 0, 10, 0);
        table.add(back).fillX().uniformX();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);

        getBackgroundStage().act();
        getBackgroundStage().draw();

        getFrontStage().act(Math.min(delta, 1 / 30f));
        getFrontStage().draw();

    }

    @Override
    public void resize(int width, int height) {
        getFrontStage().getViewport().update(width, height, true);
        getBackgroundStage().getViewport().update(width, height, true);
        System.out.println(width + " x " + height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        getFrontStage().dispose();
        getBackgroundStage().dispose();
        getSkin().dispose();
    }

    private ScrollPane createResolutionList(Skin skin) {
        Table listTable = new Table();
        Graphics.DisplayMode[] modes = Gdx.graphics.getDisplayModes();
        Map<String, Graphics.DisplayMode> screenModes = new LinkedHashMap<>();
        for (Graphics.DisplayMode mode : modes) {
            String resolutionKey = mode.width + "x" + mode.height;
            if (!screenModes.containsKey(resolutionKey) || screenModes.get(resolutionKey).refreshRate < mode.refreshRate) {
                screenModes.put(resolutionKey, mode);
            }
        }
        screenModes.values().forEach(displayMode -> {
            String buttonLabel = displayMode.width + "x" + displayMode.height;
            TextButton resolutionButton = new TextButton(buttonLabel, skin);
            resolutionButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    // Установка выбранного режима полного экрана
                    if (Gdx.graphics.isFullscreen()) {
                        Gdx.graphics.setFullscreenMode(displayMode);
                    } else {
                        Gdx.graphics.setWindowedMode(displayMode.width, displayMode.height);
                    }
                }
            });
            listTable.add(resolutionButton).padBottom(5).row();
        });

        ScrollPane scrollPane = new ScrollPane(listTable, skin);
        scrollPane.setScrollingDisabled(true, false); // Включаем вертикальный скролл
        scrollPane.setFadeScrollBars(false); // Видимые скроллбары
        return scrollPane;
    }

}
