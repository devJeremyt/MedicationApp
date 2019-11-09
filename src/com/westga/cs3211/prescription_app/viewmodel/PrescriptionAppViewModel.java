package com.westga.cs3211.prescription_app.viewmodel;

import com.westga.cs3211.prescription_app.model.Prescription;
import com.westga.cs3211.prescription_app.model.PrescriptionManager;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * The viewmodel object for the Prescription App
 * 
 * @author Jeremy Trimble
 * @version 11/3/2019
 *
 */
public class PrescriptionAppViewModel {
	
	private PrescriptionManager manager;
	private ListProperty<Prescription> prescriptionListProperty;
	private BooleanProperty emptyPrescriptionList;
	
	/**
	 * Creates a new PrescriptionAppViewModel
	 * 
	 * @precondition none
	 * @postcondition new PrescriptionAppViewModel is created
	 * 
	 */
	public PrescriptionAppViewModel() {
		this.manager = new PrescriptionManager();
		this.prescriptionListProperty = new SimpleListProperty<Prescription>();
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.manager.getPrescriptions()));
		this.emptyPrescriptionList = new SimpleBooleanProperty(true);
	}


	/**
	 * Boolean Property for if the list of prescription is empty
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true if the list is empty else false
	 */
	public BooleanProperty emptyPrescriptionList() {
		return this.emptyPrescriptionList;
	}

	/**
	 * Updates the specified prescription to the list of prescriptions
	 * 
	 * @precondition none
	 * @postcondition the specified prescription is added to the list of prescriptions
	 * 
	 * @param prescription the prescription to be added
	 * @param renewFrequency the frequency to renew
	 * @param dosageCount the count of current doses
	 * @param refillDosageCount the number of doses that come in a refill
	 * @param instructions describes how to take the prescription
	 */
	public void updatePrescription(Prescription prescription, int renewFrequency, int dosageCount, int refillDosageCount, String instructions) {
		this.manager.update(prescription, renewFrequency, dosageCount, refillDosageCount, instructions);
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.manager.getPrescriptions()));
	}

	/**
	 * Updates the specified prescription
	 * 
	 * @precondition none
	 * @postcondition the specified prescription is added to the list of prescriptions
	 * 
	 * @param prescription the prescription to be added
	 */
	public void addPrescription(Prescription prescription) {
		this.manager.add(prescription);
		this.prescriptionListProperty.set(FXCollections.observableArrayList(this.manager.getPrescriptions()));
	}
	
	/**
	 * Returns the Prescription List Property
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the prescription list property
	 */
	public ListProperty<Prescription> prescriptionListProperty() {
		return this.prescriptionListProperty;
	}
	
	
}
