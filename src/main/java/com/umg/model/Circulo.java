package com.umg.model;

public class Circulo extends FiguraGeometrica{
    private int radio;

    public double getArea() {
        return radio * 3.1416;
    }

    public double getCircunferencia() {
        return 20.00;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}
