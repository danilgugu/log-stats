package main.java.helper;

import java.time.LocalTime;

public class TimeRangeHelper {

    public static String getTimeRange(LocalTime localTime) {
        return localTime.toString() + "-" + localTime.plusHours(1).toString();
    }
}
