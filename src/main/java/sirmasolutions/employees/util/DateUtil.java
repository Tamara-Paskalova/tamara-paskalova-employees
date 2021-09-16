package sirmasolutions.employees.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate convertToDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }
}
