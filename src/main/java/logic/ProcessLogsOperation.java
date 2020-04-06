package main.java.logic;

import main.java.helper.FileHelper;
import main.java.helper.LocalDateTimeRounder;
import main.java.helper.StatisticsFormatter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static main.java.constants.Commons.*;

public class ProcessLogsOperation {

    public static void process() {
        List<String> logs = FileHelper.readFolder(LOGS);
        Map<LocalDateTime, Long> errorCounterMap = getErrorCounterMap(logs);
        List<String> output = StatisticsFormatter.formatByHours(errorCounterMap);
        System.out.println(String.join("\n", output));
        FileHelper.write(String.join("\n", output), STATS);
    }

    private static Map<LocalDateTime, Long> getErrorCounterMap(List<String> logs) {
        return logs.stream()
                .filter(log -> ERROR.matcher(log).find())
                .map(log -> log.substring(0, log.indexOf(';')))
                .map(LocalDateTime::parse)
                .map(LocalDateTimeRounder::roundToHours)
                .collect(Collectors.groupingBy(dateTime -> dateTime, TreeMap::new, Collectors.counting()));
    }

}
