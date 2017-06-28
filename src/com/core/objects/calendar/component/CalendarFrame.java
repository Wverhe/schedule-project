package com.core.objects.calendar.component;

import com.core.objects.calendar.component.SelectedDayFrame;
import com.core.objects.calendar.data.Day;
import com.core.objects.calendar.data.Event;
import com.core.objects.calendar.data.Month;
import com.core.objects.component.CustomButton;
import com.core.objects.component.CustomGridPane;
import com.core.objects.component.CustomLabel;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by agaspari on 6/27/2017.
 */
public class CalendarFrame extends CustomGridPane {
    private ArrayList<CustomButton> dayButtons;
    private Day[] days = Day.values();
    private Month[] months = Month.values();
    private Calendar cal;
    private YearMonth yearMonth;
    private CustomButton btnNext, btnPrevious;
    private CustomLabel lblMonthYear;
    private int startDay, startMonth, startYear;
    private int currentMonth, currentYear;
    private SelectedDayFrame selectedFrame;
    int today;

    public CalendarFrame(){
        super();
        cal = Calendar.getInstance();
        startMonth = cal.get(Calendar.MONTH);
        startYear = cal.get(Calendar.YEAR);
        currentMonth = startMonth;
        currentYear = startYear;
        selectedFrame = new SelectedDayFrame(cal.get(Calendar.DAY_OF_MONTH), startMonth, startYear);
        dayButtons = new ArrayList<>();
        addColumns(10);
        addRows(8);
        btnPrevious = new CustomButton("Previous");
        btnPrevious.setOnMouseClicked(
            e -> {
                if(currentMonth == 0){
                    currentMonth = 11;
                    currentYear--;
                }else{
                    currentMonth--;
                }
                setCalendar(currentMonth, currentYear);
                e.consume();
            }
        );
        //TODO: See if old projects are onMouseClick or onAction
        btnNext = new CustomButton("Next");
        btnNext.setOnMouseClicked(
            e -> {
                if(currentMonth == 11){
                    currentMonth = 0;
                    currentYear++;
                }else{
                    currentMonth++;
                }
                setCalendar(currentMonth, currentYear);
                e.consume();
            }
        );
        lblMonthYear = new CustomLabel(months[currentMonth].getMonth() + " - " + currentYear);
        add(btnPrevious, 2, 0);
        add(btnNext, 4, 0);
        add(lblMonthYear, 3, 0);
        add(selectedFrame, 7, 1, 3, 6);
        setCalendar(startMonth, startYear);
    }

    private void setCalendar(int month, int year){
        for(int i = 0; i < dayButtons.size(); i++){
            getChildren().remove(dayButtons.get(i));
        }
        dayButtons.clear();//TODO: Make not clear everytime
        yearMonth = YearMonth.of(year, month + 1);
        LocalDate firstOfMonth = yearMonth.atDay(1);
        startDay = firstOfMonth.getDayOfWeek().getValue() - 1;
        today = cal.get(Calendar.DAY_OF_MONTH);
        for(int i = 0; i < yearMonth.atEndOfMonth().getDayOfMonth(); i++){
            CustomButton tempButton = new CustomButton(String.valueOf(i + 1), days[i%7]);
            tempButton.setOnMouseClicked(
                e -> {
                    selectedFrame.setCurrentDay(Integer.parseInt(tempButton.getText()), currentMonth, currentYear);
                    e.consume();
                }
            );
            if(i + 1 == today && month == startMonth){
                tempButton.setActive(true);
            }
            dayButtons.add(tempButton);
        }

        int yIndex = 2;
        for(int i = 0; i < dayButtons.size(); i++){
            int xIndex = dayButtons.get(i).getDay().getDayPos();
            xIndex += startDay;
            if(xIndex > 6){
                xIndex = xIndex - 7;
            }
            if(xIndex % 7 == 0){
                yIndex++;
            }
            add(dayButtons.get(i), xIndex, yIndex);
        }

        lblMonthYear.setText(months[month].getMonth() + " - " + year);
        for(int i = 0; i < days.length; i++){
            add(new CustomLabel(days[i].getDay()), i, 1);
        }
    }

    private Event[] getEvents(int day, int month, int year){
        //getSavedEvents();
        return new Event[]{};
    }
}
