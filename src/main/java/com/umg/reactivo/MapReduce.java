package com.umg.reactivo;

import dto.Persona;
import rx.Observable;
import rx.functions.Func2;

import java.util.ArrayList;
import java.util.List;

public class MapReduce {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};

        List<Persona> personas = new ArrayList<>();

        //Persona datoPersona = new Persona(0,31,"William");
        //personas.add(datoPersona);
        personas.add(new Persona(0, 20,"William"));
        personas.add(new Persona(1, 20,"Andres"));
        personas.add(new Persona(2, 19,"Carla"));
        personas.add(new Persona(3, 21,"Mishell"));
        personas.add(new Persona(4, 28,"Peter"));
        personas.add(new Persona(5, 21,"Gerson"));

        Observable miobservable =
                Observable
                        // se envia el streaming de personas...
                        .from(personas.toArray())
                        /* sin embargo se intercepta para usar unicamente el campo que necesito calcular, esto ocurre
                        antes del reduce */
                        .map((result) -> {
                            // por cada persona.... transformar a Integer !! con la funcion MAP
                            // mapea el objeto del streaming a un valor en el cual se pueda calcular
                            Persona persona = (Persona) result;
                            return persona.getEdad();
                        })
                        // cuando llega al reduce, lo que ya recibo es unicamente datos enteros
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer anterior, Integer actual) {
                                        //retornar sumatoria
                                    	//return acumulador + actual;
                                    	
                                    	if(anterior>actual) {
                                    		return anterior;
                                    	} else {
                                    		return actual;
                                    	}
                                    }
                                }
                        );

        miobservable.subscribe((max) -> {
            System.out.println("La mayor edad es: " + max);
        });

       /* miobservable.subscribe((sumatoria) -> {
            System.out.println("resultado2:" + sumatoria);

            // enviar a servicio rest
        });*/
    }
}
