package com.example.sample.exam;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.sample.EvaluatedTimeTests;

@SpringBootTest
public class LocalTimeDateTests extends EvaluatedTimeTests {

    @Test
    public void localDateTimeToLong() {

        /*
         * time to long
         */
        long utcTimestamp = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
        // 2024-03-10T01:21:36.022Z
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(utcTimestamp), ZoneId.of("UTC")));
        // 2024-03-10T01:21:36.022Z[UTC]
        System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(utcTimestamp), ZoneId.of("UTC")));

        long localTimestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        // 2024-03-10T01:21:36.023+09:00[Asia/Seoul]
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(localTimestamp), ZoneId.systemDefault()));
        // 2024-03-10T01:21:36.023+09:00[Asia/Seoul]
        System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(localTimestamp), ZoneId.systemDefault()));

        /*
         * timezone
         */
        System.out.println(ZoneId.systemDefault()); // Asia/Seoul
        System.out.println(ZoneId.of("Asia/Seoul")); // Asia/Seoul
        System.out.println(ZoneId.of("UTC")); // UTC
        System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(9))); // UTC+09:00
        System.out.println(ZoneId.ofOffset("", ZoneOffset.ofHours(9))); // +09:00
        // System.out.println(ZoneId.getAvailableZoneIds());
    }

}
