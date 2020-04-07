package main.java.helper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticsFormatter {

    public static List<String> formatByHours(Map<LocalDateTime, Long> errorCounterMap) {
        return format(errorCounterMap, TimeRangeHelper::getTimeRange);
    }

    public static List<String> formatByMinutes(Map<LocalDateTime, Long> errorCounterMap) {
        return format(errorCounterMap, LocalTime::toString);
    }

    private static List<String> format(Map<LocalDateTime, Long> errorCounterMap,
                                       Function<LocalTime, String> timeRangeFormatter) {
        return errorCounterMap.entrySet().stream()
                .map(entry -> {
                    LocalDateTime localDateTime = entry.getKey();
                    LocalTime localTime = localDateTime.toLocalTime();
                    return localDateTime.toLocalDate() + ", " + timeRangeFormatter.apply(localTime) +
                            " Количество ошибок: " + entry.getValue();
                }).collect(Collectors.toList());
    }
}
