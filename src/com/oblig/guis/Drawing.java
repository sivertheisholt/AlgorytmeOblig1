package com.oblig.guis;

import com.oblig.Main;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Drawing klassen inneholder stedet der det skal tegnes
 */
public class Drawing {
    private Canvas canvas;
    private GraphicsContext canvasGc;

    /**
     * Konstruker for Drawing klassen
     */
    public Drawing() {
        canvas = new Canvas(Main.WINDOW_WIDTH * 0.80, Main.WINDOW_HEIGHT);
        canvasGc = canvas.getGraphicsContext2D();
    }

    /** Getters og setters **/

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getCanvasGc() {
        return canvasGc;
    }
}
