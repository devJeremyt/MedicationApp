package com.westga.cs3211.prescription_app.test.sideeffectmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
import com.westga.cs3211.prescription_app.datatier.PrescriptionFileWriter;
import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.model.SideEffectManager;
import com.westga.cs3211.prescription_app.resources.StaticFields;

class TestAddSideEffect {

	@Test
	void testSucessfullyAdded() {
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		
		SideEffect sideEffect = new SideEffect("Missing Limb", time);
		
		manager.add(sideEffect);
		
		//Test the List<Side Effect>
		assertEquals("Missing Limb", manager.getSideEffects().get(0).getDescription());
		assertEquals(time.format(StaticFields.DATETIMEFORMAT), manager.getSideEffects().get(0).getTime());
		
		List<SideEffect> singleSideEffect = PrescriptionFileReader.readSideEffectsCSV(new File(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv"));
		
		//Test it was added to the csv file
		assertEquals("Missing Limb", singleSideEffect.get(0).getDescription());
		assertEquals(time.format(StaticFields.DATETIMEFORMAT), singleSideEffect.get(0).getTime());
		
		// Rewrites the test file to be blank.
		try {
			PrintWriter eraser = new PrintWriter(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
			eraser.write("");
			eraser.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@Test
	void testNullSideEffect() {
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects2.csv");
		
		assertThrows(IllegalArgumentException.class, ()-> manager.add(null));
	}

}
