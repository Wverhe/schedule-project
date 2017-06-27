package com.core.objects.frames;

import com.core.objects.calendar.component.Day;
import com.core.objects.component.CustomButton;
import com.core.objects.component.CustomGridPane;
import com.core.objects.component.CustomLabel;

import java.util.ArrayList;

/**
 * Created by agaspari on 6/27/2017.
 */
public class CalendarFrame extends CustomGridPane {
    private ArrayList<CustomButton> dayButtons;
    private Day[] days = Day.values();

    public CalendarFrame(int StartDay, int Month){
        super();
        dayButtons = new ArrayList<>();
        addColumns(7);
        addRows(7);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 7; j++){
                dayButtons.add(new CustomButton(String.valueOf(dayButtons.size() + 1), days[j]));
            }
        }

        add(new CustomButton("Previous"), 0, 0);
        add(new CustomButton("Next"), 6, 0);
        add(new CustomLabel("$Month$"), 4, 0);
        add(new CustomLabel("$Year$"), 2, 0);
        for(int i = 0; i < days.length; i++){
            add(new CustomLabel(days[i].getDay()), i, 1);
        }

        int yIndex = 2;

        for(int i = 0; i < dayButtons.size(); i++){
            add(dayButtons.get(i), dayButtons.get(i).getDay().getDayPos() - 1, yIndex);
            if(dayButtons.get(i).getDay().getDayPos() % 7 == 0){
                yIndex++;
            }
        }
    }
}
