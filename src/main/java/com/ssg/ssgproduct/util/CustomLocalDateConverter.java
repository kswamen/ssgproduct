package com.ssg.ssgproduct.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateConverter {
    public static LocalDate convert(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }
}
