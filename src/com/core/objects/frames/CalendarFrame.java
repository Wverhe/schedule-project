package com.core.objects.frames;

import com.core.objects.calendar.component.Day;
import com.core.objects.calendar.component.Month;
import com.core.objects.component.CustomButton;
import com.core.objects.component.CustomGridPane;
import com.core.objects.component.CustomLabel;
import javafx.scene.control.Button;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by agaspari on 6/27/2017.
 */
public class CalendarFrame extends CustomGridPane {
    private ArrayList<CustomButton> dayButtons;
    private Day[] days = Day.values();
    private Month[] months = Month.values();
    private Calendar cal;
    private YearMonth yearMonth;
    String month, year;
    int startDay;

    public CalendarFrame(){
        super();
        cal = Calendar.getInstance();
        month = months[cal.get(Calendar.MONTH)].getMonth();
        year = String.valueOf(cal.get(Calendar.YEAR));
        yearMonth = YearMonth.of(Integer.parseInt(year), cal.get(Calendar.MONTH) + 1);
        LocalDate firstOfMonth = yearMonth.atDay(1);
        startDay = firstOfMonth.getDayOfWeek().getValue() - 1;

        dayButtons = new ArrayList<>();
        addColumns(7);
        addRows(7);

        for(int i = 0; i < yearMonth.atEndOfMonth().getDayOfMonth(); i++){
            dayButtons.add(new CustomButton(String.valueOf(dayButtons.size() + 1), days[i%7]));
        }

        add(new CustomButton("Previous"), 2, 0);
        add(new CustomButton("Next"), 4, 0);
        add(new CustomLabel(month + " - " + year), 3, 0);
        for(int i = 0; i < days.length; i++){
            add(new CustomLabel(days[i].getDay()), i, 1);
        }

        int yIndex = 2;

        for(int i = 0; i < dayButtons.size(); i++){
            System.out.println("Text: " + dayButtons.get(i).getText());
            int xIndex = dayButtons.get(i).getDay().getDayPos();
            xIndex += startDay;
            if(xIndex > 6){
                xIndex = xIndex - 7;
            }
            if(xIndex % 7 == 0){
                yIndex++;
            }
            System.out.println(xIndex + " - " + yIndex);
            System.out.println("Position: " + dayButtons.get(i).getDay().getDayPos());
            add(dayButtons.get(i), xIndex, yIndex);
        }
    }
}
