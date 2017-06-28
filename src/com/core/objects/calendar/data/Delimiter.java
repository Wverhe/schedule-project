package com.core.objects.calendar.data;

/**
 * Created by agaspari on 6/28/2017.
 */
public class Delimiter {
    public static final int FIRST = 1, SECOND = 2, THIRD = 3, FOURTH = 4;
    private Day day;
    private Month month;
    private int placement;//TODO: Change "Placement"
    public Delimiter(Day day, Month month, int placement){
        this.day = day;
        this.month = month;
        this.placement = placement;
    }

    public Day getDay(){
        return day;
    }

    public int getPlacement(){
        return placement;
    }
}
