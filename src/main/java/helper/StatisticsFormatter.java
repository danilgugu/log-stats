package main.java.helper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsFormatter {

    public static List<String> formatByHours(Map<LocalDateTime, Long> errorCounterMap) {
        return errorCounterMap.entrySet().stream()
                .map(entry -> {
                    LocalDateTime localDateTime = entry.getKey();
                    LocalTime localTime = localDateTime.toLocalTime();
                    return localDateTime.toLocalDate() + ", " + TimeRangeHelper.getTimeRange(localTime) +
                            " Количество ошибок: " + entry.getValue();
                }).collect(Collectors.toList());
    }

    public static List<String> formatByMinutes(Map<LocalDateTime, Long> errorCounterMap) {
        return errorCounterMap.entrySet().stream()
                .map(entry -> {
                    LocalDateTime localDateTime = entry.getKey();
                    LocalTime localTime = localDateTime.toLocalTime();
                    return localDateTime.toLocalDate() + ", " + localTime +
                            " Количество ошибок: " + entry.getValue();
                }).collect(Collectors.toList());
    }
}
