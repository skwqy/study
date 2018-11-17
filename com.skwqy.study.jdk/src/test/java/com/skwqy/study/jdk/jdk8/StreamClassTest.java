package com.skwqy.study.jdk.jdk8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamClassTest {
    private static Logger LOG = LoggerFactory.getLogger(StreamClassTest.class);
    @Test
    public void testStreamApi()
    {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        ) ;
        Stream<Integer> outputStream = inputStream.flatMap(list -> list.stream());

        //outputStream.forEach(System.out::print);

        LOG.info(""+ outputStream.reduce( (a,b) -> {LOG.info(a+": "+b); return a+b;} ).get().intValue());


    }
}