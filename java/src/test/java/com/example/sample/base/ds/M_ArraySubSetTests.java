package com.example.sample.base.ds;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M_ArraySubSetTests {
    /**
     * find all sub set index of given array length
     */
    private static Stream<Arguments> provideLength() {
        // @formatter:off
        return Stream.of(
            Arguments.of(3),
            Arguments.of(4),
            Arguments.of(5),
            Arguments.of(6),
            Arguments.of(7));
        // @formatter:on
    }

    @ParameterizedTest
    @MethodSource("provideLength")
    void allSubSet(int len) {
        int count = 0;

        System.out.println(count);
    }

    /* Answer */
    @ParameterizedTest
    @MethodSource("provideLength")
    void allSubSetA(int len) {
        int count = 0;

        // [s, e) = {s <= x < e}
        // s is opened(include) index
        for (int s = 0; s < len; ++s) {
            // e is closed(NOT include) index
            for (int e = s + 1; e < len + 1; ++e) {
                System.out.println(String.format("%d, %d", s, e));
                count++;
            }
        }

        System.out.println(count);
    }

}
