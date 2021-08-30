package com.oblig.scenes;

import com.oblig.Main;
import com.oblig.guis.Control;
import com.oblig.guis.Drawing;
import com.oblig.systems.DrawingSystem;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainScene {
    private Drawing drawing;
    private Control control;
    private DrawingSystem drawingSystem;

    public MainScene(Stage stage) {
        //Konstruerer en ny gridpane
        GridPane gridpane = new GridPane();

        //Lag scene
        Scene scene = new Scene(gridpane, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);

        //Konfigurerer gridpane
        ColumnConstraints drawingColumn = new ColumnConstraints();
        drawingColumn.setPercentWidth(80);
        ColumnConstraints controlsColumn = new ColumnConstraints();
        controlsColumn.setPercentWidth(20);
        gridpane.getColumnConstraints().addAll(drawingColumn, controlsColumn);

        //Debug
        gridpane.setGridLinesVisible(true);

        //Drawing gui
        drawing = new Drawing(drawingColumn);
        gridpane.add(drawing.getCanvas(),0,0);
        //drawing.drawLineTest();

        //Controls gui
        control = new Control();
        gridpane.add(control.getvBox(),1,0);

        stage.setScene(scene);
        stage.show();

        //Konfigurerer tegne systemet
        drawingSystem = new DrawingSystem(drawing.getCanvasGc(), control);

        //Initialiserer knapp
        control.initializeDrawButton(drawingSystem, drawing.getCanvas().getWidth() / 2, drawing.getCanvas().getHeight(), control.getStartLengdeSlider().getValue());
    }

}
