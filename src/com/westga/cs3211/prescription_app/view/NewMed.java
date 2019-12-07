package com.westga.cs3211.prescription_app.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The Code Behind Class for the NewMed Page
 * 
 * @author Jeremy Trimble
 * @version 11/5/2019
 *
 */
public class NewMed {

	@FXML
    private TextField name;

    @FXML
    private TextField dosage;

    @FXML
    private TextField refillsPerRenew;

    @FXML
    private TextField dosesPerRefill;

    @FXML
    private CheckBox avoidDrivingCheck;

    @FXML
    private CheckBox withoutAlcoholCheck;

    @FXML
    private DatePicker startDate;
    
    @FXML
    private CheckBox withFoodCheck;

    @FXML
    private TextField hour;

    @FXML
    private TextField minute;

    @FXML
    private TextArea instructions;

    @FXML
    private Button addBtn;

    @FXML
    private Button cancelBtn;
    
    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Label interationDays;
    
    private PrescriptionAppViewModel viewmodel;
    
	/**
     * Adds a prescription to the list of Prescriptions
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param event not used
     */
    public void addPrescription(ActionEvent event) {
    	try {
    		Prescription prescription = this.createPrescription();
    		this.createReminder(prescription);
        	this.viewmodel.addPrescription(prescription);   

        	this.addBtn.getScene().getWindow().hide();
        	
    	} catch (Exception e) {
    		System.err.println(e.getMessage());
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Adding Prescription");
    		alert.setHeaderText("An Error occured while adding Prescription");
    		alert.setContentText("An error prevented the new Prescription from being added, please try again");
    		alert.showAndWait();
    	}
    	
    }

	private Prescription createPrescription() {
		String name = this.name.getText();
		boolean avoidDriving = this.avoidDrivingCheck.isPressed();
		boolean withoutAlcohol = this.withoutAlcoholCheck.isPressed();
		boolean withFood = this.withFoodCheck.isPressed();
		int renewFrequency = Integer.parseInt(this.refillsPerRenew.getText());
		int dosageCount = Integer.parseInt(this.dosage.getText());
		int dosesPerRefill = Integer.parseInt(this.dosesPerRefill.getText());
		String instructions = this.instructions.getText();
		
		Prescription prescription = new Prescription(name, avoidDriving, withoutAlcohol, withFood, renewFrequency, dosageCount, dosesPerRefill, instructions);
		return prescription;
	}
	
	private void createReminder(Prescription prescription) {
		LocalDate startDate = this.startDate.getValue();
		int hour = Integer.parseInt(this.hour.getText());
		int minute = Integer.parseInt(this.minute.getText());
		LocalTime time = LocalTime.of(hour, minute);
		LocalDateTime dateTime = LocalDateTime.of(startDate, time);
		int daysBetween = Integer.parseInt(this.interationDays.getText());
		this.viewmodel.addReminder(prescription, dateTime, daysBetween);
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
    	this.cancelBtn.getScene().getWindow().hide();
    }

    /**
     * Increments the iteration days up by one
     * 
     * @precondition none
     * @postcondition iteration days is one more
     * 
     * 
     */
    public void increaseIterationDays() {
    	int days = Integer.parseInt(this.interationDays.getText());
    	days++;
    	this.interationDays.setText(String.valueOf(days));
    }
    
    /**
     * Decrements the iteration days down by one
     * 
     * @precondition none
     * @postcondition iteration days is one less
     * 
     * 
     */
    public void decreaseIterationDays() {
    	int days = Integer.parseInt(this.interationDays.getText());
    	if (days > 1) {
    		days--;
    	}
    	this.interationDays.setText(String.valueOf(days));
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
