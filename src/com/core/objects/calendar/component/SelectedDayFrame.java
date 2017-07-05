package com.core.objects.calendar.component;

import com.core.objects.calendar.data.Event;
import com.core.objects.component.CustomButton;
import com.core.objects.component.CustomGridPane;
import com.core.objects.component.CustomLabel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


/**
 * Created by agaspari on 6/28/2017.
 */
public class SelectedDayFrame extends CustomGridPane{
    private CustomLabel lblCurrentDate, lblEvents;
    private CustomButton btnAddEvent;
    private CustomGridPane eventDisplay;
    private ListView<String> listViewName, listViewDesc;
    private int day, month, year; //TODO: Maybe switch int day to Day day and int month to Month month
    public SelectedDayFrame(int day, int month, int year){
        super();
        this.day = day;
        this.month = month;
        this.year = year;
        ObservableList<String> names = FXCollections.observableArrayList();//TODO: Get rid of this?
        ObservableList<String> descs = FXCollections.observableArrayList();//TODO: Get rid of this?
        listViewName = new ListView<>(names);
        listViewName.setPrefWidth(Double.MAX_VALUE);
        listViewDesc = new ListView<>(descs);
        listViewDesc.setPrefWidth(Double.MAX_VALUE);
        /*eventDisplay = new CustomGridPane();
        eventDisplay.setGridLinesVisible(true);
        eventDisplay.addColumns(3);
        eventDisplay.addRow(4);//*/

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
        add(listViewName, 0, 1, 1, 4);
        add(listViewDesc, 2, 1, 1, 4);
    }

    public void setCurrentDay(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        lblCurrentDate.setText(month + "/" + day + "/" + year);
    }

    public void addEvent(Event event){
       /* CustomLabel tempLabel1 = new CustomLabel(event.getName());
        CustomLabel tempLabel2 = new CustomLabel(event.getDesc());
        eventDisplay.add(tempLabel1, 0, 0);
        eventDisplay.add(tempLabel2, 0, 1);//*/
       listViewName.getItems().add(event.getName());
       listViewDesc.getItems().add(event.getDesc());
    }

    public void clear(){
        listViewName.getItems().clear();
        listViewDesc.getItems().clear();
    }
}
