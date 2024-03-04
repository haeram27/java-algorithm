package com.example.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTests extends EvaluatedTimeTests {

    @Test
    public void hello() {
        System.out.println("hello");
    }
}
