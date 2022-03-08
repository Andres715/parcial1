package com.umg.model;

public class Triangulo extends FiguraGeometrica {
    private int base;
    private int altura;

    public double getArea() {
        return (base * altura) / 2;
    }

}
