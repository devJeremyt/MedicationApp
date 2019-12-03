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
 * The NewSideEffect Code Behind
 * 
 * @author Jeremy Trimble
 * @version 12/2/2019
 *
 */
public class NewSideEffect {
	
    @FXML
    private DatePicker dateField;
	
	@FXML
    private TextField hourField;

    @FXML
    private TextField minuteField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

	
	private PrescriptionAppViewModel viewmodel;
	
	/**
	 * Initializes value of fields to current date and time
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public void initialize() {
		this.dateField.setValue(LocalDate.now());
		this.hourField.setText(String.valueOf(LocalTime.now().getHour()));
		this.minuteField.setText(String.valueOf(LocalTime.now().getMinute()));
	}
	
	/**
	 * Adds a sideEffect to the list of SideEffects
	 * 
	 * @precondition none
	 * @postcondition new sideEffect is listed in the list
	 * 
	 * @param event not used
	 */
	public void addSideEffect(ActionEvent event) {
		String description = this.descriptionTextArea.getText();
		LocalDate date = this.dateField.getValue();
		LocalTime time = LocalTime.of(Integer.parseInt(this.hourField.getText()), Integer.parseInt(this.minuteField.getText()));
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		SideEffect sideEffect = new SideEffect(description, dateTime);
		this.viewmodel.addSideEffect(sideEffect);
		this.addButton.getScene().getWindow().hide();
	}
	
    /**
     * Cancels the action and returns user to the previous screen
     * 
     * @precondition none
     * @postcondition window is closed
     *
     * @param event not used
     */
    public void cancel(ActionEvent event) {
    	this.cancelButton.getScene().getWindow().hide();
    }
    /**
     * Binds the viewmodel between views
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param viewmodel the viewmodel from the parent page
     * 
     */
	public void bindViews(PrescriptionAppViewModel viewmodel) {
		this.viewmodel = viewmodel;
	}
}
