package com.skwqy.study.reactor.example;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
        Flux.just(5,10).subscribe(System.out::print);
        LOG.info("------");
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::print);
        Flux.empty().subscribe(System.out::print);
        Flux.range(1, 10).subscribe(System.out::print);

        // 创建一个包含了从 0 开始递增的 Long 对象的序列。其中包含的元素按照指定的间隔来发布。
        // 除了间隔时间之外，还可以指定起始元素发布之前的延迟时间。
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

    @Test
    public void testReduce() {
        // 55
        Mono<Integer> result = Flux.range(1, 10).reduce((x, y) -> x + y);
        int resulInt = result.block();
        Assert.assertEquals(55, resulInt);

        // 155
        result = Flux.range(1, 10).reduceWith(() -> 100, (x, y) -> x + y);
        resulInt = result.block();
        Assert.assertEquals(155, resulInt);
    }

    @Test
    public void testMerge() {
        // 把多个流合并成一个 Flux 序列。merge 按照所有流中元素的实际产生顺序来合并
        // 0102134234
        Flux.merge(Flux.interval(Duration.of(10, ChronoUnit.MILLIS)).take(5), Flux.interval(Duration.of(5, ChronoUnit.MILLIS)).take(5))
                .toStream()
                .forEach(System.out::print);
        LOG.info("-------------------------");

        // mergeSequential 则按照所有流被订阅的顺序，以流为单位进行合并。
        // 0123401234
        Flux.mergeSequential(Flux.interval(Duration.of(10, ChronoUnit.MILLIS)).take(5), Flux.interval(Duration.of(5, ChronoUnit.MILLIS)).take(5))
                .toStream()
                .forEach(System.out::print);
    }

    // 把流中的每个元素转换成一个流，再把所有流中的元素进行合并
    @Test
    public void testFlatMap() {
        // 按照实际流产生的顺序进行合并
        // 010231423456789
        Flux.just(5, 10)
                .flatMap(x -> Flux.interval(Duration.of(x, ChronoUnit.MILLIS)).take(x))
                .toStream()
                .forEach(System.out::print);
        LOG.info("-------------------------");

        // 按照订阅的顺序进行合并
        // 012340123456789
        Flux.just(5, 10)
                .flatMapSequential(x -> Flux.interval(Duration.of(x, ChronoUnit.MILLIS)).take(x))
                .toStream()
                .forEach(System.out::print);
    }

    @Test
    public void testConcatMap() {
        // concatMap 操作符的作用也是把流中的每个元素转换成一个流，再把所有流进行合并。
        // 与 flatMap 不同的是，concatMap 会根据原始流中的元素顺序依次把转换之后的流进行合并；
        // 与 flatMapSequential 不同的是，concatMap 对转换之后的流的订阅是动态进行的，
        // 而 flatMapSequential 在合并之前就已经订阅了所有的流。
        Flux.just(5, 10)
                .concatMap(x -> Flux.interval(Duration.of(x, ChronoUnit.MILLIS)).take(x))
                .toStream()
                .forEach(System.out::print);
        LOG.info("-------------------------");
    }

    @Test
    public void testCombineLatest() {
        // combineLatest 操作符把所有流中的最新产生的元素合并成一个新的元素，作为返回结果流中的元素。
        // 只要其中任何一个流中产生了新的元素，合并操作就会被执行一次，结果流中就会产生新的元素。
        Flux.combineLatest(
                Arrays::toString,
                Flux.interval(Duration.of(100, ChronoUnit.MILLIS)).take(5),
                Flux.interval(Duration.of(20, ChronoUnit.MILLIS)).take(5)
        ).toStream().forEach(System.out::println);
    }

}