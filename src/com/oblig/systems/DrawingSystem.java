package com.oblig.systems;

import com.oblig.components.Grein;
import com.oblig.guis.Control;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DrawingSystem {

    private GraphicsContext gc;
    private Control controlGui;

    private double angleModifier = Math.PI / 5;
    private double lengthModifier = 0.70;

    private int recursion;

    private HashMap<Integer, Grein[]> map;

    public DrawingSystem(GraphicsContext gc, Control controlGui) {
        this.gc = gc;
        this.controlGui = controlGui;
        recursion = 0;
        map = new HashMap<>();
    }


    public void tegnTre(double x, double y, double lengde){
        tegnStamme(x, y, lengde);
    }

    private void tegnStamme(double x, double y, double lengde) {
        gc.strokeLine(x, y, x, y - lengde);
        map.put(recursion, new Grein[] {new Grein(x, y, x, y - lengde, lengde, Math.PI / 2)});
        tegnNivåer();
    }

    private void tegnNivåer() {
        tegnGreiner();
        if(recursion >= (int) controlGui.getAntallRekursjonSlider().getValue()) return;
        tegnNivåer();
    }

    private void tegnGreiner() {
        ArrayList<Grein> greinList = new ArrayList<>();

        for(Grein grein : map.get(recursion)) {
            double length = grein.getLengde() * lengthModifier;
            double x2Left = grein.getX2() + Math.cos(grein.getAngle() + angleModifier) * length;
            double y2Left = grein.getY2() - Math.sin(grein.getAngle() + angleModifier) * length;
            double x2Right = grein.getX2() + Math.cos(grein.getAngle() - angleModifier) * length;
            double y2Right = grein.getY2() - Math.sin(grein.getAngle() - angleModifier) * length;

            System.out.println(y2Left);

            //venstre grein
            gc.strokeLine(grein.getX2(), grein.getY2(), x2Left, y2Left);

            greinList.add(new Grein(grein.getX2(), grein.getY2(), x2Left, y2Left, length, grein.getAngle() + angleModifier));

            //Høyre grein
            gc.strokeLine(grein.getX2(), grein.getY2(), x2Right, y2Right);

            greinList.add(new Grein(grein.getX2(), grein.getY2(), x2Right, y2Right, length, grein.getAngle() - angleModifier));
        }

        recursion++;
        map.put(recursion, greinList.toArray(Grein[]::new));
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

    public void setRecursion(int recursion) {
        this.recursion = recursion;
    }
}
