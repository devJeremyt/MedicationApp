package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.Reminder;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InstructionsView {

    @FXML
    private TextArea instructionsTextArea;
    
    @FXML
    private void initialize() {
    	
    }
    
    public void setInstructions(Reminder reminder) {
    	this.instructionsTextArea.setText(reminder.getPrescription().getInstructions());
    }

}
