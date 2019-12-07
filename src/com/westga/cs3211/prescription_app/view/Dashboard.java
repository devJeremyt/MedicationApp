package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The code behind for the Dashboard fxml view.
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
	private Button addSideEffectButton;
	
	@FXML
    private Button viewRemindersButton;
	
	@FXML
	private Button removeButton;

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

	}

	@FXML
	private void initialize() {
		this.viewmodel = new PrescriptionAppViewModel();
		this.updateButton.disableProperty().set(true);
		this.viewDetailsButton.disableProperty().set(true);
		this.removeButton.disableProperty().set(true);
		this.setupBinding();
		this.setupListeners();

	}

	private void setupListeners() {
		this.prescriptionListView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (newValue != null) {
						this.updateButton.disableProperty().set(false);
						this.viewDetailsButton.disableProperty().set(false);
						this.removeButton.disableProperty().set(false);
					} else {
						this.updateButton.disableProperty().set(true);
						this.viewDetailsButton.disableProperty().set(true);
						this.removeButton.disableProperty().set(false);
					}
				});

	}

	private void setupBinding() {
		this.prescriptionListView.itemsProperty().bindBidirectional(this.viewmodel.prescriptionListProperty());
//		this.updateButton.disableProperty().bind(this.viewmodel.emptyPrescriptionList().or(this.prescriptionListView.getSelectionModel().selectedItemProperty().isNull()));
//		this.viewDetailsButton.disableProperty().bind(this.viewmodel.emptyPrescriptionList().or(this.prescriptionListView.getSelectionModel().selectedItemProperty().isNull()));
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
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NewMed.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			newPrescriptionModal.setScene(scene);
			newPrescriptionModal.initOwner(this.addButton.getScene().getWindow());
			newPrescriptionModal.initModality(Modality.APPLICATION_MODAL);
			NewMed newMed = loader.getController();
			newMed.bindViews(this.viewmodel);
			newPrescriptionModal.showAndWait();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Opens the NewMed Modal Dialog
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void openUpdateMedDialog() {
		try {
			Stage newPrescriptionModal = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("UpdateMed.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			newPrescriptionModal.setScene(scene);
			newPrescriptionModal.initOwner(this.updateButton.getScene().getWindow());
			newPrescriptionModal.initModality(Modality.APPLICATION_MODAL);
			UpdateMed updateMed = loader.getController();
			updateMed.bindViews(this.viewmodel, this.prescriptionListView.getSelectionModel().getSelectedItem());
			newPrescriptionModal.showAndWait();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	/**
	 * Opens the View Details Modal Dialog
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void openViewDetailsDialog() {
		try {
			Stage viewDetailsModal = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ViewDetails.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			viewDetailsModal.setScene(scene);
			viewDetailsModal.initOwner(this.updateButton.getScene().getWindow());
			viewDetailsModal.initModality(Modality.APPLICATION_MODAL);
			ViewDetails details = loader.getController();
			details.bind(this.prescriptionListView.getSelectionModel().getSelectedItem());
			viewDetailsModal.showAndWait();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	@FXML
	private void removeMedication() {
		this.viewmodel.removePrescription(this.prescriptionListView.getSelectionModel().getSelectedItem());
	}
	
	/**
	 * Opens the ViewSideEffects Modal Dialog
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void openViewSideEffectsDialog() {
		try {
			Stage viewSideEffectsModal = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ViewSideEffects.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			viewSideEffectsModal.setScene(scene);
			viewSideEffectsModal.initOwner(this.addButton.getScene().getWindow());
			viewSideEffectsModal.initModality(Modality.APPLICATION_MODAL);
			ViewSideEffects viewEffects = loader.getController();
			viewEffects.bindViews(this.viewmodel);
			viewSideEffectsModal.showAndWait();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
    @FXML
    void openRemindersView(ActionEvent event) {
    	this.viewmodel.updateRemindersBeingDisplayed();
    	try {
			Stage viewRemindersModal = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Reminders.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			viewRemindersModal.setScene(scene);
			viewRemindersModal.initOwner(this.viewRemindersButton.getScene().getWindow());
			viewRemindersModal.initModality(Modality.APPLICATION_MODAL);
			Reminders viewReminders = loader.getController();
			viewReminders.bindViews(this.viewmodel);
			viewRemindersModal.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
