package com.example.sample.lang;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OptionalTests {
    @Test
    public void run() {
        String nonNullStr = "hello";
        String nullStr = null;
        Optional.ofNullable(nullStr).ifPresentOrElse(e -> {
            System.out.println(e);
        }, () -> {
            System.out.println("null");
        });

        Optional.ofNullable(nonNullStr).ifPresentOrElse(e -> {
            System.out.println(e);
        }, () -> {
            System.out.println("null");
        });

    }
}
