package com.core.objects.calendar.data;

/**
 * Created by agaspari on 6/28/2017.
 */
public class Event {
    private String name, desc;
    private int day, month, year;
    private Delimiter del;
    public Event(String name, String desc, int day, int month, int year){
        this(name, desc, day, month);
        this.year = year;
    }

    public Event(String name, String desc, int day, int month){
        this.name = name;
        this.desc = desc;
        this.day = day;
        this.month = month;
    }

    public Event(String name, String desc, Delimiter del){
        this.name = name;
        this.desc = desc;
        this.del = del;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Delimiter getDel() {
        return del;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDel(Delimiter del) {
        this.del = del;
    }

    public boolean hasDelimiter(){
        return del == null;
    }
}
