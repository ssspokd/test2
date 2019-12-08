package com.company.utils;

import com.sun.javafx.binding.StringFormatter;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public  static  long genereateDate(){
        Date endDate = new Date(new Date().getYear(), 1,1);
        Date startDate = new Date((endDate.getYear() - 1),1,1 );
        return ThreadLocalRandom.current().longs(1, startDate.getTime() , endDate.getTime()).toArray()[0];
    }

    public  static float generateSum(){
        float leftLimit = 10_000.12F;
        float rigthLimit = 1000_000.15F;
        return leftLimit + new Random().nextFloat() * (rigthLimit - leftLimit);
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static String convertDate(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return String.format("%s.%s.%s %s:%s",
                calendar.get(Calendar.DATE),
                calendar.get(Calendar.MONDAY) +1,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE));
    }

}
