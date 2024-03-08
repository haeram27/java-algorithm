package com.example.sample.quiz;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class WordGroupingTest {
    /* 
        make group of token consist of same alphabets
        and print each group in each line
        
        output for s1 ::
        final fnial fanil
        proxy pxory
        abyss
    */
    String s1 = new String("final fnial fanil proxy pxory abyss");
    String s2 = new String("fired gainly dreads listen silent fried");

    @Test
    void run() {
        // TODO:
    }

    void answer() {
        Map<String, List<String>> m = new LinkedHashMap<>();

        String[] tokens = s2.split(" ");
        for (String t : tokens) {
            if (t.length() > 0) {
                char[] ar = t.toCharArray();
                Arrays.sort(ar);
                var k = new String(ar);
                if (m.containsKey(k)) {
                    m.get(k).add(t);
                } else {
                    m.put(k, Stream.of(t).collect(Collectors.toList()));
                }
            }
        }

        m.forEach((k, v) -> {
            for (var s : v) {
                System.out.print(s + " ");
            }
            System.out.println();
        });
    }

}


