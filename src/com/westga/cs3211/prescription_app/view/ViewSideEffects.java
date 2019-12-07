package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.viewmodel.PrescriptionAppViewModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The code behind for the View Side Effects page
 * 
 * @author Jeremy Trimble
 * @version 12/2/2019
 *
 */
public class ViewSideEffects {

    @FXML
    private ListView<SideEffect> sideEffectListView;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button viewSideEffectButton;
	
	private PrescriptionAppViewModel viewmodel;


	@FXML
	private void initialize() {
		this.updateButton.disableProperty().set(true);
		this.removeButton.disableProperty().set(true);
		this.viewSideEffectButton.disableProperty().set(true);
		this.setupListeners();

	}

	private void setupListeners() {
		this.sideEffectListView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (newValue != null) {
						this.updateButton.disableProperty().set(false);
						this.removeButton.disableProperty().set(false);
						this.viewSideEffectButton.disableProperty().set(false);
					} else {
						this.updateButton.disableProperty().set(true);
						this.removeButton.disableProperty().set(true);
						this.viewSideEffectButton.disableProperty().set(true);
					}
				});

	}


	/**
	 * Opens the NewMed Modal Dialog
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	public void openNewSideEffectDialog() {
		try {
			Stage newSideEffectsModal = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NewSideEffect.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			newSideEffectsModal.setScene(scene);
			newSideEffectsModal.initOwner(this.addButton.getScene().getWindow());
			newSideEffectsModal.initModality(Modality.APPLICATION_MODAL);
			NewSideEffect newSideEffect = loader.getController();
			newSideEffect.bindViews(this.viewmodel);
			newSideEffectsModal.showAndWait();

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
	public void openUpdateSideEffectDialog() {
		try {
			Stage updateSideEffectModal = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("UpdateSideEffect.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			updateSideEffectModal.setScene(scene);
			updateSideEffectModal.initOwner(this.updateButton.getScene().getWindow());
			updateSideEffectModal.initModality(Modality.APPLICATION_MODAL);
			UpdateSideEffect updateSideEffect = loader.getController();
			updateSideEffect.bindViews(this.viewmodel, this.sideEffectListView.getSelectionModel().getSelectedItem());
			updateSideEffectModal.showAndWait();

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
	public void openViewSideEffectPopUp() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setHeaderText(this.sideEffectListView.getSelectionModel().getSelectedItem().getFormattedDateTime());
    	alert.setTitle("View details of Side Effect");
    	alert.setContentText(this.sideEffectListView.getSelectionModel().getSelectedItem().getDescription());
    	alert.showAndWait();

	}
	
	@FXML
	private void removeSideEffect() {
		this.viewmodel.removeSideEffect(this.sideEffectListView.getSelectionModel().getSelectedItem());
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
		this.sideEffectListView.itemsProperty().bindBidirectional(this.viewmodel.sideEffectListProperty());
	}



}
