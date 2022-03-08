package com.umg.reactivo;

import dto.Persona;
import rx.Observable;
import rx.observables.MathObservable;

import java.util.ArrayList;
import java.util.List;

public class PersonaPromedio {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        //personas.add(new Persona(1, 32));
        //personas.add(new Persona(2, 33));
        //personas.add(new Persona(3, 34));
        //personas.add(new Persona(4, 35));
        //personas.add(new Persona(5, 36));


        Observable<Persona> personObservable = Observable.from(personas);

        MathObservable
                .from(personObservable)
                .averageInteger(Persona::getEdad)
                .subscribe((promedio) -> {
                    System.out.println("PROMEDIO:" + promedio);
                });
    }
}
