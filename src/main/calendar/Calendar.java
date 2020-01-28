package main.calendar;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Calendar {

    public static GregorianCalendar cal = new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());

    public GregorianCalendar getCal() {
        return cal;
    }

}
