package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Reminder;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Reminders {

    @FXML
    private ListView<Reminder> remindersListView;

    @FXML
    private Button viewInstructionsButton;
    
    private PrescriptionAppViewModel viewmodel;
    
    @FXML
	private void initialize() {
    	this.viewmodel = new PrescriptionAppViewModel();
    	this.setupBindings();
    }

    @FXML
    void openInstructionsWindow(ActionEvent event) {

    }
    
    private void setupBindings() {
    	this.remindersListView.itemsProperty().bindBidirectional(this.viewmodel.reminderListProperty());
    }

}
