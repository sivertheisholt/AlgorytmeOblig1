package com.oblig.systems;

import com.oblig.components.Grein;
import com.oblig.guis.Control;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

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
            double length = grein.getLengde()
                    * (controlGui.getLengdeAvvikSlider().getValue() == 0.3 ? lengthModifier : calculateLengthModifier( 1 - controlGui.getLengdeAvvikSlider().getValue()));

            double angleLeft = grein.getAngle()
                    + (Math.PI / controlGui.getVinkelSlider().getValue()
                    * (controlGui.getVinkelAvvikSlider().getValue() > 0 ? calculateAngleModifier(controlGui.getGreinAvvikSlider().getValue()) : 1));

            double angleRight = grein.getAngle()
                    - (Math.PI / controlGui.getVinkelSlider().getValue()
                    * (controlGui.getVinkelAvvikSlider().getValue() > 0 ? calculateAngleModifier(controlGui.getGreinAvvikSlider().getValue()) : 1));

            double x2Left = grein.getX2() + Math.cos(angleLeft) * length;
            double y2Left = grein.getY2() - Math.sin(angleLeft) * length;
            double x2Right = grein.getX2() + Math.cos(angleRight) * length;
            double y2Right = grein.getY2() - Math.sin(angleRight) * length;

            //venstre grein
            if(!calculateVisibilityModifier(controlGui.getGreinAvvikSlider().getValue())) {
                gc.strokeLine(grein.getX2(), grein.getY2(), x2Left, y2Left);
                greinList.add(new Grein(grein.getX2(), grein.getY2(), x2Left, y2Left, length, grein.getAngle() + angleModifier));
            }

            //Høyre grein
            if(!calculateVisibilityModifier(controlGui.getGreinAvvikSlider().getValue())) {
                gc.strokeLine(grein.getX2(), grein.getY2(), x2Right, y2Right);
                greinList.add(new Grein(grein.getX2(), grein.getY2(), x2Right, y2Right, length, grein.getAngle() - angleModifier));
            }
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
        double rangeMax = chance * 2;
        Random random = new Random();
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }
    public void clearCanvas() {
        gc.clearRect(0,0,gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    private boolean calculateVisibilityModifier(double chance) {
        Integer[] random = {1, 1,
                        2, 2, 2, 2,
                        3, 3, 3, 3, 3, 3,
                        4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                        5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        List<Integer> list = Arrays.asList(random);
        Collections.shuffle(list);

        switch((int) chance) {
            case 1:
                return list.get(0) == 1 ? true : false;
            case 2:
                return list.get(0) == 2 ? true : false;
            case 3:
                return list.get(0) == 3 ? true : false;
            case 4:
                return list.get(0) == 4 ? true : false;
            case 5:
                return list.get(0) == 5 ? true : false;
        }
        return false;
    }

    public void setRecursion(int recursion) {
        this.recursion = recursion;
    }
}