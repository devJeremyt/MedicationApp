package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The UpdateMed Class. This is the code behind for the UpdateMed FXML
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
    private CheckBox monday;

    @FXML
    private CheckBox tuesday;

    @FXML
    private CheckBox wednesday;

    @FXML
    private CheckBox thursday;

    @FXML
    private CheckBox friday;

    @FXML
    private CheckBox saturday;

    @FXML
    private CheckBox sunday;

    @FXML
    private TextField hour;

    @FXML
    private TextField minute;

    @FXML
    private RadioButton am;

    @FXML
    private RadioButton pm;

    @FXML
    private TextArea instructions;

    @FXML
    private Button updateBtn;

    @FXML
    private Button cancelBtn;

    private PrescriptionAppViewModel viewmodel;
    
    
    
    
    /**
     * Updates the prescription displayed
     * 
     * @precondition none
     * @postcondition prescription is update to the values that were changed
     * 
     * @param event not used
     */
    public void updatePrescription(ActionEvent event) {

    	this.updateBtn.getScene().getWindow().hide();
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
     * @param viewmodel the viewmodel from the parent page
     * @param prescription the prescription that is being altered
     * 
     */
	public void bindViews(PrescriptionAppViewModel viewmodel, Prescription prescription) {
		this.viewmodel = viewmodel;
		
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

