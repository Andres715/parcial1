package com.umg.reactivo;

import rx.Observable;

public class MapMain {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};

        Observable<Integer> miObservable = Observable.from(numbers);

        Observable resultadoMap =
                miObservable
                        .map((item) -> {
                            return item * 10;
                        });

        resultadoMap.subscribe((item) -> {
            System.out.println("item:" + item);
        });


    }
}
