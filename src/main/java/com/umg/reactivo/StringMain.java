/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.reactivo;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author mmendez
 */
public class StringMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String[] names = {"demoa", "luis", "ajuan", "pedro", "Alexa"};

        //filtro
        Observable.from(names).filter(new Func1<String, Boolean>() {
                            @Override
                            public Boolean call(String t) {
                                return t.contains("a");
                            }
                        }// ordenamiento
                ).sorted().subscribe((valor)->{
                    System.out.println(valor);
                });

    }

}
