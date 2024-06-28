package com.projarc.appsigncontrol.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private static String pattern = "yyyy-mm-dd";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

    public static LocalDate parseToLocalDate(String date) {
        return LocalDate.parse(date, formatter);
    }

    public static String parseToString(LocalDate date) {
        return date.format(formatter);
    }
}
