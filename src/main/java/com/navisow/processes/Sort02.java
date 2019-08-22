package com.navisow.processes;

import org.apache.log4j.Logger;

import java.util.stream.Stream;

public class Sort02 implements Process {
    private static final Logger logger = Logger.getLogger(Sort02.class);

    public void go() {
        logger.info("infinite stream:");
        Stream.iterate(0, n -> n + 1)
            .limit(10)
            .forEach(logger::info);

        logger.info("Fibonacci");
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(20)
            .map(n -> n[0])
            .forEach(logger::info);

    }
}
