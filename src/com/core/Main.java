package com.core;

import com.core.objects.calendar.component.CalendarFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private GridPane root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new CalendarFrame();
        primaryStage.setTitle("Calendar Schedule v0.5.1");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
