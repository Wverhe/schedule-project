package com.core.objects.calendar.component;

import com.core.objects.component.CustomButton;
import com.core.objects.component.CustomGridPane;
import com.core.objects.component.CustomLabel;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Created by agaspari on 6/28/2017.
*/
public class EventEditor extends CustomGridPane{
    CustomLabel lblName, lblDesc, lblReoccurring;
    TextField txtName, txtDesc;
    DatePicker datePicker;
    CheckBox chkReoccurring;
    CustomButton btnSave, btnCancel;
    public EventEditor(){
        addColumns(2);
        lblName = new CustomLabel("Name: ");
        lblDesc = new CustomLabel("Description: ");
        lblReoccurring = new CustomLabel("Reoccurring: ");
        txtName = new TextField();
        txtDesc = new TextField();
        chkReoccurring = new CheckBox();
        datePicker = new DatePicker();
        datePicker.setPrefWidth(Double.MAX_VALUE);
        btnSave = new CustomButton("Save");
        btnCancel = new CustomButton("Cancel");
        add(lblName, 0, 0);
        add(txtName, 1, 0);
        add(lblDesc, 0, 1);
        add(txtDesc, 1, 1);
        add(datePicker, 0, 2, 2, 1);
        add(lblReoccurring, 0, 3);
        add(chkReoccurring, 1, 3);
        add(btnSave, 0, 4);
        add(btnCancel, 1, 4);
    }
}
