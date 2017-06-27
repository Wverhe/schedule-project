package com.core.objects.calendar.component;

/**
 * Created by agaspari on 6/27/2017.
 */
public enum Month {
    JANUARY("January", 1),
    FEBRUARY("February", 2),
    MARCH("March", 3),
    APRIL("April", 4),
    MAY("May", 5),
    JUNE("June", 6),
    JULY("July", 7),
    AUGUST("Auguest", 8),
    SEPTEMBER("September", 9),
    OCTOBER("October", 10),
    NOVEMBER("November", 11),
    DECEMBER("December", 12);

    private String month;
    private int monthPos;
    Month(String month, int monthPos){
        this.month = month;
        this.monthPos = monthPos;
    }

    public String getMonth(){
        return this.month;
    }

    public int getMonthPos() { return this.monthPos; }
}
