package com.skwqy.study.reactor.example;

import reactor.core.publisher.Flux;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/21 9:13 PM
 */
public class FluxExample {
    public static void main(String[] args) {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
    }
}
