package com.aishidai.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeUtil {

    static final String data_format = "yyyy-MM-dd hh:mm:ss";
    static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();
    static Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);


    public static DateFormat getDateFormat()
    {
        DateFormat df = threadLocal.get();
        if(df==null){
            df = new SimpleDateFormat(data_format);
            threadLocal.set(df);
        }
        return df;
    }

    public static Long toUnixTime(String dateTime){
        try {
            return getDateFormat().parse(dateTime).getTime() / 1000;
        } catch (ParseException e) {
            logger.error("parse time fails! {}", dateTime);
        }

        return null;
    }

    public static String toDataString(String unixTime) {
        return getDateFormat().format(new Date(Long.parseLong(unixTime)*1000));
    }
    
}
