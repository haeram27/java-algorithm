package com.example.sample.base.ds;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArraySubSetTests {
    /**
     * find all sub set index of given array length
     */
    private static Stream<Arguments> provideSquareLength() {
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
    void allSubSet(int rowLen, int colLen) {
        int count = 0;

        System.out.println(count);
    }

    @ParameterizedTest
    @MethodSource("provideLength")
    void allSubSet_answer(int rowLen, int colLen) {
        int count = 0;
        int maxOffset = Math.max(rowLen, colLen);

        for (int row = 0; row < rowLen; ++row) {
            for (int col = 0; col < colLen; ++col) {
                for (int off = 1; off < maxOffset; off++) {

                    int startX = row;
                    int startY = col;
                    int endX = row + off;
                    int endY = col + off;

                    if (endX < rowLen && endY < colLen) {
                        ++count;

                        System.out.println(String.format("%d %d %d %d", startX, startY, endX, endY));
                    }
                }
            }
        }

        System.out.println(count);
    }

}
