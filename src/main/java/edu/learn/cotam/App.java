package edu.learn.cotam;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(DateTimeUtils.plusDays(now,20));
        System.out.println(DateTimeUtils.minusDays(now,20));
        System.out.println(DateTimeUtils.changeTimeInDate(now,0,0,0));
        System.out.println(DateTimeUtils.getHours(now));
    }
}
