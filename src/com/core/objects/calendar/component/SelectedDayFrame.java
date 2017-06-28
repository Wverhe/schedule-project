package com.core.objects.calendar.component;

import com.core.objects.component.CustomButton;
import com.core.objects.component.CustomGridPane;
import com.core.objects.component.CustomLabel;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;

/**
 * Created by agaspari on 6/28/2017.
 */
public class SelectedDayFrame extends CustomGridPane{
    private CustomLabel lblCurrentDate, lblEvents;
    private CustomButton btnAddEvent;
    private ListView listView;
    private int day, month, year; //TODO: Maybe switch int day to Day day and int month to Month month
    public SelectedDayFrame(int day, int month, int year){
        super();
        this.day = day;
        this.month = month;
        this.year = year;
        /*setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");//*/
        addColumns(3);
        addRows(6);
        lblCurrentDate = new CustomLabel(month + "/" + day + "/" + year);
        btnAddEvent = new CustomButton("Add Event");
        btnAddEvent.setOnMouseClicked(
            e ->{
                Stage tempStage = new Stage();
                tempStage.setTitle("Add Event");
                tempStage.setScene(new Scene(new EventEditor(), 250, 250));
                tempStage.show();
            }
        );
        add(lblCurrentDate, 1, 0);
        add(btnAddEvent, 0, 5, 1, 1);
    }

    public void setCurrentDay(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        lblCurrentDate.setText(month + "/" + day + "/" + year);
    }
}
