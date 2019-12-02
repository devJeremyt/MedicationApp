package com.westga.cs3211.prescription_app.model;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
import com.westga.cs3211.prescription_app.datatier.PrescriptionFileWriter;
import com.westga.cs3211.prescription_app.resources.ExceptionMessages;

/**
 * The SideEffectManager Class
 * 
 * 
 * @author Jeremy
 * @version 12/1/2019
 * 
 */
public class SideEffectManager {

	private List<SideEffect> sideEffects;
	private File storageFile;
	
	
	/**
	 * Creates a new SideEffectManager
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param storageFileLocation a string value of of the file location to store sideEffect data
	 */
	public SideEffectManager(String storageFileLocation) {
		this.storageFile = new File(storageFileLocation);
		this.sideEffects = PrescriptionFileReader.readSideEffectsCSV(this.storageFile);
	}

	/**
	 * Adds a new sideEffect to the list of sideEffects
	 * @return 
	 * 
	 * @precondition sideEffect != null
	 * @postcondition this.sideEffects.size() == this.sideEffects@prev + 1
	 * 
	 * @param sideEffect the sideEffect being added
	 * 
	 * @return true if the SideEffect was added, else false
	 */
	public boolean add(SideEffect sideEffect) {
		if (sideEffect == null) {
			throw new IllegalArgumentException(ExceptionMessages.SIDEEFFECT_NOT_NULL);
		}
		
		PrescriptionFileWriter.addSideEffectToCSV(this.storageFile, sideEffect);
		return this.sideEffects.add(sideEffect);
	}
	
	/**
	 * Updates the specified SideEffect with the description and time provided
	 * 
	 * @precondition !description.isEmpty() && description != null && time != null
	 * @postcondition SideEffect has given description and time
	 * 
	 * @param description the description to be updated
	 * @param time the time to be updated
	 * @param sideEffect the sideEffect being updated
	 * 
	 */
	public void update(SideEffect sideEffect, String description, LocalDateTime time) {
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.DESCRIPTION_NOT_EMPTY);
		}
		if (time == null) {
			throw new IllegalArgumentException(ExceptionMessages.TIME_NOT_NULL);
		}
		
		sideEffect.setDescription(description);
		sideEffect.setTime(time);
	}
	
	/**
	 * Removes the sideEffect specified
	 * 
	 * @precondition sideEffect != null
	 * @postcondition this.sideEffects.size() == this.sideEffects@prev - 1
	 * 
	 * @return true if the sideEffect was removed else false
	 * 
	 * @param sideEffect the sideEffect being updated
	 */
	public boolean remove(SideEffect sideEffect) {
		if (sideEffect == null) {
			throw new IllegalArgumentException(ExceptionMessages.SIDEEFFECT_NOT_NULL);
		}
		
		return this.sideEffects.remove(sideEffect);
	}

	/**
	 * Returns the list of sideEffects
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of sideEffects
	 * 
	 */
	public List<SideEffect> getSideEffects() {
		return this.sideEffects;
	}
	
	/**
	 * Returns the file the sideEffects are saved to.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the file the side effects are saved to
	 */
	public File getStorageFile() {
		return this.storageFile;
	}
	
	
}
