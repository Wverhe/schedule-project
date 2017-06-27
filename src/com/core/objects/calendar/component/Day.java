package com.core.objects.calendar.component;

/**
 * Created by agaspari on 6/27/2017.
 */
public enum Day {
    SUNDAY("Sunday", 1),
    MONDAY("Monday", 2),
    TUESDAY("Tuesday", 3),
    WEDNESDAY("Wednesday", 4),
    THURSDAY("Thursday", 5),
    FRIDAY("Friday", 6),
    SATURDAY("Saturday", 7);

    private String day;
    private int dayPos;
    Day(String day, int dayPos){
        this.day = day;
        this.dayPos = dayPos;
    }

    public String getDay(){
        return this.day;
    }

    public int getDayPos(){
        return this.dayPos;
    }
}
