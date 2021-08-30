package com.oblig.guis;

import com.oblig.Main;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.shape.Line;

public class Drawing {
    private Canvas canvas;
    private GraphicsContext canvasGc;
    private Line[] lines;

    public Drawing(ColumnConstraints column) {
        canvas = new Canvas(Main.WINDOW_WIDTH * 0.80, Main.WINDOW_HEIGHT);
        canvasGc = canvas.getGraphicsContext2D();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getCanvasGc() {
        return canvasGc;
    }
}
