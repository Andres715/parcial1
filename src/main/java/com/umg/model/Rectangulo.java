package com.umg.model;

public class Rectangulo extends FiguraGeometrica{
    private int altura;
    private int base;

    public double getArea(){
        return base * altura;
    }

    public double getPerimetro() {
        return 2 * altura + 2 * base;
    }
}
