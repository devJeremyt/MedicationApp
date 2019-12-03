package com.westga.cs3211.prescription_app.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The UpdateSideEffect Code Behind
 * 
 * @author Jeremy Trimble
 * @version 12/2/2019
 *
 */
public class UpdateSideEffect {
 	@FXML
    private DatePicker dateField;

    @FXML
    private TextField hourField;

    @FXML
    private TextField minuteField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;
    
	private PrescriptionAppViewModel viewmodel;
	private SideEffect sideEffect;

	/**
	 * Goes back to previous screen
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param event not used
	 */
	public void cancel(ActionEvent event) {
    	this.cancelButton.getScene().getWindow().hide();
    }

    /**
     * Updates the SideEffect
     * 
     * @preconditions none
     * @postconditions none
     * 
     * @param event not used
     */
    public void updateSideEffect(ActionEvent event) {
    	LocalDate date = this.dateField.getValue();
		LocalTime time = LocalTime.of(Integer.parseInt(this.hourField.getText()), Integer.parseInt(this.minuteField.getText()));
		LocalDateTime dateTime = LocalDateTime.of(date, time);
    	this.viewmodel.updateSideEffect(this.sideEffect, this.descriptionTextArea.getText(), dateTime);
		this.updateButton.getScene().getWindow().hide();
    }
	
    /**
     * Binds the viewmodel between views
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param viewmodel the viewmodel from the parent page
     * @param sideEffect the sideEffect being updated
     * 
     */
	public void bindViews(PrescriptionAppViewModel viewmodel, SideEffect sideEffect) {
		this.viewmodel = viewmodel;
		this.sideEffect = sideEffect;
		this.dateField.setValue(sideEffect.getDate());
		this.hourField.setText(String.valueOf(sideEffect.getTime().getHour()));
		this.minuteField.setText(String.valueOf(sideEffect.getTime().getMinute()));
		this.descriptionTextArea.setText(sideEffect.getDescription());
	}

}
