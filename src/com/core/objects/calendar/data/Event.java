package com.core.objects.calendar.data;

/**
 * Created by agaspari on 6/28/2017.
 */
public enum Event {
    CHRISTMAS("Christmas", "Christian Holiday", 25, 12),
    MOTHERSDAY("Mothers Day", "Mothers Day", new Delimiter(Day.SUNDAY, Month.MAY, Delimiter.SECOND));

    private String name, desc;
    private int day, month, year;
    private Delimiter del;
    Event(String name, String desc, int day, int month, int year){
        this(name, desc, day, month);
        this.year = year;
    }

    Event(String name, String desc, int day, int month){
        this.name = name;
        this.desc = desc;
        this.day = day;
        this.month = month;
    }

    Event(String name, String desc, Delimiter del){
        this.name = name;
        this.desc = desc;
        this.del = del;
    }
}
