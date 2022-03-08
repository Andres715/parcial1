package com.umg.logica;

import com.umg.model.Circulo;
import com.umg.model.FiguraGeometrica;
import com.umg.model.Rectangulo;
import com.umg.model.Triangulo;

import java.util.ArrayList;
import java.util.List;

public class Mantenimiento {

    public static void main(String[] args) {
        List<Circulo> listaCirculo = new ArrayList<Circulo>();
        List<Rectangulo> listaRectangulo = new ArrayList<Rectangulo>();
        List<Triangulo> listaTriangulo = new ArrayList<Triangulo>();

        List<FiguraGeometrica> listaGenerica = new ArrayList<FiguraGeometrica>();
        listaGenerica.add(new Circulo());
        listaGenerica.add(new Triangulo());
        listaGenerica.add(new Rectangulo());

        FiguraGeometrica obj1 = listaGenerica.get(0);
        obj1.getArea();

        FiguraGeometrica obj2;
        obj2 = (Circulo)listaGenerica.get(0);

        FiguraGeometrica obj3 = new Circulo();
        Circulo cir01 = (Circulo)listaGenerica.get(0);
        
        listaCirculo.add(new Circulo());
        listaRectangulo.add(new Rectangulo());
        listaTriangulo.add(new Triangulo());
        
    }
}