package com.oblig;

import com.oblig.scenes.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main er hovedklassen til programmet, det er her start punktet er
 *
 * Gruppenummer: 10
 * 233518 - Sivert Heisholt
 * 233511 - Sigve Eliassen
 * 233565 - Govert Dahl
 * 233530 - Ørjan Dybevik
 */
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
