package com.oblig.components;

import javafx.scene.shape.Line;

public class Grein {
    private double x;
    private double y;
    private double x2;
    private double y2;
    private double lengde;
    private double angle;

    public Grein(double x, double y, double x2, double y2, double lengde, double angle) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.lengde = lengde;
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public double getLengde() {
        return lengde;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
