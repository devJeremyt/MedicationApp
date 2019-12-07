package com.westga.cs3211.prescription_app.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The UpdateMed Class. This is the code behind for the UpdateMed FXML
 * 
 * @author Jeremy Trimble
 * @version 11/8/2019
 * 
 */
public class UpdateMed {


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
    private CheckBox withFoodCheck;
    
    @FXML
    private TextField hour;

    @FXML
    private TextField minute;

    @FXML
    private TextArea instructions;

    @FXML
    private Button updateBtn;

    @FXML
    private Button cancelBtn;
    
    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Label interationDays;
    
    @FXML
    private DatePicker updatedDate;

    private PrescriptionAppViewModel viewmodel;
    private Prescription prescriptionToUpdate;
    
    
    
    
    /**
     * Updates the prescription displayed
     * 
     * @precondition none
     * @postcondition prescription is update to the values that were changed
     * 
     * @param event not used
     */
    public void updatePrescription(ActionEvent event) {
    	
    	int renewFrequency = Integer.parseInt(this.refillsPerRenew.getText());
    	int dosageCount = Integer.parseInt(this.dosage.getText());
    	int refillDosageCount = Integer.parseInt(this.dosesPerRefill.getText());
    	String instructions = this.instructions.getText();
    	this.updateReminder();

    	this.viewmodel.updatePrescription(this.prescriptionToUpdate, renewFrequency, dosageCount, refillDosageCount, instructions);

    	this.updateBtn.getScene().getWindow().hide();
    }
    
    private void updateReminder() {
    	LocalDate startDate = this.updatedDate.getValue();
		int hour = Integer.parseInt(this.hour.getText());
		int minute = Integer.parseInt(this.minute.getText());
		LocalTime time = LocalTime.of(hour, minute);
		LocalDateTime dateTime = LocalDateTime.of(startDate, time);
		int daysBetween = Integer.parseInt(this.interationDays.getText());
		//TODO
		// Add method call for updating reminder
		
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
     * Binds the viewmodel between views
     * 
     * @precondition none
     * @postcondition none
     * 
     * @param prescription the prescription that is being altered
     * @param viewmodel the viewmodel for the Prescription app
     * 
     */
	public void bindViews(PrescriptionAppViewModel viewmodel, Prescription prescription) {
		this.viewmodel = viewmodel;
		this.prescriptionToUpdate = prescription;
		
		this.name.setText(prescription.getName());
		this.avoidDrivingCheck.selectedProperty().set(prescription.getAvoidDriving());
		this.withoutAlcoholCheck.selectedProperty().set(prescription.getWithoutAlcohol());
		this.withFoodCheck.selectedProperty().set(prescription.getWithFood());
		this.refillsPerRenew.textProperty().set(String.valueOf(prescription.getRenewFrequency()));
		this.dosage.textProperty().set(String.valueOf(prescription.getDosageCount()));
		this.dosesPerRefill.textProperty().set(String.valueOf(prescription.getRefillDosageCount()));
		this.instructions.textProperty().set(prescription.getInstructions());
	}

}

