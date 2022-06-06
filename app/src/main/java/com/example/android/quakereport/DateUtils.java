package com.example.android.quakereport;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {
    private static final String DATE_TIME_FORMATTER = "d MMM, yyyy";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String format(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER, Locale.ENGLISH);
        return formatter.format(date);
    }
}
