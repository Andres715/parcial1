/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.reactivo;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.MathObservable;

/**
 * @author mmendez
 */
public class ReduceMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer[] numbers = {2,5,6,8,10,35,2,10};

        Observable number = Observable.from(numbers);
        
        MathObservable
        .averageInteger(number)
        .subscribe((promedio) -> {
        	System.out.println("El Promedio de los numeros es: " + promedio);
        });
        
        System.out.println("--------------------------------------------------");

        MathObservable
        .sumInteger(number)
        .subscribe((sumatoria) -> {
        	System.out.println("La Sumatoria de los numeros es: " + sumatoria);
        });
        
        System.out.println("--------------------------------------------------");
        
        Observable.from(numbers)
        .filter(new Func1<Integer, Boolean>() {
        	@Override
        	public Boolean call(Integer item) {
        		return(item >= 10);
        	}
		})
        .subscribe(new Subscriber<Integer>() {
        	@Override
        	public void onNext(Integer item) {
        		System.out.println("Item mayor o igual a 10: " + item);
        	}
        	@Override
            public void onError(Throwable error) {
                System.err.println("Error: " + error.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }
		});
    }

}
