package com.core.objects.component;

import com.core.objects.calendar.data.Day;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

/**
 * Created by agaspari on 6/20/2017.
 */
public class CustomButton extends Button{
    private Day day;
    private boolean currentDay;

    public CustomButton(String text, Day day){
        this(text);
        this.day = day;
        setPrefHeight(Double.MAX_VALUE);
    }

    public CustomButton(String text) {
        super(text);
        setTextFill(Color.WHITE);
        setFont(javafx.scene.text.Font.font("Tahoma", FontWeight.BOLD, 10));
        setPrefWidth(Double.MAX_VALUE);
        setStyle("-fx-background-color: #1d8893; -fx-border-radius: 4px;");
        setCursor(Cursor.HAND);

        //TODO: Check if can remove all setStyle on CurrentDay
        setOnMouseEntered(
            e -> {
                if(currentDay){
                    setStyle("fx-background-color: #616263;");
                }else{
                    setStyle("-fx-background-color: #27b6c4");
                }
                e.consume();
            }
        );

        setOnMouseExited(
            e -> {
                if(currentDay){
                    setStyle("fx-background-color: #616263;");
                }else {
                    setStyle("-fx-background-color: #1d8893;");
                }
                e.consume();
            }
        );

        setOnMousePressed(
            e -> {
                if(currentDay){
                    setStyle("fx-background-color: #616263;");
                }else {
                    setStyle("-fx-background-color: #2bcbdb");
                }
                e.consume();
            }
        );

        setOnMouseReleased(
            e -> {
                if(currentDay){
                    setStyle("fx-background-color: #616263;");
                }else{
                    setStyle("-fx-background-color: #27b6c4");
                }
                e.consume();
            }
        );
    }

    public Day getDay(){
        return day;
    }

    public void setActive(boolean state){
        currentDay = state;
        if(state){
            setTextFill(Color.rgb(130, 130, 130));
            setStyle("fx-background-color: #616263;");
        }else{
            setTextFill(Color.WHITE);
            setStyle("-fx-background-color: #1d8893;");
        }
    }

    public boolean isDay(){
        return day != null;
    }
}