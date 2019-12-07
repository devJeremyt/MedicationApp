package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Reminder;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * The Class InstructionsView.
 * @author michael jiles
 */
public class InstructionsView {

    /** The instructions text area. */
    @FXML
    private TextArea instructionsTextArea;
 
    
    /**
     * Sets the instructions.
     *
     * @param reminder the new instructions
     */
    public void setInstructions(Reminder reminder) {
    	this.instructionsTextArea.setText(reminder.getPrescription().getInstructions());
    }

}
