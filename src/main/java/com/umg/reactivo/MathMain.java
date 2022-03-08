/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.reactivo;

import rx.Observable;
import rx.observables.MathObservable;

/**
 * @author mmendez
 */
public class MathMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Observable<Integer> sourceObservable = Observable.range(1, 5);

        MathObservable
                .averageInteger(sourceObservable)
                .subscribe((data) -> {
                    System.out.println("Result:" + data);
                });

    }

}
