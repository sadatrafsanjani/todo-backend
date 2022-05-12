package com.todo.backend.utility;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class DateFormatter {

    public static Instant fromDateToInstant(Date date){

        return new Timestamp(date.getTime()).toInstant();
    }

    public static Date fromInstantToDate(Instant instant){

        return Date.from(instant);
    }
}
