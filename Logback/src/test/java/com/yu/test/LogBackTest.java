package com.yu.test;

import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LogBackTest {
    private final static Logger logger = LoggerFactory.getLogger(LogBackTest.class);
    @Test
    public void test() {
        for (int i = 0; i < 100000000; i++) {
            logger.trace("=============奇遇少年");
            logger.debug("=============奇遇少年");
            logger.info("=============奇遇少年");
            logger.warn("=============奇遇少年");
            logger.error("=============奇遇少年");
        }

    }
}
