package com.todo.backend.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class DateFormatter {

    public static Instant fromDateToInstant(Date date){

        return new Timestamp(date.getTime()).toInstant();
    }

    public static Date fromInstantToDate(Instant instant) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(Date.from(instant));

        Date date = new Date();

        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
