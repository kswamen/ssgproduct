package com.ssg.ssgproduct.util;

import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.exception.exceptioncase.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomLocalDateConverter {
    public static LocalDate convert(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException ex) {
            throw new InvalidDateFormatException(ResponseCode.INVALID_DATETIME_FORMAT);
        }
    }

    public static boolean isValidStartAndEndDate(LocalDate startDate, LocalDate endDate) {
        return !startDate.isAfter(endDate);
    }
}
