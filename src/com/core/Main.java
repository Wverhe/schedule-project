package com.core;

import com.core.objects.frames.CalendarFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private GridPane root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new CalendarFrame(0, 0);

        primaryStage.setTitle("Calendar Schedule v0.0.1");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
