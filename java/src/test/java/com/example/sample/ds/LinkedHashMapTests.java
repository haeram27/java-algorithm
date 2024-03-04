package com.example.sample.ds;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LinkedHashMapTests {
    @Test
    public void run() {
        LinkedHashMap<String, String> lhs = new LinkedHashMap<>();
        lhs.put("1", "a");
        lhs.put("2", "b");
        lhs.entrySet().forEach(e -> {
            System.out.println("k::" + e.getKey());
            System.out.println("v::" + e.getValue());
        });

        lhs.forEach((k, v) -> {
            System.out.println("k::" + k);
            System.out.println("k::" + v);
        });

    }
}
