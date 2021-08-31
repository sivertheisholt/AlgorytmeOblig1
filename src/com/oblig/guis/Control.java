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

    private Slider vinkelSlider;
    private Label vinkelLabel;

    private Slider stammeLengdeSlider;
    private Label stammeLengdeLabel;

    private Slider antallRekursjonSlider;
    private Label antallRekursjonLabel;

    private Slider vinkelAvvikSlider;
    private Label vinkelAvvikLabel;

    private Slider lengdeAvvikSlider;
    private Label lengdeAvvikLabel;

    private Slider greinAvvikSlider;
    private Label greinAvvikLabel;


    private Button drawButton;


    public Control() {
        vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        vinkelSlider = new Slider(0, 1, 0);
        vinkelSlider.setShowTickMarks(true);
        vinkelSlider.setShowTickLabels(true);
        vinkelSlider.setMajorTickUnit(0.25f);
        vinkelSlider.setBlockIncrement(0.1f);
        vinkelLabel = new Label("Grein vinkel");

        stammeLengdeSlider = new Slider(0, 200, 100);
        stammeLengdeSlider.setShowTickMarks(true);
        stammeLengdeSlider.setShowTickLabels(true);
        stammeLengdeSlider.setMajorTickUnit(40f);
        stammeLengdeSlider.setBlockIncrement(20f);
        stammeLengdeLabel = new Label("Stamme lengde");

        antallRekursjonSlider = new Slider(0, 10, 5);
        antallRekursjonSlider.setShowTickMarks(true);
        antallRekursjonSlider.setShowTickLabels(true);
        antallRekursjonSlider.setMajorTickUnit(2f);
        antallRekursjonSlider.setBlockIncrement(1f);
        antallRekursjonLabel = new Label("Antall rekursjons nivåer");

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


        drawButton = new Button("Draw");
        drawButton.setPrefWidth(Double.MAX_VALUE);

        vBox.getChildren().addAll(vinkelLabel, vinkelSlider,
                stammeLengdeLabel, stammeLengdeSlider,
                antallRekursjonLabel, antallRekursjonSlider,
                vinkelAvvikLabel, vinkelAvvikSlider,
                lengdeAvvikLabel, lengdeAvvikSlider,
                greinAvvikLabel, greinAvvikSlider,
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
                drawingSystem.setRecursion(0);
                drawingSystem.tegnTre(x, y, stammeLengdeSlider.getValue());
            }
        });
    }

    public Slider getVinkelSlider() {
        return vinkelSlider;
    }

    public Slider getStammeLengdeSlider() {
        return stammeLengdeSlider;
    }

    public Slider getAntallRekursjonSlider() {
        return antallRekursjonSlider;
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

}
