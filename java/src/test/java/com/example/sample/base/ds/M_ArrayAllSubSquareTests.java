package com.example.sample.base.ds;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M_ArrayAllSubSquareTests {
    /**
     * find all sub square from given Rectangle(NxM) array
     * Square is NxN shape of Rectangle !!!
     * start coordinate is most left bottom point
     * end coordinate is most right top point
     * 
     * key point:
     * [s][ ][ ]
     * [ ][e][ ]
     * [ ][ ][e]
     * s = start point(startY,startY) of square
     * e = end points(endY,endY) of square when start point is s
     *
     *   endX == startX + off
     *   endY == startY + off
     */
    private static Stream<Arguments> provideSquareLength() {
        // @formatter:off
        return Stream.of(
            Arguments.of(2, 2),  // 1
            Arguments.of(2, 3),  // 2
            Arguments.of(3, 3),  // 5
            Arguments.of(4, 4),  // 14
            Arguments.of(4, 5)); // 20
        // @formatter:on
    }

    @ParameterizedTest
    @MethodSource("provideSquareLength")
    void allSubSquare(int rowLen, int colLen) {
        int count = 0;
        System.out.println(count);
    }

    @ParameterizedTest
    @MethodSource("provideSquareLength")
    void allSubSquare_answer(int rowLen, int colLen) {
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
