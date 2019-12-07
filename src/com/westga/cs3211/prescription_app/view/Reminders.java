package com.westga.cs3211.prescription_app.view;

import com.westga.cs3211.prescription_app.model.Reminder;
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
 * The public class Reminders
 * 
 * @author michael jiles
 *
 */
public class Reminders {

	@FXML
	private ListView<Reminder> remindersListView;

	@FXML
	private Button viewInstructionsButton;
	
    @FXML
    private Button makeInactiveButton;

	@FXML
	private Button confirmMedTakenButton;

	private PrescriptionAppViewModel viewmodel;

	@FXML
	private void initialize() {
		this.viewInstructionsButton.disableProperty().set(true);
		this.confirmMedTakenButton.disableProperty().set(true);

		this.remindersListView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (newValue != null) {
						this.viewInstructionsButton.disableProperty().set(false);
						this.confirmMedTakenButton.disableProperty().set(false);
					} else {
						this.viewInstructionsButton.disableProperty().set(true);
						this.confirmMedTakenButton.disableProperty().set(true);
					}
				});
	}

	@FXML
	void confirmMedTaken(ActionEvent event) {
		this.viewmodel.confirmMedTaken(this.remindersListView.getSelectionModel().getSelectedItem());
	}
	
    @FXML
    void makeMedInactive(ActionEvent event) {
    	this.viewmodel.makeMedInactive(this.remindersListView.getSelectionModel().getSelectedItem());
    }

	@FXML
	void openInstructionsWindow(ActionEvent event) {
		try {
			Stage viewInstructions = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("InstructionsView.fxml"));
			loader.load();
			Pane pane = loader.getRoot();
			Scene scene = new Scene(pane);
			viewInstructions.setScene(scene);
			viewInstructions.initOwner(this.viewInstructionsButton.getScene().getWindow());
			viewInstructions.initModality(Modality.APPLICATION_MODAL);
			InstructionsView instructionsView = loader.getController();
			instructionsView.setInstructions(this.remindersListView.getSelectionModel().getSelectedItem());
			viewInstructions.showAndWait();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Carries information from previous view to this one
	 * 
	 * @precondition none
	 * @postcondition viewmodel is updated to be the passed in one.
	 * 
	 * @param viewmodel the view model
	 */
	public void bindViews(PrescriptionAppViewModel viewmodel) {
		this.viewmodel = viewmodel;
		this.remindersListView.itemsProperty().bindBidirectional(this.viewmodel.reminderListProperty());
	}

}
