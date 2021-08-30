package com.oblig.guis;

import com.oblig.systems.DrawingSystem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class Control {
    private VBox vBox;

    private Slider randomSlider;
    private Label randomLabel;

    private Slider vinkelAvvikSlider;
    private Label vinkelAvvikLabel;

    private Slider lengdeAvvikSlider;
    private Label lengdeAvvikLabel;

    private Slider greinAvvikSlider;
    private Label greinAvvikLabel;

    private Slider startLengdeSlider;
    private Label startLengdeLabel;

    private Button drawButton;


    public Control() {
        vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        randomSlider = new Slider(0, 1, 0);
        randomSlider.setShowTickMarks(true);
        randomSlider.setShowTickLabels(true);
        randomSlider.setMajorTickUnit(0.25f);
        randomSlider.setBlockIncrement(0.1f);
        randomLabel = new Label("Tilfeldighetsnivå");

        vinkelAvvikSlider = new Slider(0, 1, 0);
        vinkelAvvikSlider.setShowTickMarks(true);
        vinkelAvvikSlider.setShowTickLabels(true);
        vinkelAvvikSlider.setMajorTickUnit(0.25f);
        vinkelAvvikSlider.setBlockIncrement(0.1f);
        vinkelAvvikLabel = new Label("Vinkel avviksnivå");

        lengdeAvvikSlider = new Slider(0, 1, 0);
        lengdeAvvikSlider.setShowTickMarks(true);
        lengdeAvvikSlider.setShowTickLabels(true);
        lengdeAvvikSlider.setMajorTickUnit(0.25f);
        lengdeAvvikSlider.setBlockIncrement(0.1f);
        lengdeAvvikLabel = new Label("Lengde avviksnivå");

        greinAvvikSlider = new Slider(0, 1, 0);
        greinAvvikSlider.setShowTickMarks(true);
        greinAvvikSlider.setShowTickLabels(true);
        greinAvvikSlider.setMajorTickUnit(0.25f);
        greinAvvikSlider.setBlockIncrement(0.1f);
        greinAvvikLabel = new Label("Grein avviksnivå");

        startLengdeSlider = new Slider(0, 200, 0);
        startLengdeSlider.setShowTickMarks(true);
        startLengdeSlider.setShowTickLabels(true);
        startLengdeSlider.setMajorTickUnit(50f);
        startLengdeSlider.setBlockIncrement(25f);
        startLengdeLabel = new Label("Grein start lengde");

        drawButton = new Button("Draw");
        drawButton.setPrefWidth(Double.MAX_VALUE);

        vBox.getChildren().addAll(randomLabel, randomSlider,
                vinkelAvvikLabel, vinkelAvvikSlider,
                lengdeAvvikLabel, lengdeAvvikSlider,
                greinAvvikLabel, greinAvvikSlider,
                startLengdeLabel, startLengdeSlider,
                drawButton);
    }

    public VBox getvBox() {
        return vBox;
    }

    public void initializeDrawButton(DrawingSystem drawingSystem, double x, double y, double length) {
        drawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                drawingSystem.clearCanvas();
                drawingSystem.tegnTre(x, y, startLengdeSlider.getValue());
            }
        });
    }

    public Slider getRandomSlider() {
        return randomSlider;
    }

    public Slider getVinkelAvvikSlider() {
        return vinkelAvvikSlider;
    }

    public Slider getLengdeAvvikSlider() {
        return lengdeAvvikSlider;
    }

    public Slider getGreinAvvikSlider() {
        return greinAvvikSlider;
    }

    public Slider getStartLengdeSlider() {
        return startLengdeSlider;
    }
}
