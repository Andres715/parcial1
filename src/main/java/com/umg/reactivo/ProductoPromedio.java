package com.umg.reactivo;

import dto.Producto;
import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.observables.MathObservable;
import rx.math.operators.OperatorMinMax;

import java.util.ArrayList;
import java.util.List;

public class ProductoPromedio {
	
	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto(0, "ps4", 300));
		productos.add(new Producto(1, "gamecube", 300));
		productos.add(new Producto(2, "external disk", 200));
		productos.add(new Producto(3, "laptop", 800));
		productos.add(new Producto(4, "vr", 230));


        Observable<Producto> productObservable = Observable.from(productos);

        MathObservable.from(productObservable)
        .sumInteger(Producto::getPrice)
        .subscribe((sumatoria) -> {
        	System.out.println("Sumatoria de los precios:" + sumatoria);
        });
        
        Observable miObservable =
        		Observable
        		.from(productos.toArray())
        		.map((result) -> {
        			Producto producto = (Producto) result;
        			return producto.getPrice();
        		})
        		.reduce(
        				new Func2<Integer, Integer, Integer>() {
							
							@Override
							public Integer call(Integer anterior, Integer actual) {
								// TODO Auto-generated method stub
								if(anterior>actual) {
									return anterior;
								} else {
									return actual;
								}
							}
						}
        		);
        
        miObservable.subscribe((maximo) -> {
        	System.out.println("El precio mayor es: " + maximo);
        });
		
	}
}
