package com.skwqy.study.reactor.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
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
        Mono.justOrEmpty(Optional.of(",[justOrEmpty] Hello")).subscribe(System.out::print);
        Mono.create(sink -> sink.success(", [create] hello")).subscribe(System.out::print);
    }

    /**
     * ---------将当前流中的元素收集到集合中，并把集合对象作为流中的新元素----------
     * 收集，返回结果：Flux<List<T>>
     */
    @Test
    public void testBuffer() {
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
        // Until 收集直到条件达成，则组成一组
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        // While 只收集符合条件的元素
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

    }

    //收集， 返回结果： Flux<Flux<T>>
    @Test
    public void testWindow() {
        Flux.range(1, 100).window(20).subscribe(System.out::println);
    }

    @Test
    public void testFilter() {
        // 过滤，只选择符合条件的元素
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
    }

    @Test
    public void testZipWith() {
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);
    }


    @Test
    public void testTake() {
        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);
    }

}