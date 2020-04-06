package main.java.helper;

import java.time.LocalDateTime;

public class LocalDateTimeRounder {

    public static LocalDateTime roundToHours(LocalDateTime localDateTime) {
        return localDateTime
                .minusMinutes(localDateTime.getMinute())
                .minusSeconds(localDateTime.getSecond())
                .minusNanos(localDateTime.getNano());
    }

    public static LocalDateTime roundToMinutes(LocalDateTime localDateTime) {
        return localDateTime
                .minusSeconds(localDateTime.getSecond())
                .minusNanos(localDateTime.getNano());
    }
}
