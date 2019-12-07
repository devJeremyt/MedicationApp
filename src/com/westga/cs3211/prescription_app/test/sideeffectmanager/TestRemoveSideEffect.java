package com.westga.cs3211.prescription_app.test.sideeffectmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.SideEffect;
import com.westga.cs3211.prescription_app.model.SideEffectManager;

class TestRemoveSideEffect {

	@Test
	void testSuccessfullyRemoved() {
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects4.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 7, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Leg", time);
		manager.add(sideEffect);
		
		assertEquals(1,manager.getSideEffects().size());
		
		manager.remove(sideEffect);
		
		assertEquals(0, manager.getSideEffects().size());
		
		// Rewrites the test file to be blank.
		try {
			PrintWriter eraser = new PrintWriter(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects4.csv");
			eraser.write("");
			eraser.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testNullSideEffect() {
		SideEffectManager manager = new SideEffectManager(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects4.csv");
		LocalDateTime time = LocalDateTime.of(2019, 12, 7, 2, 50);
		SideEffect sideEffect = new SideEffect("Missing Leg", time);
		manager.add(sideEffect);
		
		assertEquals(1,manager.getSideEffects().size());
		
		assertThrows(IllegalArgumentException.class, ()->manager.remove(null));
		
		// Rewrites the test file to be blank.
		try {
			PrintWriter eraser = new PrintWriter(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\sideeffectmanager\\testSideEffects4.csv");
			eraser.write("");
			eraser.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
