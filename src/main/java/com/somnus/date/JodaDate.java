package com.somnus.date;

import java.util.Calendar;

import org.joda.time.DateTime;

/** 
 * @Description: TODO
 * @author Somnus
 * @date 2015年8月6日 下午4:25:45 
 * @version V1.0 
 */
public class JodaDate {
    public static void main(String[] args) {
        System.out.println(DateTime.now().toString("yyyy-MM-dd"));
        DateTime dateTime = new DateTime(2015, 11, 11, 0, 0, 0, 0);
        System.out.println(dateTime.toString("yyyy-MM-dd"));
        //加上 90 天
        System.out.println(dateTime.plusDays(9).toString("yyyy-MM-dd"));
        // 当前周的周一，周日  
        System.out.println(String.format(  
                "min:%s, max:%s",  
                DateTime.now().dayOfWeek().withMinimumValue()  
                        .toString("yyyy-MM-dd"),  
                DateTime.now().dayOfWeek().withMaximumValue()  
                        .toString("yyyy-MM-dd")));  
        // 当前月的第一天和最后一天  
        System.out.println(String.format(  
                "min:%s, max:%s",  
                DateTime.now().dayOfMonth().withMinimumValue()  
                        .toString("yyyy-MM-dd"),  
                DateTime.now().dayOfMonth().withMaximumValue()  
                        .toString("yyyy-MM-dd")));  
        // 当前年的第一天和最后一天  
        System.out.println(String.format(  
                "min:%s, max:%s",  
                DateTime.now().dayOfYear().withMinimumValue()  
                        .toString("yyyy-MM-dd"),  
                DateTime.now().dayOfYear().withMaximumValue()  
                        .toString("yyyy-MM-dd"))); 
        //Joda 和 JDK 互操作性
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime.toDate());
        System.out.println(calendar.get(Calendar.YEAR));
        //在当月第几天
        System.out.println(DateTime.now().getDayOfMonth());
    }
}
