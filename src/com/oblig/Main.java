package com.oblig;

import com.oblig.scenes.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public final static int WINDOW_WIDTH = 1280;
    public final static int WINDOW_HEIGHT = 720;

    @Override
    public void start(Stage stage) {
        MainScene mainScene = new MainScene(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
