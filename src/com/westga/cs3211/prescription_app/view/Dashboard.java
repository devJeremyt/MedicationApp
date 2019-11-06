package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The code behind for the Dashboard fxml view
 * 
 * @author Jeremy Trimble
 * @version 11/4/2019
 *
 */
public class Dashboard {
	
    @FXML
    private ListView<Prescription> prescriptionListView;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button viewDetailsButton;
    
    private PrescriptionAppViewModel viewmodel;
    
    /**
     * Creates a new code behind for the Dashboard
     * 
     * @precondition none
     * @postcondition new code behind object exist
     * 
     */
    public Dashboard() {
    	this.viewmodel = new PrescriptionAppViewModel();
    }
    
    @FXML
    private void initialize() {
    	this.setupBinding();
    	this.setupListeners();

    }

	private void setupListeners() {
		this.prescriptionListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
			if (newValue == null) {
				this.updateButton.disableProperty().set(true);
				this.viewDetailsButton.disableProperty().set(true);
			} else {
				this.updateButton.disableProperty().set(false);
				this.viewDetailsButton.disableProperty().set(false);
			}
		});
		
	}

	private void setupBinding() {
		this.prescriptionListView.itemsProperty().bindBidirectional(this.viewmodel.prescriptionListProperty());
		this.updateButton.disableProperty().bind(this.viewmodel.emptyPrescriptionList().or(this.prescriptionListView.getSelectionModel().selectedItemProperty().isNull()));
		this.viewDetailsButton.disableProperty().bind(this.viewmodel.emptyPrescriptionList().or(this.prescriptionListView.getSelectionModel().selectedItemProperty().isNull()));
	}
	
	/**
	 * Opens the NewMed Modal Dialog
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void openNewMedDialog() {
		try {
			Stage newPrescriptionModal = new Stage();
			Pane pane = FXMLLoader.load(getClass().getResource("NewMed.fxml"));
			Scene scene = new Scene(pane);
			newPrescriptionModal.setScene(scene);
			newPrescriptionModal.initOwner(this.addButton.getScene().getWindow());
			newPrescriptionModal.initModality(Modality.APPLICATION_MODAL);
			newPrescriptionModal.showAndWait();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	

}
