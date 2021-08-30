package com.oblig.systems;

import com.oblig.guis.Control;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;


public class DrawingSystem {

    private GraphicsContext gc;
    private Control controlGui;

    private double angleModifier = Math.PI / 5;
    private double lengthModifier = 0.70;

    public DrawingSystem(GraphicsContext gc, Control controlGui) {
        this.gc = gc;
        this.controlGui = controlGui;
    }

    public void tegnTre(double x, double y, double lengde){
        gc.strokeLine(x, y, x, y - lengde);
        tegnGrein(x, y - lengde, lengde, Math.PI / 2);
    }

    private void tegnGrein(double x, double y, double lengde, double angle) {
        //Skaffer riktig koordinater basert på vinkel
        double x2 = x + Math.cos(angle) * lengde;
        double y2 = y - Math.sin(angle) * lengde;

        //Dersom lengden er mindre enn 2 piksler så avslutt
        if (lengde < 2) return;

        //Tegner første grein til venstre
        gc.strokeLine(x, y, x2, y2);
        tegnGrein(x2, y2,
                lengde * calculateLengthModifier(1 - controlGui.getLengdeAvvikSlider().getValue()),
                angle + calculateAngleModifier(1 - controlGui.getVinkelAvvikSlider().getValue()));

        //Tegner andre grein til høyre
        gc.strokeLine(x, y, x2, y2);
        tegnGrein(x2, y2,
                lengde * calculateLengthModifier(1 - controlGui.getLengdeAvvikSlider().getValue()),
                angle - calculateAngleModifier(1 - controlGui.getGreinAvvikSlider().getValue()));
    }

    private double calculateAngleModifier(double chance) {
        if(chance == 1) return angleModifier;
        double rangeMin = chance * angleModifier;
        double rangeMax = (chance + 1) * angleModifier;
        Random random = new Random();
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }
    private double calculateLengthModifier(double chance) {
        if(chance == 1) return lengthModifier;
        double rangeMin = chance;
        double rangeMax = 1;
        Random random = new Random();
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }
    public void clearCanvas() {
        gc.clearRect(0,0,gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
    /*
    private double calculateVisibilityModifier(double chance) {

    }
    */
}
