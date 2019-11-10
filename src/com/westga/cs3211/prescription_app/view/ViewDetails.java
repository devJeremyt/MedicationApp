package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Prescription;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * The code behind class for the ViewDetails Page
 * 
 * @author Jeremy Trimble
 * @version 11/10/2019
 *
 */
public class ViewDetails {

    @FXML
    private AnchorPane doseCountLabel;

    @FXML
    private TextArea instructionsTxtArea;

    @FXML
    private Button viewRecordBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label prescriptionNameLbl;

    @FXML
    private ListView<String> recordsListView;

    @FXML
    private Label doseCountLbl;

    @FXML
    private Label withFoodLbl;

    @FXML
    private Label avoidDrivingLbl;

    @FXML
    private Label withoutAlcoholLbl;

    @FXML
    private Label refillCountLbl;

   /***
    * 
    * Closes the current window to go back to the previous page
    * 
    * @precondition none
    * @postcondition User is back at the previous window
    * 
    * @param event not used
    */
    public void back(ActionEvent event) {
    	this.backBtn.getScene().getWindow().hide();
    }

    /**
     * Opens another view with details on specific record
     * 
     * @precondition Record is selected in the listview on the page
     * @postcondition new window is popped with the details of the record
     * 
     * @param event not used
     */
    public void viewRecord(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText("View Details not available");
    	alert.setTitle("View Details not available");
    	alert.setContentText("This feature has not been implemented yet.");
    	
    	alert.showAndWait();
    	
    }
    
    /**
     * Bind prescription from the view that spawned this window
     * 
     * @precondition prescription != null
     * @postcondition all fields are populated with prescription's information
     * 
     * @param prescription the prescription we are getting information about
     */
    public void bind(Prescription prescription) {
    	
		this.prescriptionNameLbl.setText(prescription.getName());
		this.avoidDrivingLbl.setText(String.valueOf(prescription.getAvoidDriving()));
		this.withoutAlcoholLbl.setText(String.valueOf(prescription.getWithoutAlcohol()));
		this.withFoodLbl.setText(String.valueOf(prescription.getWithFood()));
		this.doseCountLbl.setText(String.valueOf(prescription.getDosageCount()));
		this.refillCountLbl.setText(String.valueOf(prescription.getRenewFrequency()));
		this.instructionsTxtArea.textProperty().set(prescription.getInstructions());
    }
    
}
