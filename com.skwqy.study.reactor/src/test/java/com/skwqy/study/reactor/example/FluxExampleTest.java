package com.skwqy.study.reactor.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created on 2018 11 2018/11/21 9:18 PM
 */
public class FluxExampleTest {
    private Logger LOG = LoggerFactory.getLogger(FluxExampleTest.class);

    // 创建Flux序列
    @Test
    public void testCreateFlux() {
        // 简单创建
        Flux.just("Hello", "World").subscribe(System.out::print);
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::print);
        Flux.empty().subscribe(System.out::print);
        Flux.range(1, 10).subscribe(System.out::print);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::print);

        // 复杂创建
        Flux.generate(sink -> {
            sink.next("Hello");  // next() 只能调用一次
            //sink.next("skwqy");
            sink.complete();
        }).subscribe(System.out::print);

        Flux.generate(ArrayList::new, (list, sink) -> {
            Random random = new Random();
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::print);

        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);  // 可以创建多次
            }
            sink.complete();
        }).subscribe(System.out::print);
    }

    @Test
    public void createMono() {
        Mono.just("skwqy").subscribe(System.out::print);
        Mono.fromCallable(() -> ", I am skwqy").subscribe(System.out::print);
        Mono.fromCompletionStage(() -> CompletableFuture.completedFuture(", completable skwqy")).subscribe(System.out::print);
        Mono.fromFuture(() -> CompletableFuture.completedFuture(", Future skwqy")).subscribe(System.out::print);
        Mono.fromRunnable(() -> {
            System.out.println("");
            LOG.info(", Runnable skwqy");
        }).subscribe(System.out::print);

        Mono.fromSupplier(() -> "Supplier skwqy").subscribe(System.out::print);
    }

}