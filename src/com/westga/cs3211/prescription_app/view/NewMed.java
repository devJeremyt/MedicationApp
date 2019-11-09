package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
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
    private Button addBtn;

    @FXML
    private Button cancelBtn;
    
    private PrescriptionAppViewModel viewmodel;
    
    
    /**
     * Sets the viewmodel
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    
    
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
    		String name = this.name.getText();
        	boolean avoidDriving = this.avoidDrivingCheck.isPressed();
        	boolean withoutAlcohol = this.withoutAlcoholCheck.isPressed();
        	boolean withFood = this.withFoodCheck.isPressed();
        	int renewFrequency = Integer.parseInt(this.refillsPerRenew.getText());
        	int dosageCount = Integer.parseInt(this.dosage.getText());
        	int dosesPerRefill = Integer.parseInt(this.dosesPerRefill.getText());
        	String instructions = this.instructions.getText();
        	
        	Prescription prescription = new Prescription(name, avoidDriving, withoutAlcohol, withFood, renewFrequency, dosageCount, dosesPerRefill, instructions);
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
