package com.example.sample.base.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CollectorsTest {

    @Test
    public void toListTest() {
        String s1 = new String("final fnial fanil proxy pxory abyss");
        var tokens = s1.split("\\s+");

        Stream.of(tokens).collect(
        // @formatter:off
            Collectors.toList()
        // @formatter:on
        ).forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void toMapTest() {
        String s1 = new String("final fnial fanil proxy pxory abyss");
        var tokens = s1.split("\\s+");

        Stream.of(tokens).collect(
        // @formatter:off
            Collectors.toMap(
                Function.identity(),   // keyMapper : key 생성, Function.identity() == t->t
                String::length,        // valueMapper : value 생성
                (oldV, newV) -> newV,  // mergeFunction : map에 element추가 중 key 충돌시 value 지정 
                LinkedHashMap::new     // mapFactory : default HashMap 타입이 아닌 다른 타입의 Map 생성자 호출
            )
        // @formatter:on
        ).forEach((k, v) -> {
            System.out.print("k:" + k);
            System.out.print(", v:" + v);
            System.out.println();
        });
    }

    /**
     * Collectors.groupingBy(delimiter)
     * making Map<K, List<V>>
     */
    @Test
    public void groupingByTests() {
        List<String> l1 = Arrays.asList("A", "B", "C", "D", "A");
        // Map<String, List<String>> m = l1.stream().collect(Collectors.groupingBy(Function.identity()))
        l1.stream().collect(Collectors.groupingBy(Function.identity())).forEach((k, v) -> {
            System.out.println("k::" + k);
            System.out.println("v::" + v);
        });

        // Map<String, List<String>>
        String s1 = new String("final fnial fanil proxy pxory abyss");
        String[] a1 = s1.split("\\s+");
        Arrays.asList(a1).stream().collect(
        // @formatter:off
            Collectors.groupingBy(
                // classifier == keyMapper, funtion to return map key for each unit of stream
                str -> {
                    var ar = str.toCharArray();
                    Arrays.sort(ar);
                    return String.valueOf(ar);
                }
                // str -> Stream.of(str.split("")).sorted().collect(Collectors.joining())
                // str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()
            )
        // @formatter:on
        ).forEach((k, v) -> {
            System.out.println("k::" + k);
            System.out.println("v::" + v);
        });
    }

    /**
     * Collectors.joining(delimiter)
     * concatenate string unit of stream
     */
    @Test
    public void joiningTest() {
        var l1 = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl"));
        System.out.println(l1.stream().collect(Collectors.joining(", ")));

        var l2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // if unit of stream is not String then need to convert unit type to String(.map(String::valueOf))
        System.out.println(l2.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
