package com.example.sample.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M_EssentialTests {
    String s = "abcdeghijklmn";
    String s1 = "abcdeg hijklmn";

    @Test
    public void primitiveArrayDescSort() {
        int a[] = { 1, 2, 3, 4, 5 };
        var sorted = a;

        // TODO:

        System.out.println(Arrays.toString(sorted));
    }

    @Test
    public void primitiveArrayDescSortA() {
        int a[] = { 1, 2, 3, 4, 5 };
        var sorted = a;

        // boxed() = int -> Integer
        // mapToInt() =  Integer -> int
        sorted = Arrays.stream(a).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(sorted));
    }

    @Test
    public void stringReverseTest() {
        // TODO:
        System.out.println(s);
    }

    @Test
    public void stringReverseTestA() {
        System.out.println(new StringBuilder(s).reverse());
    }

    @Test
    public void CodePointStreamSort() {
        String sorted = "";
        // TODO: map codepoint to each string > sort > join to one String
        // sorted = s.chars()...

        System.out.println(sorted);
    }

    @Test
    public void CodePointStreamSortA() {
        String sorted;

        // recommended
        sorted = s.chars().mapToObj(Character::toString).sorted(Collections.reverseOrder())
                .collect(Collectors.joining());
        System.out.println(sorted);

        // IntStream.sorted() can NOT use Collections.reverseOrder
        sorted = s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(sorted);
    }

    @Test
    public void StringStreamSort() {
        String sorted = "";
        // TODO: steam with split to each char String > sort > join to one String
        // sorted = Stream.of(s...)

        System.out.println(sorted);
    }

    @Test
    public void StringStreamSortA() {
        String sorted;
        sorted = Stream.of(s.split("")).sorted().collect(Collectors.joining());
        System.out.println(sorted);
        sorted = Stream.of(s1.split("")).filter(e -> !e.isBlank()).sorted().collect(Collectors.joining());
        System.out.println(sorted);
        sorted = Stream.of(s.split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
        System.out.println(sorted);
    }

    @Test
    public void CharArrayAscendingSort() {
        var ar = s.toCharArray();
        // TODO:

        System.out.println(new String(ar));
    }

    @Test
    public void CharArrayAscendingSortA() {
        var ar = s.toCharArray();
        Arrays.sort(ar);
        System.out.println(new String(ar));
    }

    @Test
    public void CharArrayDescendingSort() {
        var ar = s.toCharArray();
        // TODO: use array swap

        System.out.println(new String(ar));
    }

    @Test
    public void CharArrayDescendingSortA() {
        var ar = s.toCharArray();
        Arrays.sort(ar);
        for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
            char tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
        }

        System.out.println(new String(ar));
    }

    @Test
    void mapToListTest() {
        var m = new LinkedHashMap<String, List<Integer>>();
        m.put("a", Stream.of(1, 2, 3).collect(Collectors.toList()));
        m.put("b", Stream.of(4, 5, 6).collect(Collectors.toList()));
        m.put("c", Stream.of(7, 8, 9).collect(Collectors.toList()));

        // TODO: start
        // use new ArrayList
        var list1 = new ArrayList<Map.Entry<String, List<Integer>>>();
        // use Map.entrySet().stream()
        var list2 = new ArrayList<Map.Entry<String, List<Integer>>>();
        // TODO: end

        list1.forEach(e -> {
            System.out.print(e.getKey() + ":");
            for (var v : e.getValue()) {
                System.out.print(v + ",");
            }
            System.out.println();
        });

        list2.forEach(e -> {
            System.out.print(e.getKey() + ":");
            for (var v : e.getValue()) {
                System.out.print(v + ",");
            }
            System.out.println();
        });
    }

    @Test
    void mapToListTestA() {
        var m = new LinkedHashMap<String, List<Integer>>();
        m.put("a", Stream.of(1, 2, 3).collect(Collectors.toList()));
        m.put("b", Stream.of(4, 5, 6).collect(Collectors.toList()));
        m.put("c", Stream.of(7, 8, 9).collect(Collectors.toList()));

        // TODO: start
        var list1 = new ArrayList<Map.Entry<String, List<Integer>>>(m.entrySet());
        var list2 = m.entrySet().stream().collect(Collectors.toList());
        // TODO: end

        list1.forEach(e -> {
            System.out.print(e.getKey() + ":");
            for (var v : e.getValue()) {
                System.out.print(v + ",");
            }
            System.out.println();
        });

        list2.forEach(e -> {
            System.out.print(e.getKey() + ":");
            for (var v : e.getValue()) {
                System.out.print(v + ",");
            }
            System.out.println();
        });
    }

    @Test
    void mapSortByKey() {
        var m = new LinkedHashMap<String, Integer>();
        m.put("a", 3);
        m.put("b", 2);
        m.put("c", 1);

        // TODO:
    }

    @Test
    void mapSortByKeyA() {
        var m = new LinkedHashMap<String, Integer>();
        m.put("a", 3);
        m.put("b", 2);
        m.put("c", 1);

        // TODO:
        m.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            System.out.println(e.getKey() + ":" + e.getValue());
        });

        m.entrySet().stream().sorted(Map.Entry.comparingByKey(Collections.reverseOrder())).forEach(e -> {
            System.out.println(e.getKey() + ":" + e.getValue());
        });
    }

    @Test
    void mapSortByValue() {
        var m = new LinkedHashMap<String, Integer>();
        m.put("a", 3);
        m.put("b", 2);
        m.put("c", 1);

        // TODO:
    }

    @Test
    void mapSortByValueA() {
        var m = new LinkedHashMap<String, Integer>();
        m.put("a", 3);
        m.put("b", 2);
        m.put("c", 1);

        // TODO:
        m.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> {
            System.out.println(e.getKey() + ":" + e.getValue());
        });

        m.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).forEach(e -> {
            System.out.println(e.getKey() + ":" + e.getValue());
        });
    }

}
