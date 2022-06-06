package com.example.android.quakereport;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {
    private static final String DATE_FORMATTER = "d MMM, yyyy";
    private static final String TIME_FORMATTER = "h:mm a";

    private DateTimeUtils() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String formatDate(long milliseconds) {
        LocalDate date = Instant.ofEpochMilli(milliseconds).atZone(ZoneId.of("GMT")).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER, Locale.ENGLISH);
        return formatter.format(date);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String formatTime(long milliseconds) {
        LocalTime time = Instant.ofEpochMilli(milliseconds).atZone(ZoneId.of("GMT")).toLocalTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMATTER, Locale.ENGLISH);
        return formatter.format(time);
    }
}
