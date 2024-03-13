package org.example.Model.Utill;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@UtilityClass
public class DateFormatter {

    private final static String pattern = "yyyy-MM-dd";
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(pattern);

    public  LocalDate parseLocalDate(String date)
    {
        return LocalDate.parse(date, DATE_TIME_FORMATTER);
    }
    public boolean isValid(String date)
    {
        try {
            parseLocalDate(date);
            return true;
        }
        catch (DateTimeParseException e)
        {
            return false;
        }

    }

}
