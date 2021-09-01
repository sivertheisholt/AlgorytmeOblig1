package com.oblig.components;

/**
 * Grein inneholder informasjon om en linje som blir tegnet
 */
public class Grein {
    private double x;
    private double y;
    private double x2;
    private double y2;
    private double lengde;
    private double angle;

    /**
     * Konstrukter for en grein
     * @param x start x
     * @param y start y
     * @param x2 slutt x
     * @param y2 slutt y
     * @param lengde lengde som linjen fikk (Kunne også bare blitt kalkulert her istedenfor)
     * @param angle vinkel på linjen
     */
    public Grein(double x, double y, double x2, double y2, double lengde, double angle) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.lengde = lengde;
        this.angle = angle;
    }

    /** Getters og setters **/

    public double getAngle() {
        return angle;
    }

    public double getLengde() {
        return lengde;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

}
