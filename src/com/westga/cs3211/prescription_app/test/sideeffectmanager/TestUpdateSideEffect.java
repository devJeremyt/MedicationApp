package com.westga.cs3211.prescription_app.test.sideeffectmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.model.SideEffectManager;
import com.westga.cs3211.prescription_app.resources.StaticFields;

class TestUpdateSideEffect {

	@Test
	void testSuccessfulUpdateDescription() {

		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Limb", time);
		manager.add(sideEffect);
		
		manager.update(sideEffect, "Missing Leg", time);
		
		assertEquals("Missing Leg", manager.getSideEffects().get(0).getDescription());
		assertEquals(time.format(StaticFields.DATETIMEFORMAT), manager.getSideEffects().get(0).getTime());
		
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
	void testSuccessfulUpdateTime() {

		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Limb", time);
		manager.add(sideEffect);
		
		time = LocalDateTime.of(2019, 12, 6, 2, 50);
		
		manager.update(sideEffect, "Missing Limb", time);
		
		assertEquals("Missing Limb", manager.getSideEffects().get(0).getDescription());
		assertEquals(time.format(StaticFields.DATETIMEFORMAT), manager.getSideEffects().get(0).getTime());
		
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
	void testDescriptionEmpty()	{
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Limb", time);
		manager.add(sideEffect);
		
		
		assertThrows(IllegalArgumentException.class, ()->manager.update(sideEffect, "", LocalDateTime.of(2019, 12, 5, 2, 50)));
		
		
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
	void testDescriptionNull()	{
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Limb", time);
		manager.add(sideEffect);
		
		
		assertThrows(IllegalArgumentException.class, ()->manager.update(sideEffect, null, LocalDateTime.of(2019, 12, 5, 2, 50)));
		
		
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
	void testSideEffectNull()	{
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Limb", time);
		manager.add(sideEffect);
		
		
		assertThrows(IllegalArgumentException.class, ()->manager.update(sideEffect, "Blindness", null));
		
		
		// Rewrites the test file to be blank.
		try {
			PrintWriter eraser = new PrintWriter(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects1.csv");
			eraser.write("");
			eraser.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
